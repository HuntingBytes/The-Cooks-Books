package com.cooksbooks.utils;

public enum Rendimento {

  /**
   * A Classe Rendimento é responsável por definir ações que os possiveis rendimentos que um Receita
   * pode ter
   *
   * @version 1.0
   */
  UM("1 pessoa"),
  DOIS("2 pessoas"),
  QUATRO("4 pessoas"),
  SEIS("6 pessoas"),
  OITO("8 pessoas"),
  MUITAS("Mais de 10 pessoas");

  private final String extenso;

  /**
   * Construtor padrão
   *
   * @param extenso é a representação textual do rendimento escolhido
   */
  Rendimento(String extenso) {
    this.extenso = extenso;
  }

  /**
   * Retorna uma String com a representação textual da permissão.
   *
   * @return String que representa a instância
   */
  @Override
  public String toString() {
    return this.extenso;
  }
}
