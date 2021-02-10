package com.cooksbooks.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorTelaRelatorio {

  @FXML
  private TextField tfDataInicioRelatorio;

  @FXML
  private TextField tfDataFinalRelatorio;

  @FXML
  private Button btGerar;

  @FXML
  private ListView<?> lvResultadoPesquisaRelatorio;

  @FXML
  private Button btFecharRelatorio;
}
