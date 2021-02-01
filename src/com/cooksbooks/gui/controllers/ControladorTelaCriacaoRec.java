package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.entity.utils.TempoPreparo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaCriacaoRec {

  //private App app;

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private TextArea textAreaModoPreparo;

  @FXML
  private Button buttonVoltarRec;

  @FXML
  private Button buttonCriarRec;

  @FXML
  private TextField textFieldTituloRec;

  @FXML
  private TextArea textAreaAddIng;

  @FXML
  private ChoiceBox<Custo> choiceBoxCustoMedio;

  @FXML
  private ChoiceBox<TempoPreparo> choiceBoxTempoPreparo;

  @FXML
  private ChoiceBox<Rendimento> choiceBoxRendimento;

  @FXML
  private ChoiceBox<Dificuldade> choiceBoxDificul;

  @FXML
  private ListView<Categoria> listViewAddCat;

  @FXML
  private Label labelErro;

  @FXML
  private void initialize() {

    this.choiceBoxCustoMedio.getItems().addAll(Custo.values());
    this.choiceBoxDificul.getItems().addAll(Dificuldade.values());
    this.choiceBoxRendimento.getItems().addAll(Rendimento.values());
    this.choiceBoxTempoPreparo.getItems().addAll(TempoPreparo.values());

    this.listViewAddCat.getItems().addAll(Categoria.values());

  }
}
