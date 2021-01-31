package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.facilities.Telas;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaLogin {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private App app; //Referência para a classe do aplicativo/programa

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
    if (this.areCamposValidos()) {
      // Esse boolean de sistema.efetuarLogin() deverá ser
      // trocado por blocos try-catch e sistema.efetuarLogin()
      // não deve possuir retorno.
      String login = this.tfLogin.getText();
      String senha = this.pfSenha.getText();

      if (sistema.efetuarLogin(login, senha)) {
        lbErro.setText("Usuário logado!");
      } else {
        lbErro.setText("Usuário não logado.");
      }
      this.clearCampos();
      lbErro.setVisible(true);
    }
    else {
      this.alertCamposInvalidos();
    }
  }

  @FXML
  private void handleCadastrar() throws IOException {
    app.alterarTela(Telas.TELA_CADASTRO);
  }

  @FXML
  private void handleAjuda() {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Ajuda - Tela de Login");
    alert.setHeaderText("");
    alert.setContentText(
        "Nessa tela você deve inserir seu login e senha e clicar no botão \"Entrar\"" +
            "para conseguir acessar a plataforma!\n" +
            "Caso ainda não possua uma conta, clique no botão \"Cadastrar\".");
    alert.showAndWait();
  }


  public void setApp(App app) {
    this.app = app;
  }


  private boolean areCamposValidos() {
    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();

    boolean loginBlank = login == null || login.isBlank();
    boolean senhaBlank = senha == null || senha.isBlank();

    return !loginBlank && !senhaBlank;
  }

  private void alertCamposInvalidos() {
    StringBuilder textToPrint = new StringBuilder();
    textToPrint.append("Favor rever o(s) seguinte(s) campo(s): ");

    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();

    if (login == null || login.isBlank()) {
      textToPrint.append("\"Login\"; ");
    }
    if (senha == null || senha.isBlank()) {
      textToPrint.append("\"Senha\"; ");
    }

    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Campos Inválidos!");
    alert.setContentText(textToPrint.toString());
    alert.showAndWait();
  }

  private void clearCampos() {
    this.tfLogin.clear();
    this.pfSenha.clear();
  }

}
