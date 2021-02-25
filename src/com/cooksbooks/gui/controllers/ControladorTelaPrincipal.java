package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import com.cooksbooks.gui.TiposPesquisas;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladorTelaPrincipal {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;

  @FXML
  private ListView<CadernoReceitas> listViewCadernos;

  @FXML
  private ListView<Receita> listViewReceitas;

  @FXML
  private Label mostrarPerfil;

  @FXML
  private Button botaoCriarCaderno;

  @FXML
  private Button botaoCriarReceita;

  @FXML
  private ChoiceBox<TiposPesquisas> choiceBoxPesquisa;

  @FXML
  private ImageView imagemPerfil;

  @FXML
  private Label nomeUsuario;

  @FXML
  private Label experienciaCulinaria;

  @FXML
  private TextField textFieldPesquisa;

  @FXML
  private Button botaoPesquisar;

  @FXML
  private Button botaoAcessarCaderno;

  @FXML
  private Button botaoAcessarReceita;

  @FXML
  public void initialize() {
    this.choiceBoxPesquisa.setItems(FXCollections.observableArrayList(TiposPesquisas.values()));
    this.listViewCadernos.focusedProperty().addListener((observableValue, oldVal, newVal) -> {
      if (newVal) {
        listViewReceitas.getSelectionModel().clearSelection();
      }
    });
    this.listViewReceitas.focusedProperty().addListener((observableValue, oldVal, newVal) -> {
      if (newVal) {
        listViewCadernos.getSelectionModel().clearSelection();
      }
    });
    this.listViewCadernos.setCellFactory(param -> new ListCell<CadernoReceitas>() {
      @Override
      protected void updateItem(CadernoReceitas item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null || item.getNomeCaderno() == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getNomeCaderno(), item.getInformacoesCaderno()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
    this.listViewReceitas.setCellFactory(param -> new ListCell<Receita>() {
      @Override
      protected void updateItem(Receita item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null || item.getTitulo() == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getTitulo(), item.getModoPreparo()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
  }

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  public void inicializar() {
    Usuario usuario = sistema.getUsuarioLogado();
    this.nomeUsuario.setText(usuario.getNomePerfil());
    this.experienciaCulinaria.setText(usuario.getExperienciaCulinaria().toString());
    this.listViewCadernos.setItems(FXCollections.observableArrayList(
        sistema.buscarTodosCadernosDoUsuario(usuario.getLogin())));
    this.listViewReceitas.setItems((FXCollections.observableArrayList(
        sistema.buscarTodasReceitasDoUsuario(usuario.getLogin()))));
  }

  @FXML
  private void handleEnviarRelatorio() {
    this.screenManager.abrirTelaEnviarRelatorio();
    this.clearSelections();
  }

  @FXML
  private void handleAcessarCaderno(ActionEvent event) {
    if (listViewCadernos.getSelectionModel().getSelectedItem() != null) {
      screenManager.abrirTelaCaderno(listViewCadernos.getSelectionModel().getSelectedItem());
      this.clearSelections();
    } else {
      alertSelecionarItem("um caderno");
    }
  }

  @FXML
  private void handleAcessarReceita(ActionEvent event) {
    if (listViewReceitas.getSelectionModel().getSelectedItem() != null) {
      screenManager.abrirTelaReceitaModal(listViewReceitas.getSelectionModel().getSelectedItem());
      this.clearSelections();
    } else {
      alertSelecionarItem("uma receita");
    }
  }

  @FXML
  private void handleCriarCaderno() {
    screenManager.abrirTelaCriacaoCaderno();
    this.clearCampos();
  }

  @FXML
  private void handleMostrarPerfil() {
    this.screenManager.abrirTelaPerfil(this.sistema.getUsuarioLogado());
    this.clearCampos();
  }

  @FXML
  private void handlePesquisar() {
    if (choiceBoxPesquisa.getValue() != null) {
      screenManager.abrirTelaResultadosPesquisa(textFieldPesquisa.getText(), choiceBoxPesquisa.getValue());
      this.clearCampos();
    } else {
      alertPesquisa();
    }
  }

  private void alertPesquisa() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Tipo de Pesquisa Não Informado");
    alert.showAndWait();
  }

  private void alertSelecionarItem(String item) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Nada foi Selecionado!");
    alert.setContentText(String.format("Favor selecionar %s para acessar", item));
    alert.showAndWait();
  }

  private void clearSelections() {
    this.choiceBoxPesquisa.getSelectionModel().clearSelection();
    this.listViewReceitas.getSelectionModel().clearSelection();
    this.listViewCadernos.getSelectionModel().clearSelection();
  }

  private void clearCampos() {
    this.nomeUsuario.setText("Nome Usuário");
    this.experienciaCulinaria.setText("Experiência Culinária");
    this.textFieldPesquisa.clear();
    this.choiceBoxPesquisa.getSelectionModel().clearSelection();
    this.listViewReceitas.getSelectionModel().clearSelection();
    this.listViewReceitas.getItems().clear();
    this.listViewCadernos.getSelectionModel().clearSelection();
    this.listViewCadernos.getItems().clear();
  }
}