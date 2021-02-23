package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.entity.utils.Rendimento;
import java.util.List;

public interface IRepositorioReceita {

  void cadastrarReceita(Receita receitaAdd);

  // throws ReceitaInexistente
  void removerReceita(String receitaRemove);

  boolean existeReceita(String receitaExiste);

  // throws ReceitaInexistente
  Receita buscarReceita(String receitaBusca);

  // throws ReceitaInexistente
  void alterarTituloReceita(String login, String titulo);

  // throws ReceitaInexistente
  void alterarModoPreparoReceita(String login, String modoPreparo);

  // throws ReceitaInexistente
  void alterarCusto(String idReceita, Custo custo);

  // throws ReceitaInexistente
  void alterarRendimento(String idReceita, Rendimento rendimento);

  // throws ReceitaInexistente
  void alterarDificuldade(String idReceita, Dificuldade dificuldade);

  // throws ReceitaInexistente
  void adicionarCategoria(String idReceita, Categoria categoria);

  // throws ReceitaInexistente
  void removerCategoria(String idReceita, Categoria categoria);

  // throws ReceitaInexistente
  void adicionarIngrediente(String idReceita, Ingrediente ingrediente);

  // throws ReceitaInexistente
  void removerIngrediente(String idReceita, Ingrediente ingrediente);

  // throws ReceitaInexistente
  void alterarReceita(String idReceita, Receita novaReceita);

  List<Receita> listarReceitasCaderno(String idCaderno);

  long totalReceitas();

  void salvarArquivo();
}
