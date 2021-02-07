package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe
 * uma tentativa de realizar o login de um usuário
 * mas a senha está incorreta.
 * @version 1.0
 */
public class UsuarioSenhaIncorreta extends Exception {
  private final String loginUsuario;

  /**
   * Construtor que recebe o login do usuário que está tentando fazer login.
   * @param loginUsuario Login do usuário tentando logar.
   */
  public UsuarioSenhaIncorreta(String loginUsuario) {
    super(String.format("Senha incorreta. A senha dada para o usuário \"%s\" não coincide com a cadastrada.",
          loginUsuario));
    this.loginUsuario = loginUsuario;
  }

  public String getLoginUsuario() {
    return this.loginUsuario;
  }
}
