package com.cooksbooks.exceptions;

/**
 * Essa classe representa a exceção no qual existe uma tentativa de cadastrar um Caderno que possui
 * o nome igual a outro caderno já cadastrado no sistema pelo usuário em questão.
 *
 * @version 1.0
 */
public class CadernoComMesmoNomeJaExiste extends Exception {

  private final String nomeCaderno;
  private final String idCaderno;

  /**
   * Construtor que recebe o nome do caderno e o id do caderno que já possui esse nome.
   *
   * @param nomeCaderno Nome do caderno em questão.
   * @param idCaderno   ID do caderno que já possui esse nome.
   */
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
