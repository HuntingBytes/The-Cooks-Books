package com.cooksbooks.tests;

import com.cooksbooks.entity.Receita;

/**
 * Classe feita para uso interno, não deve ser instanciada
 * e nem utilizada em outras partes do código.
 * <p>
 * Aqui podemos realizar testes para depurar
 * o pacote com.cooksbooks.entity.
 * </p>
 * @since 21-01-2021
 */
final class EntityDebugMain {
  private EntityDebugMain() {}

  public static void main(String[] args) {
    Receita.debug();
    System.out.println();
  }
}
