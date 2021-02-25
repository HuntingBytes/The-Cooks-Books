package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.gui.ScreenManager;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaEditarCaderno {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private CadernoReceitas caderno;
  private ScreenManager screenManager;

  @FXML
  private TextField tfNovoNome;

  @FXML
  private Button btAlterarNome;

  @FXML
  private Label lbNomeCaderno;

  @FXML
  private TextArea taAlterarDesc;

  @FXML
  private Label lbAlterarDesc;

  @FXML
  private Button btAlterarDescricao;

  @FXML
  private Button btVoltar;

  @FXML
  private ListView<Receita> lvReceitas;

  @FXML
  private Button btAddReceita;

  @FXML
  private Button btRemoveReceita;

  @FXML
  private ListView<Categoria> lvCategorias;

  @FXML
  private Button btRemoveCategoria;

  @FXML
  private Button btAddCategoria;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  public void inicializar() {
    this.lbNomeCaderno.setText(caderno.getNomeCaderno());
    this.tfNovoNome.setText(caderno.getNomeCaderno());
    this.taAlterarDesc.setText(caderno.getInformacoesCaderno());
    List<Receita> receitas = sistema.buscarReceitasDoCaderno(caderno.getIdCaderno());
    if (receitas != null && receitas.size() > 0) {
      this.lvReceitas.getItems().setAll(receitas);
    }
    List<Categoria> categorias = sistema.listarCategoriasDoCaderno(caderno.getIdCaderno());
    if (categorias != null && categorias.size() > 0) {
      this.lvCategorias.getItems().setAll();
    }
  }

  @FXML
  void handleAddCat(ActionEvent event) {
    caderno.adicionarCategoria(lvCategorias.getSelectionModel().getSelectedItem());
  }

  @FXML
  void handleAddReceita(ActionEvent event) {
    screenManager.abrirTelaCriacaoReceita(this.caderno.getIdCaderno());
    inicializar();
  }

  @FXML
  void handleAlterarDescricao(ActionEvent event) {
    caderno.setInformacoesCaderno(taAlterarDesc.getText());
  }

  @FXML
  void handleAlterarNome(ActionEvent event) {
    caderno.setNomeCaderno(tfNovoNome.getText());
  }

  @FXML
  void handleRemoveCat(ActionEvent event) {
    caderno.removerCategoria(lvCategorias.getSelectionModel().getSelectedItem());
  }

  @FXML
  void handleRemoveReceita(ActionEvent event) {
    sistema.removerReceita(lvReceitas.getSelectionModel().getSelectedItem().getIdReceita());
  }

  @FXML
  void handleVoltar(ActionEvent event) {
    screenManager.abrirTelaCaderno(caderno);
  }


  public void setCaderno(CadernoReceitas caderno) {
    this.caderno = caderno;
  }
}