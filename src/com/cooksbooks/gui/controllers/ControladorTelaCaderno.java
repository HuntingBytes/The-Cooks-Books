package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.entity.utils.TempoPreparo;
import com.cooksbooks.facilities.Telas;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaCaderno {

  private App app = new App();

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

  @FXML
  private void initialize() {


  }

  @FXML
  void handleBuscarReceita() {
  }

  @FXML
  void handleEditarCaderno() {

  }

  @FXML
  void handleVoltar() throws IOException {
    app.alterarTela(Telas.TELA_PRINCIPAL_USUARIO);
  }

}