package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.gui.ScreenManager;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControladorAdm {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private TextField tfBarraPesquisa;

  @FXML
  private ListView<Usuario> lvResultadoPesquisa;

  @FXML
  public void initialize() {
    this.lvResultadoPesquisa
        .setPlaceholder(new Label("Digite um login de usuário e clique em \"Pesquisar\"."));
    this.tfBarraPesquisa.textProperty().addListener((observableValue, s, t1) -> {
      lvResultadoPesquisa.getItems().clear();
      lvResultadoPesquisa.refresh();
    });

    this.lvResultadoPesquisa.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(Usuario item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null ) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getNomePerfil(), item.getLogin()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
  }

  @FXML
  private void handlePesquisar() {
    if (isBuscaValida()) {
      String busca = this.tfBarraPesquisa.getText();
      List<Usuario> usuarios = this.sistema.buscarUsuariosComNome(busca);
      if (usuarios.size() > 0) {
        ObservableList<Usuario> listUsuarios = FXCollections.observableArrayList(usuarios);
        this.lvResultadoPesquisa.setItems(listUsuarios);
      } else {
        this.lvResultadoPesquisa.setPlaceholder(new Label("Nenhum usuário com esse nome encontrado."));
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

