package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ControladorTelaReceita {

  private Receita receita;

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  private ScreenManager screenManager;

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
  private ListView<Categoria> lvCategoriasReceita;

  @FXML
  private Label lbexetensoTempoPrep;

  @FXML
  private Label lbextensoCusto;

  @FXML
  private Label lbextensoRendimento;

  @FXML
  private Label lbextensoDificuldade;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  private void initialize() {

    this.lbNomeReceita.setText(receita.getTitulo());
    this.taModoPreparo.setText(receita.getModoPreparo());
    this.lvIngredientes.getItems().addAll(receita.listarIngredientes());
    this.lbexetensoTempoPrep.setText(receita.getTempoPreparo().toString());
    this.lbextensoCusto.setText(receita.getCusto().toString());
    this.lbextensoRendimento.setText(receita.getRendimento().toString());
    this.lbextensoDificuldade.setText(receita.getDificuldade().toString());
    this.lvCategoriasReceita.getItems().addAll(receita.listarCategorias());

  }

  @FXML
  void handleEditarReceita(ActionEvent event) {
    screenManager.abrirTelaEditarReceita(receita);
  }

  @FXML
  void handleVoltar(ActionEvent event) {
    screenManager.abrirTelaCaderno(sistema.buscarCaderno(receita.getIdCadernoDono()));
  }
  public void setReceita(Receita receita) {
    this.receita = receita;
  }
}


