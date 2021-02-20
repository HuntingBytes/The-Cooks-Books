package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.gui.ScreenManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorAdm {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private TextField tfBarraPesquisa;
  @FXML
  private Button btPesquisar;
  @FXML
  private ListView<Usuario> lvResultadoPesquisa;
  @FXML
  private Button btGerarRelatorio;
  @FXML
  private Button btBanirUsuario;
  @FXML
  private Button btVisualizarReceitas;
  @FXML
  private Button btVisualizarCadernos;

  @FXML
  public void initialize() {
    this.lvResultadoPesquisa
        .setPlaceholder(new Label("Digite um login de usuário e clique em \"Pesquisar\"."));
    this.tfBarraPesquisa.textProperty().addListener((observableValue, s, t1) -> {
      lvResultadoPesquisa.getItems().clear();
      lvResultadoPesquisa.refresh();
    });
  }

  @FXML
  private void handlePesquisar() {
    if (isBuscaValida()) {
      String busca = this.tfBarraPesquisa.getText();
      try {
        Usuario u = this.sistema.buscarUsuario(busca);
        ObservableList<Usuario> listUsuarios = FXCollections.observableArrayList(u);
        this.lvResultadoPesquisa.setItems(listUsuarios);
      } catch (UsuarioInexistente uInexistente) {
        System.out.println(uInexistente.getMessage());
        this.lvResultadoPesquisa
            .setPlaceholder(new Label("Nenhum usuário com esse login encontrado."));
      }
    }
  }

  @FXML
  private void handleGerarRelatorio() {
    ScreenManager.getInstancia().abrirTelaRelatorio();
  }

  @FXML
  private void handleBanirUsuario() {
    Usuario usuarioSelecionado = lvResultadoPesquisa.getSelectionModel().getSelectedItem();
    if (usuarioSelecionado != null) {
      try {
        this.sistema.removerUsuario(usuarioSelecionado.getLogin());
        clearCampos();
      } catch (UsuarioInexistente usuarioInexistente) {
        usuarioInexistente.printStackTrace();
      }
    }
  }

  @FXML
  private void handleVisualizarReceitas() {
    Usuario usuarioSelecionado = lvResultadoPesquisa.getSelectionModel().getSelectedItem();
    if (usuarioSelecionado != null) {
      ScreenManager.getInstancia().abrirTelaRelatorioReceita(usuarioSelecionado.getLogin());
    }
  }

  @FXML
  private void handleVisualizarCadernos() {
    Usuario usuarioSelecionado = lvResultadoPesquisa.getSelectionModel().getSelectedItem();
    if (usuarioSelecionado != null) {
      ScreenManager.getInstancia().abrirTelaRelatorioCaderno(usuarioSelecionado.getLogin());
    }
  }

  private boolean isBuscaValida() {
    return this.tfBarraPesquisa.getText() != null && !this.tfBarraPesquisa.getText().isBlank();
  }

  private void clearCampos() {
    this.tfBarraPesquisa.setText("");
    this.lvResultadoPesquisa.getItems().clear();
    this.lvResultadoPesquisa.refresh();
  }
}

