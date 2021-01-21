package com.cooksbooks.entity;

import com.cooksbooks.utils.Categoria;
import java.util.List;

/**
 * CadernoReceita é responsável por agrupar diversas receitas criadas/escolhidas pelu usuário.
 * <p>
 * CadernoReceita possui métodos responsáveis por adicionar e remover uma receita e listar as
 * Categorias das receitas.
 *
 * @version 1.0
 */

public class CadernoReceitas {

  //Atributos
  private final String nomeCaderno;
  private final String informacoesCaderno;
  private final boolean cadernoPublico;
  private List<Categoria> categorias;
  private final List<Receita> receitas;

  //Construtor completo
  public CadernoReceitas(String nomeCaderno, String informacoesCaderno, boolean cadernoPublico) {
    this.nomeCaderno = nomeCaderno;
    this.informacoesCaderno = informacoesCaderno;
    this.cadernoPublico = cadernoPublico;
    this.categorias = null;
    this.receitas = null;
  }

  public void adicionarReceita(Receita receita) {
    receitas.add(receita);
  }

  public void removerReceita(Receita receita) {
    receitas.remove(receita);
  }

  public List<Categoria> listarCategorias () { return this.categorias; }

  public String getNomeCaderno() {
    return nomeCaderno;
  }

  public String getInformacoesCaderno() {
    return informacoesCaderno;
  }

  public boolean isCadernoPublico() {
    return cadernoPublico;
  }
  
}
