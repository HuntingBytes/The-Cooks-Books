package com.cooksbooks.gui.controllers;

import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Ingrediente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ControladorTelaReceita {

  private Receita receita;

  @FXML
  private Label lbNomeReceita;

  @FXML
  private TextArea taModoPreparo;

  @FXML
  private Button btVoltar;

  @FXML
  private Button btEditarReceita;

  @FXML
  private ListView<Ingrediente> lvIngredientes;

  @FXML
  private ListView<Receita> lvCategoriasReceita;

  @FXML
  private Label lbexetensoTempoPrep;

  @FXML
  private Label lbextensoCusto;

  @FXML
  private Label lbextensoRendimento;

  @FXML
  private Label lbextensoDificuldade;

  @FXML
  void handleEditarReceita(ActionEvent event) {

  }

  @FXML
  void handleVoltar(ActionEvent event) {

  }
  public void setReceita(Receita receita) {
    this.receita = receita;
  }
}


