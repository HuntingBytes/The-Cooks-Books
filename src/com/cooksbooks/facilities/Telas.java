package com.cooksbooks.facilities;

public enum Telas {
  TELA_CADASTRO("gui/views/TelaCadastro.fxml"),
  TELA_LOGIN("gui/views/TelaLogin.fxml"),
  TELA_CRIACAO_CADERNO("gui/views/TelaCriacaoCaderno.fxml"),
  TELA_CRIACAO_RECEITA("gui/views/TelaCriacaoReceita.fxml"),
  TELA_PRINCIPAL_USUARIO("gui/views/TelaPrincipalUsuario.fxml"),
  TELA_CADERNO("gui/views/TelaDoCaderno");

  private final String caminho;

  Telas(String caminho) {
    this.caminho = caminho;
  }

  public String caminho() {
    return this.caminho;
  }
}
