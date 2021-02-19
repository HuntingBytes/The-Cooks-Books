package com.cooksbooks.gui.controllers;

import com.cooksbooks.entity.utils.Ingrediente;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorTelaCriacaoIngr {

  private ObservableList<Ingrediente> obIngredientes;

  @FXML
  private TextField tfNome;

  @FXML
  private TextField tfQuantidade;

  @FXML
  private Button btAdicionar;

  @FXML
  private Label lbErro;

  @FXML
  private void handleAdicionar() {
    if (areCamposValidos()) {
      Ingrediente ingrediente = new Ingrediente(tfNome.getText(), Integer.parseInt(tfQuantidade.getText()), 0.0);
      obIngredientes.add(ingrediente);
      clearCampos();
      ((Stage) btAdicionar.getScene().getWindow()).close();
    } else {
      lbErro.setText("Campos inválidos!");
      lbErro.setVisible(true);
    }
  }

  private boolean areCamposValidos() {
    boolean nomeIsBlank = tfNome.getText() == null || tfNome.getText().isBlank();
    boolean quantidadeIsInvalida = tfQuantidade.getText() == null || tfQuantidade.getText().isBlank();
    return !nomeIsBlank && !quantidadeIsInvalida;
  }

  private void clearCampos() {
    this.tfNome.setText("");
    this.tfQuantidade.setText("");
    this.obIngredientes = null;
    this.lbErro.setVisible(false);
  }

  public void setObIngredientes(ObservableList<Ingrediente> obIngredientes) {
    this.obIngredientes = obIngredientes;
  }
}
