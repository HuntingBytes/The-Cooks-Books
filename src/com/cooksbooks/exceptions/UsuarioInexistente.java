package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual não existe
 * um usuário com o login buscado.
 * @version 1.0
 */
public class UsuarioInexistente extends Exception {
  private final String loginUsuario;

  /**
   * Construtor que recebe o login do usuário buscado.
   * @param loginUsuario Login do usuário buscado.
   */
  public UsuarioInexistente(String loginUsuario) {
    super("Não existe um usuário com login \"" + loginUsuario + "\"");
    this.loginUsuario = loginUsuario;
  }

  /**
   * Método que retorna o login do usuário dessa exceção.
   * @return String com o login do usuário.
   */
  public String getLoginUsuario() {
    return this.loginUsuario;
  }
}
