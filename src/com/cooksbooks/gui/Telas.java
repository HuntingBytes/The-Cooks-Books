package com.cooksbooks.gui;

public enum Telas {
  TELA_CADASTRO("views/TelaCadastro.fxml"),
  TELA_LOGIN("views/TelaLogin.fxml"),
  TELA_CRIACAO_CADERNO("views/TelaCriacaoCaderno.fxml"),
  TELA_CRIACAO_RECEITA("views/TelaCriacaoReceita.fxml"),
  TELA_PRINCIPAL_USUARIO("views/TelaPrincipalUsuario.fxml"),
  TELA_PERFIL("views/TelaPerfil.fxml"),
  TELA_EDITAR_PERFIL("views/TelaEditarPerfil.fxml"),
  TELA_CADERNO("views/TelaDoCaderno.fxml"),
  TELA_RESULTADOS_PESQUISA("views/TelaResultadosPesquisa.fxml"),
  TELA_EDITAR_RECEITA("views/TelaEditarReceita.fxml");

  private final String caminho;

  Telas(String caminho) {
    this.caminho = caminho;
  }

  public String caminho() {
    return this.caminho;
  }
}
