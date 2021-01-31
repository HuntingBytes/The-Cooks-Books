package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaLogin {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  // private App app; Referência para a classe do aplicativo/programa

  @FXML
  private TextField tfLogin;

  @FXML
  private PasswordField pfSenha;

  @FXML
  private Button btEntrar;

  @FXML
  private Button btCadastrar;

  @FXML
  private Button btAjuda;

  @FXML
  private void handleEntrar() {
    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();

    if(login != null &&  senha != null) {
      if(sistema.efetuarLogin(login, senha)) {
        System.out.println("Usuário logado!");
      } else {
        System.out.println("Não logado.");
      }
    }
  }

  @FXML
  private void handleCadastrar() {
    // Usa o this.app para atualizar a tela, talvez?
    // Troca para a tela de cadastro
  }

  @FXML
  private void handleAjuda() {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajuda - Tela de Login");
    alert.setHeaderText("");
    alert.setContentText("Nessa tela você deve inserir seu login e senha e clicar no botão \"Entrar\"" +
                        "para conseguir acessar a plataforma!\n" +
                        "Caso ainda não possua uma conta, clique no botão \"Cadastrar\".");
    alert.showAndWait();
  }

  /* Seta a instância do aplicativo
  public void setApp(App app) {
    this.app = app;
  }
  */

}
