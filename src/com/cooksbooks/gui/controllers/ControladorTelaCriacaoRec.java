package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.entity.utils.TempoPreparo;
import com.cooksbooks.gui.ScreenManager;
import java.io.IOException;
import java.util.ArrayList;
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
import javafx.stage.Stage;

public class ControladorTelaCriacaoRec {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  private String idCadernoDono;

  @FXML
  private TextArea taModoPreparo;

  @FXML
  private Button btFechar;

  @FXML
  private Button btCriarRec;

  @FXML
  private TextField tfTituloRec;

  @FXML
  private ChoiceBox<Custo> cbCustoMedio;

  @FXML
  private ChoiceBox<TempoPreparo> cbTempoPreparo;

  @FXML
  private ChoiceBox<Rendimento> cbRendimento;

  @FXML
  private ChoiceBox<Dificuldade> cbDificul;

  @FXML
  private ListView<Categoria> lvAddCat;

  @FXML
  private ListView<Ingrediente> lvIngredientes;

  @FXML
  private Button btAdicionarIngrediente;

  @FXML
  private Button brRemoverIngrediente;

  @FXML
  private Label lbErro;

  public void setIdCadernoDono(String idCadernoDono) {
    this.idCadernoDono = idCadernoDono;
    this.btAdicionarIngrediente.setDisable(true);
    this.btAdicionarIngrediente.setVisible(false);
  }

  @FXML
  public void initialize() {
    this.cbCustoMedio.getItems().addAll(Custo.values());
    this.cbDificul.getItems().addAll(Dificuldade.values());
    this.cbRendimento.getItems().addAll(Rendimento.values());
    this.cbTempoPreparo.getItems().addAll(TempoPreparo.values());
    this.lvAddCat.getItems().addAll(Categoria.values());
  }

  @FXML
  private void handleVoltar() {
    clearTodosCampos();
    ((Stage) this.btFechar.getScene().getWindow()).close();
  }

  @FXML
  private void handleAdicionarIngrediente() {
    ScreenManager.getInstancia().abrirTelaCriacaoIngrediente(this.lvIngredientes.getItems());
  }

  @FXML
  private void handleRemoverIngrediente() {
    if (lvIngredientes.getSelectionModel().getSelectedItem() != null) {
      lvIngredientes.getItems().remove(lvIngredientes.getSelectionModel().getSelectedIndex());
    }
  }

  @FXML
  private void handleCriarReceita() {
    if (this.areCamposValidos()) {
      String nomeReceita = this.tfTituloRec.getText();
      String modoPreparo = this.taModoPreparo.getText();
      List<Ingrediente> ingredientes = new ArrayList<>(this.lvIngredientes.getItems());

      Custo custoMedio = this.cbCustoMedio.getValue();
      Dificuldade dificuldade = this.cbDificul.getValue();
      Rendimento rendimento = this.cbRendimento.getValue();
      TempoPreparo tempoPreparo = this.cbTempoPreparo.getValue();
      List<Categoria> categorias = new ArrayList<>(this.lvAddCat.getItems());

      Receita receita = new Receita();
      receita.setIdCadernoDono(idCadernoDono);
      receita.setTitulo(nomeReceita);
      receita.setModoPreparo(modoPreparo);
      receita.setIngredientes(ingredientes);
      receita.setCusto(custoMedio);
      receita.setRendimento(rendimento);
      receita.setDificuldade(dificuldade);
      receita.setTempoPreparo(tempoPreparo);
      receita.setCategorias(categorias);

      sistema.cadastrarReceita(receita, this.idCadernoDono);
      this.clearTodosCampos();
    }
    else {
      this.alertCamposInvalidos();
    }
  }

  private boolean areCamposValidos(){
    String tituloReceita = this.tfTituloRec.getText();
    String modoPreparo = this.taModoPreparo.getText();
    //Como seria essa criaçao ingredientes ????
    //String ingredientes = this.textAreaAddIng.getText();

    Custo custoSelec = this.cbCustoMedio.getValue();
    Dificuldade dificuldadeSelec = this.cbDificul.getValue();
    Rendimento rendimentoSelc = this.cbRendimento.getValue();
    TempoPreparo tempoPreparoSelc = this.cbTempoPreparo.getValue();
    List<Categoria> categoriasSelec = this.lvAddCat.getItems();

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

    String tituloReceita = this.tfTituloRec.getText();
    String modoPreparo = this.taModoPreparo.getText();
    //Como seria essa criaçao ingredientes ????
    //String ingredientes = this.textAreaAddIng.getText();

    Custo custoSelec = this.cbCustoMedio.getValue();
    Dificuldade dificuldadeSelec = this.cbDificul.getValue();
    Rendimento rendimentoSelc = this.cbRendimento.getValue();
    TempoPreparo tempoPreparoSelc = this.cbTempoPreparo.getValue();
    List<Categoria> categoriasSelec = this.lvAddCat.getItems();

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
    this.tfTituloRec.clear();
    //this.taAddIng.clear();
    this.taModoPreparo.clear();
    this.cbCustoMedio.getSelectionModel().clearSelection();
    this.cbRendimento.getSelectionModel().clearSelection();
    this.cbDificul.getSelectionModel().clearSelection();
    this.cbTempoPreparo.getSelectionModel().clearSelection();
    this.lvAddCat.getSelectionModel().clearSelection();
  }
}
