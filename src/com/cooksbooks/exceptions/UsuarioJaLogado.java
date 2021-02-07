package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe
 * uma tentativa de realizar o login sendo que já
 * existe um usuario logado.
 * @version 1.0
 */
public class UsuarioJaLogado extends Exception {
  private final String loginUsuarioAtual;

  /**
   * Construtor que recebe o login do usuário que já está logado.
   * @param loginUsuarioAtual Login do usuário tentando ser cadastrado.
   */
  public UsuarioJaLogado(String loginUsuarioAtual) {
    super(String.format("Já existe um usuário logado! (Login usuário atual: %s)", loginUsuarioAtual));
    this.loginUsuarioAtual = loginUsuarioAtual;
  }

  public String getLoginUsuarioAtual() {
    return this.loginUsuarioAtual;
  }

}
