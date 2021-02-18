package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Receita;
import java.util.List;

public interface IRepositorioReceita {

  void cadastrarReceita(Receita receitaAdd);

  // throws ReceitaInexistente
  void removerReceita(String receitaRemove);

  boolean existeReceita(String receitaExiste);

  // throws ReceitaInexistente
  Receita buscarReceita(String receitaBusca);

  // throws ReceitaInexistente
  void alterarModoPreparoReceita(String login, String modoPreparo);

  // throws ReceitaInexistente
  void alterarTituloReceita(String login, String titulo);

  List<Receita> listarReceitasCaderno(String idCaderno);

  long totalReceitas();

  void salvarArquivo();
}
