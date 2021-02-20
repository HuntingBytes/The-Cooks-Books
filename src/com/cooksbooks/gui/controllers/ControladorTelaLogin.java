package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Administrador;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;
import com.cooksbooks.exceptions.UsuarioJaLogado;
import com.cooksbooks.exceptions.UsuarioSenhaIncorreta;
import com.cooksbooks.gui.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaLogin {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  private ScreenManager screenManager;

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

  public void setScreenManager(ScreenManager screenManager) {
    this.screenManager = screenManager;
  }

  @FXML
  public void initialize() {
    this.tfLogin.textProperty().addListener((observableValue, s, t1) -> lbErro.setVisible(false));
    this.pfSenha.textProperty().addListener((observableValue, s, t1) -> lbErro.setVisible(false));
    Administrador adm = new Administrador("admin", "password");
    adm.setNomePerfil("Administrador");
    adm.setBiografia("Administrador");
    adm.setExperienciaCulinaria(ExperienciaCulinaria.PROFISSIONAL);
    try {
      this.sistema.cadastrarUsuario(adm);
    } catch (UsuarioJaCadastrado | CampoInvalido e) {
      // Sem problemas. Apenas um teste
    }
  }

  @FXML
  private void handleEntrar() {
    if (this.areCamposValidos()) {
      String login = this.tfLogin.getText();
      String senha = this.pfSenha.getText();

      try {
        this.sistema.efetuarLogin(login, senha);
        this.screenManager.abrirTelaPrincipal();
        if (this.sistema.getUsuarioLogado() instanceof Administrador) {
          this.screenManager.abrirTelaAdmin();
        }
        clearCampos();
      } catch (UsuarioInexistente uInexistente) {
        lbErro.setText("Nenhum usuário com esse login foi encontrado.");
        lbErro.setVisible(true);
      } catch (UsuarioSenhaIncorreta uSenhaIncorreta) {
        lbErro.setText("Senha incorreta! Favor verificar os dados e tentar novamente.");
        lbErro.setVisible(true);
      } catch (UsuarioJaLogado uJaLogado) {
        lbErro.setText("Já existe um usuário logado... Favor reiniciar o aplicativo.");
        lbErro.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
        // Talvez finalizar o aplicativo?
      }
    } else {
      this.alertCamposInvalidos();
    }
  }

  @FXML
  private void handleCadastrar() {
    this.screenManager.abrirCadastro(tfLogin.getText(), pfSenha.getText());
    this.clearCampos();
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