package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe
 * uma tentativa de cadastrar um usuário que já existe
 * no repositório. (i. e., login já está sendo utilizado)
 * @version 1.0
 */
public class UsuarioJaCadastrado extends Exception {
  private final String loginUsuario;

  /**
   * Construtor que recebe o login do usuário tentando ser cadastrado.
   * @param loginUsuario Login do usuário tentando ser cadastrado.
   */
  public UsuarioJaCadastrado(String loginUsuario) {
    super(String.format("Já existe um usuário cadastrado com login \"%s\"", loginUsuario));
    this.loginUsuario = loginUsuario;
  }

  public String getLoginUsuario() {
    return this.loginUsuario;
  }
}
