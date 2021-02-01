package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.entity.utils.TempoPreparo;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

  @FXML
  private void handleVoltar() {
    //chamar App para mudar de tela
  }

  @FXML
  private void handleCriarReceita() {
    if (this.areCamposValidos()) {
      String nomeReceita = this.textFieldTituloRec.getText();
      String modoPreparo = this.textAreaModoPreparo.getText();
      //Como seria essa criaçao ingredientes ????
      //String ingredientes = this.textAreaAddIng.getText();

      Custo custoMedio = this.choiceBoxCustoMedio.getValue();
      Dificuldade dificuldade = this.choiceBoxDificul.getValue();
      Rendimento rendimento = this.choiceBoxRendimento.getValue();
      TempoPreparo tempoPreparo = this.choiceBoxTempoPreparo.getValue();
      List<Categoria> categorias = this.listViewAddCat.getItems();

      Receita receita = new Receita();
      //receita.setIdCadernoDono();
      receita.setTitulo(nomeReceita);
      receita.setModoPreparo(modoPreparo);
      //receita.setIngredientes();
      receita.setCusto(custoMedio);
      receita.setDificuldade(dificuldade);
      receita.setTempoPreparo(tempoPreparo);
      receita.setCategorias(categorias);

      sistema.cadastrarReceita(receita,receita.getIdCadernoDono());

      this.clearTodosCampos();
      this.labelErro.setText("Receita " + nomeReceita + " Cadastrada!");
    }
    else {
      this.alertCamposInvalidos();
    }
  }

  private boolean areCamposValidos(){
    String tituloReceita = this.textFieldTituloRec.getText();
    String modoPreparo = this.textAreaModoPreparo.getText();
    //Como seria essa criaçao ingredientes ????
    //String ingredientes = this.textAreaAddIng.getText();

    Custo custoSelec = this.choiceBoxCustoMedio.getValue();
    Dificuldade dificuldadeSelec = this.choiceBoxDificul.getValue();
    Rendimento rendimentoSelc = this.choiceBoxRendimento.getValue();
    TempoPreparo tempoPreparoSelc = this.choiceBoxTempoPreparo.getValue();
    List<Categoria> categoriasSelec = this.listViewAddCat.getItems();

    boolean tituloReceitaBlank = tituloReceita == null || tituloReceita.isBlank();
    boolean modoPreparoBlank =  modoPreparo == null || modoPreparo.isBlank();
    //boolean ingredientesBlank =  ingredientes == null || ingredientes.isBlank();
    boolean categoriasBlank = categoriasSelec == null || categoriasSelec.isEmpty();

    return !tituloReceitaBlank && !modoPreparoBlank && !categoriasBlank && custoSelec!=null && dificuldadeSelec!=null &&
        rendimentoSelc!=null && tempoPreparoSelc!=null;
  }

  private void alertCamposInvalidos(){
    StringBuilder textToPrint = new StringBuilder();
    textToPrint.append("Favor Rever o(s) Campo(s): ");

    String tituloReceita = this.textFieldTituloRec.getText();
    String modoPreparo = this.textAreaModoPreparo.getText();
    //Como seria essa criaçao ingredientes ????
    //String ingredientes = this.textAreaAddIng.getText();

    Custo custoSelec = this.choiceBoxCustoMedio.getValue();
    Dificuldade dificuldadeSelec = this.choiceBoxDificul.getValue();
    Rendimento rendimentoSelc = this.choiceBoxRendimento.getValue();
    TempoPreparo tempoPreparoSelc = this.choiceBoxTempoPreparo.getValue();
    List<Categoria> categoriasSelec = this.listViewAddCat.getItems();

    if (tituloReceita == null || modoPreparo.isBlank()) {
      textToPrint.append("\"Titulo Receita\"");
    }
    if (modoPreparo == null || modoPreparo.isBlank()) {
      textToPrint.append("\"Modo Preparo\"; ");
    }
    /*
    if (ingredientes == null || ingredientes.isBlank()) {
      textToPrint.append("\"Ingredientes\"; ");
    }
    */
    if (custoSelec == null) {
      textToPrint.append("\"Custo\"; ");
    }
    if (dificuldadeSelec == null) {
      textToPrint.append("\"Dificuldade\"; ");
    }
    if (rendimentoSelc == null) {
      textToPrint.append("\"Rendimento\"; ");
    }
    if (tempoPreparoSelc == null) {
      textToPrint.append("\"TempoPreparo\"; ");
    }
    if (categoriasSelec == null) {
      textToPrint.append("\"Categorias\"; ");
    }

    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Campos Inválidos!");
    alert.setContentText(textToPrint.toString());
    alert.showAndWait();

  }

  private void clearTodosCampos(){
    this.textFieldTituloRec.clear();
    this.textAreaAddIng.clear();
    this.textAreaModoPreparo.clear();
    this.choiceBoxCustoMedio.getSelectionModel().clearSelection();
    this.choiceBoxRendimento.getSelectionModel().clearSelection();
    this.choiceBoxDificul.getSelectionModel().clearSelection();
    this.choiceBoxTempoPreparo.getSelectionModel().clearSelection();
    this.listViewAddCat.getSelectionModel().clearSelection();
  }
}
