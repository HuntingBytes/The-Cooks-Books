package com.cooksbooks.entity;

import java.util.List;

/**
 * CadernoReceita é responsável por agrupar
 * diversas receitas criadas/escolhidas pelu usuário.
 *
 * CadernoReceita possui métodos responsáveis por
 * adicionar e remover uma receita e listar as
 * Categorias das receitas.
 *
 * @version 1.0
 */

public class CadernoReceitas {

    //Atributos
    private String nomeCaderno;
    private String informacoesCaderno;
    private boolean visivel;

    //Construtor completo
    public CadernoReceitas (String nomeCaderno, String informacoesCaderno, boolean visivel) {
        this.nomeCaderno = nomeCaderno;
        this.informacoesCaderno = informacoesCaderno;
        this.visivel = visivel;
    }

    /**
     * Adiciona uma receita ao caderno
     *
     */
    public void adicionarReceita (Receita receita) {

    }

    /**
     * Faz o contrário do método anterior
     *
     */
    public void removerReceita (Receita receita) {

    }

    /**
     * Listar as categorias das receitas presentes
     * nesse caderno.
     *
     * @return todas as categorias das receitas
     * presentes nesse caderno.
     */
    public List<Categorias> listarCategorias () { return this.categorias; }

}
