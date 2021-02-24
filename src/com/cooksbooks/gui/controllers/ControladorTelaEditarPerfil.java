package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.gui.ScreenManager;
import javafx.beans.value.ObservableStringValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladorTelaEditarPerfil {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private Usuario usuarioDoPerfil;
  private ScreenManager screenManager;

  @FXML
  private ImageView ivImagemUsuario;

  @FXML
  private Label lbNomeUsuario;

  @FXML
  private Label lbExperiencia;

  @FXML
  private Label lbAlterarNome;

  @FXML
  private TextField tfDigitarNome;

  @FXML
  private Button btAlterarNome;

  @FXML
  private Label lbAlterarExperiencia;

  @FXML
  private Button btAlterarExperiencia;

  @FXML
  private ChoiceBox<ExperienciaCulinaria> cbEscolherExperiencia;

  @FXML
  private Button btVoltar;

  @FXML
  private Label lbAlterarSobre;

  @FXML
  private TextArea taDigitarSobre;

  @FXML
  private Button btAlterarSobre;

  @FXML
  private Button btSalvarPerfil;

  @FXML
  public void initialize() {
    this.cbEscolherExperiencia.getItems().addAll(ExperienciaCulinaria.values());
  }

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  public void inicializar() {
    this.lbNomeUsuario.setText(usuarioDoPerfil.getNomePerfil());
    this.lbExperiencia.setText(usuarioDoPerfil.getExperienciaCulinaria().toString());
  }

  //Tem que ter algum lbErro para indicar as mudanças sendo feitas para o usuario
  @FXML
  void handleAlterarExperiencia(ActionEvent event) {
    ExperienciaCulinaria expCulinaria = cbEscolherExperiencia.getSelectionModel().getSelectedItem();
    if (expCulinaria != null) {
      try {
        sistema.alterarExperiencia(usuarioDoPerfil.getLogin(), expCulinaria);
      } catch (UsuarioInexistente | CampoInvalido e) {
        e.printStackTrace();
      }
    }
    this.inicializar();
  }

  @FXML
  void handleAlterarNome(ActionEvent event) {
    try {
      sistema.alterarNomePerfil(usuarioDoPerfil.getLogin(), tfDigitarNome.getText());
    } catch (UsuarioInexistente | CampoInvalido e) {
      e.printStackTrace();
    }
  }

  @FXML
  void handleAlterarSobreMim(ActionEvent event) {
    try {
      sistema.alterarBiografia(usuarioDoPerfil.getLogin(), taDigitarSobre.getText());
    } catch (UsuarioInexistente | CampoInvalido e) {
      e.printStackTrace();
    }
    this.inicializar();
  }

  @FXML
  void handleSalvar(ActionEvent event) {

    String nomeMudado = tfDigitarNome.getText();
    String sobreMimMudado = taDigitarSobre.getText();

    if (!nomeMudado.isBlank()) {
      handleAlterarNome(event);
    }
    if (!sobreMimMudado.isBlank()) {
      handleAlterarSobreMim(event);
    }
    if (cbEscolherExperiencia.getSelectionModel().getSelectedItem() != null) {
      handleAlterarExperiencia(event);
    }
    this.inicializar();
  }

  @FXML
  void handleVoltar(ActionEvent event) {
    screenManager.abrirTelaPerfil(usuarioDoPerfil);
    this.usuarioDoPerfil = null;
    this.clearCampos();
  }

  @FXML
  private void handleCancelar() {
    // O quê esse método deveria fazer?
  }

  public void setUsuarioDoPerfil(Usuario usuarioDoPerfil) {
    this.usuarioDoPerfil = usuarioDoPerfil;
  }

  private void clearCampos() {
    this.tfDigitarNome.setText("");
    this.taDigitarSobre.setText("");
    this.cbEscolherExperiencia.getSelectionModel().clearSelection();
    this.lbExperiencia.setText("Experiência Culinária");
    this.lbNomeUsuario.setText("Nome do Usuário");
  }
}
