package com.cooksbooks.exceptions;

public class CadernoInexistente extends Exception {
  private final String idCaderno;

  public CadernoInexistente(String idCaderno) {
    super(String.format("Não existe um caderno com id \"%s\" no sistema.", idCaderno));
    this.idCaderno = idCaderno;
  }

  public String getIdCaderno() {
    return this.idCaderno;
  }
}
