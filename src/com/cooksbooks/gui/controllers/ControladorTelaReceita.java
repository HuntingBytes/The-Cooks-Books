package com.cooksbooks.gui.controllers;

import com.cooksbooks.entity.Receita;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ControladorTelaReceita {

  private Receita receita;

  @FXML
  private ListView<?> lvIngredientesTelaReceita;

  @FXML
  private ListView<?> lvModoPreparoTelaReceita;

  @FXML
  private Button btFecharTelaReceita;

  public void setReceita(Receita receita) {
    this.receita = receita;
  }
}
