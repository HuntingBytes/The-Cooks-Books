package com.cooksbooks.exceptions;

public class CadernoComMesmoNomeJaExiste extends Exception {
  private final String nomeCaderno;
  private final String idCaderno;

  public CadernoComMesmoNomeJaExiste(String nomeCaderno, String idCaderno) {
    super(String.format("O nome \"%s\" já está sendo utilizado pelo caderno com id \"%s\"",
          nomeCaderno, idCaderno));
    this.nomeCaderno = nomeCaderno;
    this.idCaderno = idCaderno;
  }

  public String getIdCaderno() {
    return this.idCaderno;
  }

  public String getNomeCaderno() {
    return this.nomeCaderno;
  }
}
