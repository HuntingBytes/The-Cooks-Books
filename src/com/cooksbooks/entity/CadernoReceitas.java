package com.cooksbooks.entity;

import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Comentario;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Nota;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * CadernoReceita é responsável por agrupar diversas receitas criadas/escolhidas pelo usuário.
 * <p>
 * CadernoReceita possui métodos responsáveis por adicionar e remover uma receita e listar as
 * Categorias das receitas.
 *
 * @version 1.0
 */

public class CadernoReceitas implements Serializable {

  @Serial
  private static final long serialVersionUID = 7978808538548640443L;

  private String nomeCaderno;
  private String informacoesCaderno;
  private String idDono;
  private String idCaderno;
  private boolean cadernoPublico;
  private List<Categoria> categorias;
  private Nota notaCaderno;
  private Dificuldade dificuldadeCaderno;
  private Comentario comentarioCaderno;

  /**
   * Construtor completo da classe. Inicializa também as listas.
   *
   * @param nomeCaderno Nome do caderno.
   * @param informacoesCaderno Informações do caderno.
   * @param cadernoPublico Booleano se o caderno é público ou não.
   * @param categorias Lista com as categorias do caderno.
   * @param notaCaderno Nota do caderno.
   * @param dificuldadeCaderno Dificuldade do caderno.
   * @param comentarioCaderno Único comentário do caderno.
   */
  public CadernoReceitas(String nomeCaderno, String informacoesCaderno, boolean cadernoPublico,
      List<Categoria> categorias, Nota notaCaderno, Dificuldade dificuldadeCaderno,
      Comentario comentarioCaderno, String idDono) {
    this.nomeCaderno = nomeCaderno;
    this.informacoesCaderno = informacoesCaderno;
    this.cadernoPublico = cadernoPublico;
    this.categorias = categorias;
    this.notaCaderno = notaCaderno;
    this.dificuldadeCaderno = dificuldadeCaderno;
    this.comentarioCaderno = comentarioCaderno;
    this.idDono = idDono;
  }

  public CadernoReceitas() {
    this.nomeCaderno = "";
    this.informacoesCaderno = "";
    this.cadernoPublico = true;
    this.categorias = new ArrayList<>();
    this.notaCaderno = null;
    this.dificuldadeCaderno = Dificuldade.FACIL;
    this.comentarioCaderno = null;
    this.idDono = "";
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public List<Categoria> listarCategorias() {
    return this.categorias;
  }

  public String getNomeCaderno() {
    return nomeCaderno;
  }

  public void setNomeCaderno(String nomeCaderno) {
    this.nomeCaderno = nomeCaderno;
  }

  public String getInformacoesCaderno() {
    return informacoesCaderno;
  }

  public void setInformacoesCaderno(String informacoesCaderno) {
    this.informacoesCaderno = informacoesCaderno;
  }

  public boolean isCadernoPublico() {
    return cadernoPublico;
  }

  public void setCadernoPublico(boolean cadernoPublico) {
    this.cadernoPublico = cadernoPublico;
  }

  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
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
