package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Receita;
import java.util.List;

public interface IRepositorioReceita {

    void salvarArquivo(); 

    boolean existeReceita(Receita receitaExiste);

    void cadastrarReceita(Receita receitaAdd);

    void removerReceita(Receita receiraRemove);

    Receita buscarReceita(Receita receitaBusca);

    long totalReceitas();
    
}
