package com.cooksbooks.gui;

public enum TiposPesquisas {
  CADERNO("Caderno"),
  RECEITA("Receita"),
  USUARIO("Usuário");

  private final String extenso;

  TiposPesquisas(String extenso) {
    this.extenso = extenso;
  }

  @Override
  public String toString() {
    return this.extenso;
  }
}
