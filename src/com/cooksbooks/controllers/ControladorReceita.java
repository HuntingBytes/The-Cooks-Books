package com.cooksbooks.controllers;

import com.cooksbooks.database.RepositorioReceitasList;
import com.cooksbooks.database.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.Receita;
import java.util.List;

public class ControladorReceita {

  private IRepositorioReceita repositorioReceitas;
  private static ControladorReceita instancia;

  /**
   * Construtor de ControladorReceita
   *
   * Receberá a instância para o repositório
   * de Receitas.
   */
  public ControladorReceita (){
    this.repositorioReceitas = RepositorioReceitasList.getInstancia();
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
    receita.setIdReceita(receita.getTitulo());
    if (!this.repositorioReceitas.existeReceita(receita.getIdReceita())) {
      this.repositorioReceitas.cadastrarReceita(receita);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  /**
   * Crud - Delete
   * @param idReceita
   */

  public void removerReceita(String idReceita) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      this.repositorioReceitas.removerReceita(idReceita);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  /**
   * Crud - Read
   * @param idReceita
   * @return Receita buscada pelo usuário
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
   * Crud - Update (Título da Receita)
   *
   * @param idReceitaExistente
   * @param novoTituloReceita
   */
  public void alterarTituloReceita (String idReceitaExistente, String novoTituloReceita) {
    if (this.repositorioReceitas.existeReceita(idReceitaExistente)) {
      this.repositorioReceitas.alterarTituloReceita(idReceitaExistente, novoTituloReceita);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  /**
   * Crud - Update (Modo de Preparo)
   *
   * @param idReceitaExistente
   * @param novoModoPreparo
   */
  public void alterarModoPreparoReceita (String idReceitaExistente, String novoModoPreparo) {
    if (this.repositorioReceitas.existeReceita(idReceitaExistente)) {
      this.repositorioReceitas.alterarModoPreparoReceita(idReceitaExistente, novoModoPreparo);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  public List<Receita> listarReceitas(String idCaderno) {
    return repositorioReceitas.listarReceitasCaderno(idCaderno);
  }

}
