package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.gui.ScreenManager;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ControladorTelaResultado {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;
  private ArrayList<String> pesquisa;

  @FXML
  private ListView<Usuario> listViewResultados;

  @FXML
  private Button botaoVoltar;

  @FXML
  private Button botaoSelecionarResult;

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
    this.pesquisa = new ArrayList<>(5);
  }

  public void inicializar() {
    ArrayList<Usuario> usuarios = new ArrayList<>(5);
    for (String s : pesquisa) {
      try {
        usuarios.add(sistema.buscarUsuario(s));
      } catch (UsuarioInexistente usuarioInexistente) {
        // Usuário inexistente.
      }
    }
    listViewResultados.setItems(FXCollections.observableArrayList(usuarios));
  }

  @FXML
  public void handleSelecionarResult() {
    //Object o = listViewResultados.getSelectionModel().getSelectedItem();
    Usuario o = listViewResultados.getSelectionModel().getSelectedItem();
    if (o != null) {
      //TODO AJEITAR ESSA PORRA DE CONTROLADOR
            /*if(o instanceof Usuario){
                screenManager.abrirTelaUsuarioBuscado((Usuario) o);
            }else if(o instanceof Receita){
                screenManager.abrirTelaReceita((Receita) o);
            }else{
                screenManager.abrirTelaCaderno((CadernoReceitas) o);
            }*/
      screenManager.abrirTelaUsuarioBuscado(o);
    } else {
      alertSelecionarItem();
    }
  }

  @FXML
  public void handleBotaoVoltar() {
    screenManager.abrirTelaPrincipal();
  }

  private void alertSelecionarItem() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Nada foi Selecionado!");
    //alert.setContentText(String.format("Favor selecionar %s para acessar", item));
    alert.showAndWait();
  }

  //TODO: fazer isso direito e colocar no lugar certo
  private List<Receita> buscarTodasReceitas() {
    List<Receita> todasReceitas = new ArrayList<>();
    for (CadernoReceitas c : sistema.buscarTodosCadernosDoUsuario(sistema.getUsuarioLogado().getLogin())) {
      todasReceitas.addAll(sistema.buscarReceitasDoCaderno(c.getIdCaderno()));
    }
    return todasReceitas;
  }

  public void setItensResultados(String str) {
    this.pesquisa.add(str);
  }
}