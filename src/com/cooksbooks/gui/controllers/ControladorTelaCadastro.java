package com.cooksbooks.gui.controllers;

import com.cooksbooks.utils.ExperienciaCulinaria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro {

  @FXML
  private TextField tfLogin;

  @FXML
  private TextField tfSenha;

  @FXML
  private TextField tfConfirmarSenha;

  @FXML
  private ChoiceBox<ExperienciaCulinaria> cbExperienciaCulinaria;

  @FXML
  private Button btCadastrar;

  @FXML
  private Button btVoltar;

}
