package com.cooksbooks.controllers;

import com.cooksbooks.dados.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.Receita;

public class ControladorReceita {

  private IRepositorioReceita repositorioReceitas;
  private static ControladorReceita instancia;

  /**
   * Construtor de ControladorReceita
   *
   * Receberá a instância para o repositório
   * de Receitas.
   */
  public ControladorReceita {
    this.repositorioReceitas = RepositorioReceitas.getInstancia();
  }

  /**
   * Copiei esse método de Gabriel e sinto
   * que essa foi a minha maior vigarice.
   *
   * @return a instancia criada
   */
  public static ControladorReceita getInstancia() {
    if (instancia == null) {
      instancia = new ControladorReceita();
    }
    return instancia;
  }

  /**
   * Crud - Create
   * @param receita
   */
  public void cadastrarReceita(Receita receita) {
    if (!this.repositorioReceitas.existeReceitas(receita)) {
      this.repositorioReceitas.cadastrarReceitas(receita);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  /**
   * Crud - Delete
   * @param idReceita
   */

  public void removerReceita(String idReceita) {
    if (this.repositorioReceitas.existeReceitas(idReceita)) {
      this.repositorioReceitas.removerReceitas(idReceita);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  /**
   * Crud - Read
   * @param idReceita
   * @return Receita buscada pelo usuário
   */
  public Receita buscarReceita(String idReceita) {
    if (this.repositorioReceitas.existeReceitas(idReceita)) {
      return this.repositorioReceitas.buscarReceitas(idReceita);
    } else {
      System.out.println("Infelizmente essa receita não existe na nossa plataforma");
    }
    return null;
  }

  /**
   * Crud - Update (Título da Receita)
   *
   * @param idReceitaExistente
   * @param novoTituloReceita
   */
  public void alterarTituloReceita (String idReceitaExistente, String novoTituloReceita) {
    this.repositorioReceitas.alterarTituloReceita(idReceitaExistente, novoTituloReceita);
    this.repositorioReceitas.salvarArquivo();
  }

  /**
   * Crud - Update (Modo de Preparo)
   *
   * @param idReceita
   * @param novoModoPreparo
   */
  public void alterarModoPreparoReceita (String idReceita, String novoModoPreparo) {
    this.repositorioReceitas.alterarModoPreparo(idReceita, modoPreparoASerMudade)
    this.repositorioReceitas.salvarArquivo();
  }

}
