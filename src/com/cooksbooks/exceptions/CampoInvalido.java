package com.cooksbooks.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Essa classe representa a exceção no qual algum dos campos/atributos de uma classe são inválidos.
 * <p>
 * Ela funciona da forma mais geral possível armazenando uma lista de String's com os nomes dos
 * campos inválidos.
 * </p>
 *
 * @version 1.0
 */
public class CampoInvalido extends Exception {

  private final List<String> camposInvalidos;

  /**
   * Construtor que recebe o único campo inválido.
   *
   * @param campoInvalido String com o nome do campo inválido.
   */
  public CampoInvalido(String campoInvalido) {
    super("O seguinte campo é inválido: " + campoInvalido);
    this.camposInvalidos = new ArrayList<>();
    this.camposInvalidos.add(campoInvalido);
  }

  /**
   * Construtor que recebe uma lista de Strings com os campos inválidos.
   *
   * @param camposInvalidos Lista de strings com os nomes dos campos inválidos.
   */
  public CampoInvalido(List<String> camposInvalidos) {
    super("Os seguintes campos são inválidos: " + String.join("; ", camposInvalidos));
    this.camposInvalidos = camposInvalidos;
  }

  /**
   * Método para obter os campos inválidos da exceção.
   *
   * @return Retorna uma lista imutável (não é possível adicionar, remover ou alterar os elementos)
   * dos campos inválidos.
   */
  public List<String> getImmutableCamposInvalidos() {
    return Collections.unmodifiableList(this.camposInvalidos);
  }
}
