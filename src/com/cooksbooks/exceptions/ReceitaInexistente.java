package com.cooksbooks.exceptions;

public class ReceitaInexistente extends Exception {
  private final String idReceita;

  public ReceitaInexistente(String idReceita) {
    super(String.format("Não existe receita com id \"%s\" no sistema.", idReceita));
    this.idReceita = idReceita;
  }

  public String getIdReceita() {
    return this.idReceita;
  }
}
