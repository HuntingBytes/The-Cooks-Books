package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaLogin {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  // private App app; Referência para a classe do aplicativo/programa

  @FXML
  private Label lbErro;

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
  public void initialize() {
    this.tfLogin.textProperty().addListener((observableValue, s, t1) -> lbErro.setVisible(false));
    this.pfSenha.textProperty().addListener((observableValue, s, t1) -> lbErro.setVisible(false));
  }

  @FXML
  private void handleEntrar() {
    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();

    boolean loginBlank = login == null || login.isBlank();
    boolean senhaBlank = senha == null || senha.isBlank();

    if(!loginBlank && !senhaBlank) {
      // Esse boolean de sistema.efetuarLogin() deverá ser
      // trocado por blocos try-catch e sistema.efetuarLogin()
      // não deve possuir retorno.
      if(sistema.efetuarLogin(login, senha)) {
        lbErro.setText("Usuário logado!");
        lbErro.setVisible(true);
      } else {
        lbErro.setText("Usuário não logado.");
        lbErro.setVisible(true);
      }
    } else {
      ArrayList<String> wrongFields = new ArrayList<>();
      if (loginBlank) wrongFields.add("Login");
      if (senhaBlank) wrongFields.add("Senha");

      showCamposFaltando(wrongFields);
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

  private void showCamposFaltando(List<String> wrongFields) {
    StringBuilder toPrint = new StringBuilder();
    int size = wrongFields.size();

    if (size > 1) {
      toPrint.append("Favor, informar os campos ");
    } else {
      toPrint.append("Favor, informar o campo ");
    }

    for (int i = 0; i < size; i++) {
      toPrint.append("\"");
      toPrint.append(wrongFields.get(i));
      toPrint.append("\"");
      if (i < size - 1) {
        toPrint.append(", ");
      }
    }

    toPrint.append(".");

    Alert alert = new Alert(Alert.AlertType.WARNING, toPrint.toString());
    alert.setTitle("Campos não preenchidos!");
    alert.setHeaderText("");
    alert.showAndWait();
  }

  /* Seta a instância do aplicativo
  public void setApp(App app) {
    this.app = app;
  }
  */

}
