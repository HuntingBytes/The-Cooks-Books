package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Receita;
import java.util.List;

public interface IRepositorioReceita {

    void salvarArquivo(); 

    boolean existeReceita(String receitaExiste);

    void cadastrarReceita(Receita receitaAdd);

    // throws ReceitaInexistente
    void removerReceita(String receitaRemove);

    // throws ReceitaInexistente
    Receita buscarReceita(String receitaBusca);

    long totalReceitas();

    // throws ReceitaInexistente
    void alterarModoPreparoReceita(String login, String modoPreparo);

    // throws ReceitaInexistente
    void alterarTituloReceita(String login, String titulo);

    List<Receita> listarReceitasCaderno(String idCaderno);
}
