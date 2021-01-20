package com.cooksbooks.entity;

import com.cooksbooks.utils.Categoria;

import java.util.ArrayList;
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
    private List<Categoria> categorias;
    private List<Receita> receitas;

    //Construtor completo
    public CadernoReceitas (String nomeCaderno, String informacoesCaderno, boolean visivel) {
        this.nomeCaderno = nomeCaderno;
        this.informacoesCaderno = informacoesCaderno;
        this.visivel = visivel;
        this.receitas = new ArrayList<>();
    }


    public void adicionarReceita (Receita receita) {
        receitas.add(receita);
    }

    public void removerReceita (Receita receita) {
        receitas.remove(receita);
    }

    /**
     * Listar as categorias das receitas presentes
     * nesse caderno.
     *
     * @return todas as categorias das receitas
     * presentes nesse caderno.
     */
    public List<Categoria> listarCategorias () {
        // TODO: COMPLETAR O MÉTODO
        /*for (Receita receitaCaderno : this.receitas) {
            for (Categoria categoria : receitaCaderno.getCategoria()) {

            }
        }*/
        return this.categorias;
    }

}
