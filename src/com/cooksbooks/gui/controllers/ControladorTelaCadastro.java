package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.utils.ExperienciaCulinaria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControladorTelaCadastro {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
  // private App app; Referência para a classe do aplicativo/programa

  @FXML
  private TextField tfLogin;

  @FXML
  private TextField tfSenha;

  @FXML
  private TextField tfConfirmarSenha;

  @FXML
  private ChoiceBox<ExperienciaCulinaria> cbExperienciaCulinaria;

  @FXML
  private Button btCadastrar;

  @FXML
  private Button btVoltar;

  @FXML
  public void initialize() {
    this.cbExperienciaCulinaria.getItems().addAll(ExperienciaCulinaria.values());
  }

  @FXML
  private void handleCadastrar() {
    String login = tfLogin.getText();
    String senha = tfSenha.getText();
    String confirmarSenha = tfConfirmarSenha.getText();
    ExperienciaCulinaria experienciaCulinaria = cbExperienciaCulinaria.getValue();

    if(login != null && senha != null && confirmarSenha != null && experienciaCulinaria != null) {
      if(senha.equals(confirmarSenha)) {
        Usuario usuario = new Usuario(login, senha);
        usuario.setNomePerfil(login);
        usuario.setBiografia("");
        usuario.setExperienciaCulinaria(experienciaCulinaria);

        sistema.cadastrarUsuario(usuario);

        System.out.println("Usuário cadastrado!");
      } else {
        System.out.println("Senhas não coincidem!");
      }
    }

  }

  @FXML
  private void handleVoltar() {
    // Usa o this.app para atualizar a tela, talvez?
    // Troca para a tela de cadastro
  }

}
