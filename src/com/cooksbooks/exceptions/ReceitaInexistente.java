package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe uma tentativa de manipular uma Receita que não
 * existe no sistema.
 *
 * @version 1.0
 */
public class ReceitaInexistente extends Exception {

  private final String idReceita;

  /**
   * Construtor que recebe o ID da receita que não existe no sistema.
   *
   * @param idReceita ID da Receita que não existe.
   */
  public ReceitaInexistente(String idReceita) {
    super(String.format("Não existe receita com id \"%s\" no sistema.", idReceita));
    this.idReceita = idReceita;
  }

  public String getIdReceita() {
    return this.idReceita;
  }
}
