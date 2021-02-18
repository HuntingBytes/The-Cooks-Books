package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;
import com.cooksbooks.gui.ScreenManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro {

  private static final ScreenManager screenManager = ScreenManager.getInstancia();

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

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

  public void inicializar() {
    this.cbExperienciaCulinaria.getItems().addAll(ExperienciaCulinaria.values());
    this.tfLogin.textProperty().addListener((observsableValue, s, t1) -> lbErro.setVisible(false));
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

        try {
          sistema.cadastrarUsuario(usuario);
          this.clearCampos();
          this.lbErro.setText("Usuário cadastrado com sucesso!");
          this.lbErro.setVisible(true);
        } catch (CampoInvalido campoInvalido) {
          alertCamposInvalidos(campoInvalido.getImmutableCamposInvalidos());
        } catch (UsuarioJaCadastrado usuarioJaCadastrado) {
          this.lbErro.setText("Já existe um usuário cadastrado com o login " +
              usuarioJaCadastrado.getLoginUsuario());
          this.lbErro.setVisible(true);
        }
      }
      else {
        this.lbErro.setText("Senhas não coincidem!");
        this.lbErro.setVisible(true);
      }
    }
    else {
      this.alertCamposInvalidos();
    }
  }

  @FXML
  private void handleVoltar() throws IOException {
   screenManager.abrirLogin();
  }

  private boolean areCamposValidos() {
    String nomePerfil = this.tfNomePerfil.getText();
    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();
    String confirmarSenha = this.pfConfirmarSenha.getText();
    ExperienciaCulinaria experienciaCulinaria = this.cbExperienciaCulinaria.getValue();

    boolean nomePerfilBlank = nomePerfil == null || nomePerfil.isBlank();
    boolean loginBlank = login == null || login.isBlank();
    boolean senhaBlank = senha == null || senha.isBlank();
    boolean confirmarSenhaBlank = confirmarSenha == null || confirmarSenha.isBlank();

    return !nomePerfilBlank && !loginBlank && !senhaBlank && !confirmarSenhaBlank
        && experienciaCulinaria != null;
  }

  private void alertCamposInvalidos(List<String> camposInvalidos) {
    StringBuilder textToPrint = new StringBuilder();
    textToPrint.append("Favor rever o(s) seguinte(s) campo(s): ");

    for (String str : camposInvalidos) {
      textToPrint.append(String.format("\"%s\"; ", str));
    }

    Alert alert = new Alert(AlertType.WARNING);
    alert.setTitle("Atenção");
    alert.setHeaderText("Campos Inválidos!");
    alert.setContentText(textToPrint.toString());
    alert.showAndWait();
  }

  private void alertCamposInvalidos() {
    List<String> camposInvalidos = new ArrayList<>();

    String nomePerfil = this.tfNomePerfil.getText();
    String login = this.tfLogin.getText();
    String senha = this.pfSenha.getText();
    String confirmarSenha = this.pfConfirmarSenha.getText();
    ExperienciaCulinaria experienciaCulinaria = this.cbExperienciaCulinaria.getValue();

    if (nomePerfil == null || nomePerfil.isBlank()) {
      camposInvalidos.add("Nome de Perfil");
    }
    if (login == null || login.isBlank()) {
      camposInvalidos.add("Login");
    }
    if (senha == null || senha.isBlank()) {
      camposInvalidos.add("Senha");
    }
    if (confirmarSenha == null || confirmarSenha.isBlank()) {
      camposInvalidos.add("Confirmar Senha");
    }
    if (experienciaCulinaria == null) {
      camposInvalidos.add("Experiencia Culinária");
    }

    alertCamposInvalidos(camposInvalidos);
  }


  private void clearCampos() {
    this.tfNomePerfil.clear();
    this.tfLogin.clear();
    this.pfSenha.clear();
    this.pfConfirmarSenha.clear();
    this.cbExperienciaCulinaria.getSelectionModel().clearSelection();
  }


  public void setLoginSenha(String login, String senha) {
    this.tfLogin.setText(login);
    this.pfSenha.setText(senha);
  }
}
