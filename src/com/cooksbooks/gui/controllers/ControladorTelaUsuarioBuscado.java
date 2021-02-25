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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControladorTelaUsuarioBuscado {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;
  private Usuario usuario;

  @FXML
  private Label lbNomePerfil;

  @FXML
  private Label lbDataCadastro;

  @FXML
  private ListView<Receita> lvReceitasUsuarioBuscado;

  @FXML
  private ListView<CadernoReceitas> lvCadernosUsuarioBuscado;

  @FXML
  private ImageView ivImagemUsuarioBuscado;

  @FXML
  private Label lbExperienciaCulinaria;

  @FXML
  private void initialize() {
    this.lvReceitasUsuarioBuscado.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Receita item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getTitulo(), item.getModoPreparo()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
    this.lvCadernosUsuarioBuscado.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(CadernoReceitas item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getNomeCaderno(), item.getInformacoesCaderno()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
  }

  public void inicializar() {
    this.lbNomePerfil.setText(usuario.getNomePerfil());
    this.lbDataCadastro.setText(usuario.getDataCriacao().toString());
    this.lbExperienciaCulinaria.setText(usuario.getExperienciaCulinaria().toString());

    this.lvCadernosUsuarioBuscado.setItems(FXCollections.observableArrayList(
        sistema.buscarTodosCadernosDoUsuario(usuario.getLogin())));
    this.lvReceitasUsuarioBuscado.setItems(FXCollections.observableArrayList(
        sistema.buscarTodasReceitasDoUsuario(usuario.getLogin())));
  }

  @FXML
  void handleSelecionarCaderno(ActionEvent event) {
    if (lvCadernosUsuarioBuscado.getSelectionModel().getSelectedItem() != null) {
      screenManager.abrirTelaCadernoModal(lvCadernosUsuarioBuscado.getSelectionModel().getSelectedItem(),
          (Stage) this.lvCadernosUsuarioBuscado.getScene().getWindow());
    } else {
      alertSelecionarItem("um caderno");
    }
  }

  @FXML
  void handleSelecionarReceita(ActionEvent event) {
    if (lvReceitasUsuarioBuscado.getSelectionModel().getSelectedItem() != null) {
      screenManager.abrirTelaReceitaModal(lvReceitasUsuarioBuscado.getSelectionModel().getSelectedItem(),
          (Stage) this.lvReceitasUsuarioBuscado.getScene().getWindow());
    } else {
      alertSelecionarItem("uma receita");
    }
  }

  public void setUsuario(Usuario u) {
    this.usuario = u;
  }

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  private void alertSelecionarItem(String item) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Nada foi Selecionado!");
    alert.setContentText(String.format("Favor selecionar %s para acessar", item));
    alert.showAndWait();
  }
}
