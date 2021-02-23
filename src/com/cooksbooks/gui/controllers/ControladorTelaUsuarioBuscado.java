package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class ControladorTelaUsuarioBuscado {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;
  private Usuario usuario;
  @FXML
  private Label lbNomePerfil;

  @FXML
  private Label lbDataCadastro;

  //@FXML
  //private Label lbReceitasCadastradas;

  @FXML
  private ListView<Receita> lvReceitasUsuarioBuscado;

  @FXML
  private ListView<CadernoReceitas> lvCadernosUsuarioBuscado;

  @FXML
  private ImageView ivImagemUsuarioBuscado;

  @FXML
  private Label lbExperienciaCulinaria;

  public void inicializar() {
    this.lbNomePerfil.setText(usuario.getNomePerfil());
    this.lbDataCadastro.setText(usuario.getDataCriacao().toString());
    //this.lbReceitasCadastradas.setText(String.format(usuario.getQuantidadeReceitasCadastradas());
    this.lbExperienciaCulinaria.setText(usuario.getExperienciaCulinaria().toString());

    this.lvCadernosUsuarioBuscado.setItems(FXCollections.observableArrayList(
        sistema.buscarTodosCadernosDoUsuario(usuario.getLogin())));
    this.lvReceitasUsuarioBuscado
        .setItems(FXCollections.observableArrayList(buscarTodasReceitas()));
  }

  @FXML
  void handleSelecionarCaderno(ActionEvent event) {
    if (lvCadernosUsuarioBuscado.getSelectionModel().getSelectedItem() != null) {
      screenManager
          .abrirTelaCaderno(lvCadernosUsuarioBuscado.getSelectionModel().getSelectedItem());
    } else {
      alertSelecionarItem("um caderno");
    }
  }

  @FXML
  void handleSelecionarReceita(ActionEvent event) {
    if (lvReceitasUsuarioBuscado.getSelectionModel().getSelectedItem() != null) {
      screenManager
          .abrirTelaReceita(lvReceitasUsuarioBuscado.getSelectionModel().getSelectedItem());
    } else {
      alertSelecionarItem("uma receita");
    }
  }

  //TODO: fazer isso direito e colocar no lugar certo
  private List<Receita> buscarTodasReceitas() {
    List<Receita> todasReceitas = new ArrayList<>();
    for (CadernoReceitas c : sistema.buscarTodosCadernosDoUsuario(usuario.getLogin())) {
      todasReceitas.addAll(sistema.buscarReceitasDoCaderno(c.getIdCaderno()));
    }
    return todasReceitas;
  }

  private void alertSelecionarItem(String item) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Nada foi Selecionado!");
    alert.setContentText(String.format("Favor selecionar %s para acessar", item));
    alert.showAndWait();
  }

  public void setUsuario(Usuario u) {
    this.usuario = u;
  }
}
