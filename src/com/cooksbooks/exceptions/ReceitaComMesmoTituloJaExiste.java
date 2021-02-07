package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe
 * uma tentativa de cadastrar uma Receita que possui
 * o nome igual a outra Receita já cadastrada no sistema
 * pelo usuário em questão.
 * @version 1.0
 */
public class ReceitaComMesmoTituloJaExiste extends Exception {
  private final String nomeReceita;
  private final String idReceita;

  /**
   * Construtor que recebe o título da receita e o id da receita que já possui esse título.
   * @param nomeReceita Nome da Receita em questão.
   * @param idReceita ID da Receita que já possui esse nome.
   */
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
