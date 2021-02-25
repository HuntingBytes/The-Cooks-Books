package com.cooksbooks.gui.controllers;


import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.gui.ScreenManager;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ControladorTelaCaderno {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;
  private CadernoReceitas cadernoSelecionado;

  @FXML
  private Label lbNomeCaderno;

  @FXML
  private TextArea taDesc;

  @FXML
  private Button btVoltar;

  @FXML
  private Button btEditarCaderno;

  @FXML
  private ListView<Receita> lvReceitas;

  @FXML
  private ListView<Categoria> lvCategoriasCaderno;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }


  public void inicializar() {
    this.lbNomeCaderno.setText(cadernoSelecionado.getNomeCaderno());
    this.taDesc.setText(cadernoSelecionado.getInformacoesCaderno());
    this.lvReceitas.getItems()
        .setAll(sistema.buscarReceitasDoCaderno(cadernoSelecionado.getIdCaderno()));
    this.lvCategoriasCaderno.getItems()
        .setAll(sistema.listarCategoriasDoCaderno(cadernoSelecionado.getIdCaderno()));
  }

  @FXML
  void handleEditarCaderno() {
    screenManager.abrirTelaEditarCaderno(cadernoSelecionado);
  }

  @FXML
  void handleVoltar() throws IOException {
    screenManager.abrirTelaPrincipal();
  }

  public void setCaderno(CadernoReceitas cadernoSelecionado) {
    this.cadernoSelecionado = cadernoSelecionado;
  }

  public void setTelaComoModal() {
    this.btEditarCaderno.setVisible(false);
    this.btEditarCaderno.setDisable(true);
    this.btVoltar.setVisible(false);
    this.btVoltar.setDisable(true);
  }
}