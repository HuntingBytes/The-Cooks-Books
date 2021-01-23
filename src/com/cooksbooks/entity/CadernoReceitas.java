package com.cooksbooks.entity;

import com.cooksbooks.utils.Categoria;
import com.cooksbooks.utils.Comentario;
import com.cooksbooks.utils.Dificuldade;
import com.cooksbooks.utils.Nota;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * CadernoReceita é responsável por agrupar diversas receitas criadas/escolhidas pelo usuário.
 *
 * CadernoReceita possui métodos responsáveis por adicionar e remover uma receita e listar as
 * Categorias das receitas.
 *
 * @version 1.0
 */

public class CadernoReceitas implements Serializable {

  @Serial
  private static final long serialVersionUID = 7978808538548640443L;

  private final String nomeCaderno;
  private final String informacoesCaderno;
  private final boolean cadernoPublico;
  private List<Categoria> categorias;
  private final List<Receita> receitas;
  private Nota notaCaderno;
  private Dificuldade dificuldadeCaderno;
  private Comentario comentarioCaderno;
  private String idDono;
  private String idCaderno;

  /**
   * Construtor completo da classe.
   * Inicializa também as listas.
   *
   * @param nomeCaderno
   * @param informacoesCaderno
   * @param cadernoPublico
   * @param categorias
   * @param receitas
   * @param notaCaderno
   * @param dificuldadeCaderno
   * @param comentarioCaderno
   */
  public CadernoReceitas(String nomeCaderno, String informacoesCaderno, boolean cadernoPublico,
      List<Categoria> categorias, List<Receita> receitas, Nota notaCaderno,
      Dificuldade dificuldadeCaderno, Comentario comentarioCaderno, String idDono) {
    this.nomeCaderno = nomeCaderno;
    this.informacoesCaderno = informacoesCaderno;
    this.cadernoPublico = cadernoPublico;
    this.categorias = new ArrayList<>();
    this.receitas = new ArrayList<>();
    this.notaCaderno = notaCaderno;
    this.dificuldadeCaderno = dificuldadeCaderno;
    this.comentarioCaderno = comentarioCaderno;
    this.idDono = idDono;
  }

  public void adicionarReceita(Receita receita) {
    receitas.add(receita);
  }

  public void removerReceita(Receita receita) {
    receitas.remove(receita);
  }

  public List<Categoria> listarCategorias () { return this.categorias; }

  /**
   * Métodos Get e Set da classe
   * @return muitas coisas
   */
  public String getNomeCaderno() {
    return nomeCaderno;
  }

  public String getInformacoesCaderno() {
    return informacoesCaderno;
  }

  public boolean isCadernoPublico() {
    return cadernoPublico;
  }

  public List<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  public List<Receita> getReceitas() {
    return receitas;
  }

  public Nota getNotaCaderno() {
    return notaCaderno;
  }

  public void setNotaCaderno(Nota notaCaderno) {
    this.notaCaderno = notaCaderno;
  }

  public Dificuldade getDificuldadeCaderno() {
    return dificuldadeCaderno;
  }

  public void setDificuldadeCaderno(Dificuldade dificuldadeCaderno) {
    this.dificuldadeCaderno = dificuldadeCaderno;
  }

  public Comentario getComentarioCaderno() {
    return comentarioCaderno;
  }

  public void setComentarioCaderno(Comentario comentarioCaderno) {
    this.comentarioCaderno = comentarioCaderno;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getIdDono() {
    return idDono;
  }

  public void setIdDono(String idDono) {
    this.idDono = idDono;
  }

  public String getIdCaderno() {
    return idCaderno;
  }

  public void setIdCaderno(String idCaderno) {
    this.idCaderno = idCaderno;
  }
}
