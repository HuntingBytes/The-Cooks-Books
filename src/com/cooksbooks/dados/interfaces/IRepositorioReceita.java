package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Receita;
import java.util.List;

public interface IRepositorioReceita {

    void salvarArquivo(); 

    boolean existeReceita(String receitaExiste);

    void cadastrarReceita(String receitaAdd);

    void removerReceita(String receiraRemove);

    Receita buscarReceita(String receitaBusca);

    long totalReceitas();
    
}
