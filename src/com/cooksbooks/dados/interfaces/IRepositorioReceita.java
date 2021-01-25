package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Receita;
import java.util.List;

public interface IRepositorioReceita {

    void salvarArquivo(); 

    boolean existeReceita(String receitaExiste);

    void cadastrarReceita(Receita receitaAdd);

    void removerReceita(String receiraRemove);

    Receita buscarReceita(String receitaBusca);

    long totalReceitas();

    void alterarModoPreparo(String login, String modoPreparo);

    void alterarTitulo(String login, String titulo);
    
}
