package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.gui.Telas;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaCaderno {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  private CadernoReceitas caderno;

  @FXML
  private Label lbNomeCaderno;

  @FXML
  private TextArea taDesc;

  @FXML
  private Button btVoltar;

  @FXML
  private Button btEditarCaderno;

  @FXML
  private Button btBuscarReceita;

  @FXML
  private TextField tfReceitaBuscar;

  @FXML
  private ListView<Receita> lvResultadoBuscaReceita;

  @FXML
  private ListView<Categoria> lvCategoriasCaderno;


  private void initialize() {

    this.taDesc.setText(caderno.getInformacoesCaderno());
    this.taDesc.disableProperty();

    this.lvCategoriasCaderno.getItems().addAll(caderno.listarCategorias());
    this.lvResultadoBuscaReceita.getItems().addAll
        (sistema.listarReceitasDoCaderno(caderno.getIdCaderno()));

  }

  @FXML
  void handleBuscarReceita() {
  }

  @FXML
  void handleEditarCaderno() {
    //app.alterarTela(Telas.TELA_ALTERAR_CADERNO, this); //Talvez a telaCriacaoCaderno possa atuar aqui
  }

  @FXML
  void handleVoltar() throws IOException {
    //muda de tela
  }

  public void setCaderno(CadernoReceitas caderno) {
    this.caderno = caderno;
  }
}