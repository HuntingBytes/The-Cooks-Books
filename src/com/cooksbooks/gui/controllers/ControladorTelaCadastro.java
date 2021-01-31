package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.utils.ExperienciaCulinaria;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  // private App app; Referência para a classe do aplicativo/programa

  @FXML
  private Label lbErro;

  @FXML
  private TextField tfNomePerfil;

  @FXML
  private TextField tfLogin;

  @FXML
  private PasswordField pfSenha;

  @FXML
  private PasswordField pfConfirmarSenha;

  @FXML
  private ChoiceBox<ExperienciaCulinaria> cbExperienciaCulinaria;

  @FXML
  private Button btCadastrar;

  @FXML
  private Button btVoltar;

  @FXML
  public void initialize() {
    this.cbExperienciaCulinaria.getItems().addAll(ExperienciaCulinaria.values());
    this.tfLogin.textProperty().addListener((observableValue, s, t1) -> lbErro.setVisible(false));
    this.pfSenha.textProperty().addListener((observableValue, s, t1) -> lbErro.setVisible(false));
    this.pfConfirmarSenha.textProperty()
        .addListener((observableValue, s, t1) -> lbErro.setVisible(false));
  }

  @FXML
  private void handleCadastrar() {
    if (this.areCamposValidos()) {
      String nomePerfil = this.tfNomePerfil.getText();
      String login = this.tfLogin.getText();
      String senha = this.pfSenha.getText();
      String confirmarSenha = this.pfConfirmarSenha.getText();
      ExperienciaCulinaria experienciaCulinaria = this.cbExperienciaCulinaria.getValue();

      if (senha.equals(confirmarSenha)) {
        Usuario usuario = new Usuario(login, senha);
        usuario.setNomePerfil(nomePerfil);
        usuario.setExperienciaCulinaria(experienciaCulinaria);
        usuario.setBiografia("");

        sistema.cadastrarUsuario(usuario);

        this.clearCampos();
        this.lbErro.setText("Usuário cadastrado!");
      }
      else {
        this.lbErro.setText("Senhas não coincidem!");
      }
      this.lbErro.setVisible(true);
    }
    else {
      this.alertCamposInvalidos();
    }
  }

  @FXML
  private void handleVoltar() {
    // Usa o this.app para atualizar a tela, talvez?
    // Troca para a tela de cadastro
  }

  private boolean areCamposValidos() {
    String nomePerfil = tfNomePerfil.getText();
    String login = tfLogin.getText();
    String senha = pfSenha.getText();
    String confirmarSenha = pfConfirmarSenha.getText();
    ExperienciaCulinaria experienciaCulinaria = cbExperienciaCulinaria.getValue();

    boolean nomePerfilBlank = nomePerfil == null || nomePerfil.isBlank();
    boolean loginBlank = login == null || login.isBlank();
    boolean senhaBlank = senha == null || senha.isBlank();
    boolean confirmarSenhaBlank = confirmarSenha == null || confirmarSenha.isBlank();

    return !nomePerfilBlank && !loginBlank && !senhaBlank && !confirmarSenhaBlank
        && experienciaCulinaria != null;
  }

  private void alertCamposInvalidos() {
    StringBuilder textToPrint = new StringBuilder();
    textToPrint.append("Favor rever o(s) seguinte(s) campo(s): ");

    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();

    if (login == null || login.isBlank()) {
      textToPrint.append("\"Login\"");
    }
    if (senha == null || senha.isBlank()) {
      textToPrint.append("\"Senha\"");
    }

    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Campos Inválidos!");
    alert.setContentText(textToPrint.toString());
    alert.showAndWait();
  }

  private void clearCampos() {
    this.tfNomePerfil.clear();
    this.tfLogin.clear();
    this.pfSenha.clear();
    this.pfConfirmarSenha.clear();
    this.cbExperienciaCulinaria.getSelectionModel().clearSelection();
  }

}
