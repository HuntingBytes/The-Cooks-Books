package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import com.cooksbooks.gui.TiposPesquisas;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ControladorTelaResultado {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;
  private String pesquisa;
  private TiposPesquisas tipoPesquisa;

  @FXML
  private ListView<Usuario> listViewResultadosUsuarios;

  @FXML
  private ListView<CadernoReceitas> listViewResultadosCadernos;

  @FXML
  private ListView<Receita> listViewResultadosReceitas;

  @FXML
  private Button botaoVoltar;

  @FXML
  private Button botaoSelecionarResult;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  @FXML
  public void initialize() {
    this.listViewResultadosUsuarios.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Usuario item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getNomePerfil(), item.getLogin()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
    this.listViewResultadosReceitas.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Receita item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getTitulo(), item.getModoPreparo()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
    this.listViewResultadosCadernos.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(CadernoReceitas item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getNomeCaderno(), item.getInformacoesCaderno()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
  }

  public void inicializar() {
    switch (this.tipoPesquisa) {
      case USUARIO -> this.setResultadosUsuarios();
      case CADERNO -> this.setResultadosCadernos();
      case RECEITA -> this.setResultadosReceita();
    }
  }

  @FXML
  public void handleSelecionarResult() {
    switch (this.tipoPesquisa) {
      case USUARIO -> this.handleSelecionarUsuario();
      case CADERNO -> this.handleSelecionarCaderno();
      case RECEITA -> this.handleSelecionarReceita();
    }
  }

  @FXML
  public void handleBotaoVoltar() {
    screenManager.abrirTelaPrincipal();
    this.clearCampos();
  }

  private void alertSelecionarItem() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Nada foi selecionado!");
    //alert.setContentText(String.format("Favor selecionar %s para acessar", item));
    alert.showAndWait();
  }

  public void setPesquisa(String pesquisa, TiposPesquisas tipoPesquisa) {
    this.pesquisa = pesquisa;
    this.tipoPesquisa = tipoPesquisa;
  }

  private void handleSelecionarUsuario() {
    Usuario usuario = listViewResultadosUsuarios.getSelectionModel().getSelectedItem();
    if (usuario != null) {
      screenManager.abrirTelaUsuarioBuscado(usuario);
    } else {
      alertSelecionarItem();
    }
  }

  private void handleSelecionarCaderno() {
    CadernoReceitas caderno = listViewResultadosCadernos.getSelectionModel().getSelectedItem();
    if (caderno != null) {
      screenManager.abrirTelaCadernoModal(caderno);
    } else {
      alertSelecionarItem();
    }
  }

  private void handleSelecionarReceita() {
    Receita receita = listViewResultadosReceitas.getSelectionModel().getSelectedItem();
    if (receita != null) {
      screenManager.abrirTelaReceitaModal(receita);
    } else {
      this.alertSelecionarItem();
    }
  }

  private void clearCampos() {
    this.listViewResultadosUsuarios.getItems().clear();
    this.listViewResultadosUsuarios.getSelectionModel().clearSelection();
    this.listViewResultadosUsuarios.setVisible(false);
    this.listViewResultadosUsuarios.setDisable(true);

    this.listViewResultadosCadernos.getItems().clear();
    this.listViewResultadosCadernos.getSelectionModel().clearSelection();
    this.listViewResultadosCadernos.setVisible(false);
    this.listViewResultadosCadernos.setDisable(true);

    this.listViewResultadosReceitas.getItems().clear();
    this.listViewResultadosReceitas.getSelectionModel().clearSelection();
    this.listViewResultadosReceitas.setVisible(false);
    this.listViewResultadosReceitas.setDisable(true);
  }

  private void setResultadosUsuarios() {
    this.clearCampos();
    List<Usuario> usuarios = this.sistema.buscarUsuariosComNome(this.pesquisa);

    if (usuarios.size() > 0) {
      this.listViewResultadosUsuarios.setItems(FXCollections.observableList(usuarios));
    } else {
      this.listViewResultadosUsuarios.setPlaceholder(new
          Label("Não foi possível encontrar nenhum usuário com esse nome."));
    }

    this.listViewResultadosUsuarios.setVisible(true);
    this.listViewResultadosUsuarios.setDisable(false);
  }

  private void setResultadosCadernos() {
    this.clearCampos();
    List<CadernoReceitas> cadernos = sistema.buscarCadernosComNome(this.pesquisa);

    if (cadernos.size() > 0) {
      this.listViewResultadosCadernos.setItems(FXCollections.observableList(cadernos));
    } else {
      this.listViewResultadosCadernos.setPlaceholder(new
          Label("Não foi possível encontrar nenhum caderno com esse nome."));
    }

    this.listViewResultadosCadernos.setVisible(true);
    this.listViewResultadosCadernos.setDisable(false);
  }

  private void setResultadosReceita() {
    this.clearCampos();
    List<Receita> receitas = sistema.buscarReceitasComTitulo(this.pesquisa);

    if (receitas.size() > 0) {
      this.listViewResultadosReceitas.setItems(FXCollections.observableList(receitas));
    } else {
      this.listViewResultadosReceitas.setPlaceholder(new
          Label("Não foi possível encontrar nenhuma receita com esse título."));
    }

    this.listViewResultadosReceitas.setVisible(true);
    this.listViewResultadosReceitas.setDisable(false);
  }
}