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
    this.repositorioReceitas = RepositorioReceita.getInstancia();
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

  public void cadastrarReceita(Receita receita) {
    if (!this.repositorioReceitas.existeReceita(receita)) {
      this.repositorioReceitas.cadastrarReceita(receita);
    }
  }

  public void removerReceita(String idReceita) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      this.repositorioReceitas.removerReceita(idReceita);
    }
  }

  /**
   * Averiguar a funcionalidade dessa
   * método. buscarReceita sus.
   *
   * @param idReceita
   * @return
   */
  public Receita buscarReceita(String idReceita) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      return this.repositorioReceitas.buscarReceita(idReceita);
    } else {
      System.out.println("Infelizmente essa receita não existe na nossa plataforma");
    }
    return null;
  }

  /**
   * A terminar mais coisas aqui
   */
}
