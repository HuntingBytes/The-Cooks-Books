package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControladorReceitaRelatorio {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private ListView<Receita> lvReceitasUsuario;

  @FXML
  private Button btRemoverReceita;

  @FXML
  private Button btFechar;

  @FXML
  private Label lbTitulo;

  @FXML
  private void handleRemoverItem() {
    Receita receita = this.lvReceitasUsuario.getSelectionModel().getSelectedItem();
    int indiceReceita = this.lvReceitasUsuario.getSelectionModel().getSelectedIndex();
    if (receita != null) {
      try {
        sistema.removerReceita(receita.getIdReceita());
        this.lvReceitasUsuario.getItems().remove(indiceReceita);
        this.lvReceitasUsuario.refresh();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private void handleFechar() {
    ((Stage) this.btFechar.getScene().getWindow()).close();
    this.clearCampos();
  }

  private void clearCampos() {
    this.lbTitulo.setText("Receita(s) de");
    this.lvReceitasUsuario.getItems().clear();
    this.lvReceitasUsuario.refresh();
  }

  public void inicializar(String loginUsuario) {
    this.lbTitulo.setText(String.format("Receita(s) de %s", loginUsuario));
    List<CadernoReceitas> listCadernos = sistema.buscarTodosCadernosDoUsuario(loginUsuario);
    List<Receita> listReceitas = new ArrayList<>();
    listCadernos
        .forEach(c -> listReceitas.addAll(sistema.buscarReceitasDoCaderno(c.getIdCaderno())));
    this.lvReceitasUsuario.setItems(FXCollections.observableList(listReceitas));
    // Talvez adicionar um método na facha que já retorna todas receitas do Caderno
  }

}
