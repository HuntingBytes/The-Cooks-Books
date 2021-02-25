package com.cooksbooks.gui;

public enum Telas {
  TELA_CADASTRO("views/TelaCadastro.fxml"),
  TELA_LOGIN("views/TelaLogin.fxml"),
  TELA_CRIACAO_CADERNO("views/TelaCriacaoCaderno.fxml"),
  TELA_CRIACAO_RECEITA("views/TelaCriacaoReceita.fxml"),
  TELA_CRIACAO_INGREDIENTE("views/TelaIngrediente.fxml"),
  TELA_PRINCIPAL_USUARIO("views/TelaPrincipalUsuario.fxml"),
  TELA_ENVIAR_FEEDBACK("views/TelaEnviarFeedback.fxml"),
  TELA_PERFIL("views/TelaPerfil.fxml"),
  TELA_EDITAR_PERFIL("views/TelaEditarPerfil.fxml"),
  TELA_CADERNO("views/TelaDoCaderno.fxml"),
  TELA_RESULTADOS_PESQUISA("views/TelaResultadosPesquisa.fxml"),
  TELA_EDITAR_RECEITA("views/TelaEditarReceita.fxml"),
  TELA_INICIAL_ADM("views/TelaInicialAdm.fxml"),
  TELA_GERAR_RELATORIO("views/TelaGerarRelatorio.fxml"),
  TELA_USUARIO_BUSCADO("views/TelaUsuarioBuscado.fxml"),
  TELA_RECEITA_RELATORIO("views/TelaReceitaRelatorio.fxml"),
  TELA_CADERNO_RELATORIO("views/TelaCadernoRelatorio.fxml"),
  TELA_EDITAR_CADERNO("views/TelaEditarCaderno.fxml"),
  TELA_RECEITA("views/TelaReceita.fxml");

  private final String caminho;

  Telas(String caminho) {
    this.caminho = caminho;
  }

  public String caminho() {
    return this.caminho;
  }
}
