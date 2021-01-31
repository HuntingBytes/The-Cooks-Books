package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Receita;
import java.util.List;

public interface IRepositorioReceita {

    void salvarArquivo(); 

    boolean existeReceita(String receitaExiste);

    void cadastrarReceita(Receita receitaAdd);

    void removerReceita(String receitaRemove);

    Receita buscarReceita(String receitaBusca);

    long totalReceitas();

    void alterarModoPreparoReceita(String login, String modoPreparo);

    void alterarTituloReceita(String login, String titulo);

    List<Receita> listarReceitasCaderno(String idCaderno);
}
