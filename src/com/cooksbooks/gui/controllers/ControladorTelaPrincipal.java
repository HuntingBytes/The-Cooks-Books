package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import com.cooksbooks.gui.TiposPesquisas;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
  void handleAcessarCaderno(ActionEvent event) {
    if (listViewCadernos.getSelectionModel().getSelectedItem() != null) {
      screenManager.abrirTelaCaderno(listViewCadernos.getSelectionModel().getSelectedItem());
    } else {
      alertSelecionarItem("um caderno");
    }
  }

  @FXML
  void handleAcessarReceita(ActionEvent event) {
    if (listViewReceitas.getSelectionModel().getSelectedItem() != null) {
      screenManager.abrirTelaReceitaModal(listViewReceitas.getSelectionModel().getSelectedItem());
    } else {
      alertSelecionarItem("uma receita");
    }
  }

  @FXML
  private void handleCriarCaderno() throws IOException {
    screenManager.abrirTelaCriacaoCaderno();
  }

  @FXML
  private void handleMostrarPerfil() {
    this.screenManager.abrirTelaPerfil(this.sistema.getUsuarioLogado());
  }

  @FXML
  private void handlePesquisar() {
    if (choiceBoxPesquisa.getValue() != null) {
      screenManager.abrirTelaResultadosPesquisa(textFieldPesquisa.getText(), choiceBoxPesquisa.getValue());
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
}