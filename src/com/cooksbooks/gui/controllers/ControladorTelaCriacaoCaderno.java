package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaCriacaoCaderno {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private CheckBox cbCadernoPrivado;

  @FXML
  private Button btCriarCaderno;

  @FXML
  private TextArea taDescricaoCaderno;

  @FXML
  private TextField tfNomeCaderno;

  @FXML
  private Button btVoltar;

  @FXML
  private Label lbErro;

  @FXML
  void handleCriarCaderno(ActionEvent event) {
    sistema.cadastrarCaderno(new CadernoReceitas(
        tfNomeCaderno.getText(),
        cbCadernoPrivado.isSelected(),
        taDescricaoCaderno.getText(),
        sistema.getUsuarioLogado().getLogin()
    ));
  }

  @FXML
  void handleVoltarTelaPrin(ActionEvent event) {
    ScreenManager.getInstancia().abrirTelaPrincipal();
  }
}