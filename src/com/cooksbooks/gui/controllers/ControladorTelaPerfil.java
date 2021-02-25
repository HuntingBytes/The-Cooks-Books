package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaPerfil {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private Usuario usuarioDoPerfil;
  private ScreenManager screenManager;

  @FXML
  private Label lbNomeUsuario;

  @FXML
  private Button btEditarPerfil;

  @FXML
  private TextArea taSobreMim;

  @FXML
  private TextField tfExperiencia;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  public void inicializar() {
    if (!usuarioDoPerfil.equals(sistema.getUsuarioLogado())) {
      this.btEditarPerfil.setVisible(false);
    }
    this.lbNomeUsuario.setText(usuarioDoPerfil.getNomePerfil());
    this.lbNomeUsuario.setDisable(true);
    this.taSobreMim.setText(usuarioDoPerfil.getBiografia());
    this.taSobreMim.setDisable(true);
    this.tfExperiencia.setText(usuarioDoPerfil.getExperienciaCulinaria().toString());
    this.tfExperiencia.setDisable(true);
  }

  @FXML
  void handlEditarPerfil(ActionEvent event) {
    screenManager.abrirTelaEditarPerfil(sistema.getUsuarioLogado());
  }

  @FXML
  void handleVoltar(ActionEvent event) {
    screenManager.abrirTelaPrincipal();
  }

  public void setUsuarioDoPefil(Usuario usuarioDoPefil) {
    this.usuarioDoPerfil = usuarioDoPefil;
  }
}
