package com.cooksbooks.exceptions;

public class ReceitaComMesmoTituloJaExiste extends Exception {
  private final String nomeReceita;
  private final String idReceita;

  public ReceitaComMesmoTituloJaExiste(String nomeReceita, String idReceita) {
    super(String.format("O nome \"%s\" já está sendo utilizado pelo caderno com id \"%s\"",
        nomeReceita, idReceita));
    this.nomeReceita = nomeReceita;
    this.idReceita = idReceita;
  }

  public String getIdReceita() {
    return this.idReceita;
  }

  public String getNomeReceita() {
    return this.nomeReceita;
  }
}
