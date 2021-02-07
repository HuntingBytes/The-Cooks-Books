package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe
 * uma tentativa de manipular um caderno que não existe.
 * @version 1.0
 */
public class CadernoInexistente extends Exception {
  private final String idCaderno;

  /**
   * Construtor que recebe o id que não existe.
   * @param idCaderno ID do caderno que não existe.
   */
  public CadernoInexistente(String idCaderno) {
    super(String.format("Não existe um caderno com id \"%s\" no sistema.", idCaderno));
    this.idCaderno = idCaderno;
  }

  public String getIdCaderno() {
    return this.idCaderno;
  }
}
