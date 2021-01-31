package com.cooksbooks.tests;

import com.cooksbooks.entity.utils.PermissaoEspecial;

/**
 * Classe feita para uso interno, não deve ser instanciada
 * e nem utilizada em outras partes do código.
 *
 * Aqui podemos realizar testes para depurar
 * o pacote com.cooksbooks.entity.utils.
 *
 * @since 18-01-2021
 */
final class UtilsDebugMain {
    private UtilsDebugMain() {}

    public static void main(String[] args) {
        PermissaoEspecial.debug();
    }
}
