package com.cooksbooks.entity.utils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A classe Comentário permite ao Usuário opinar sobre o Caderno de Receitas e sobre as Receitas.
 * Além de também ser exibido no Relatório (classe disponível para uso do Administrador)
 */

public class Comentario implements Serializable {

  @Serial
  private static final long serialVersionUID = 648566545391655556L;

  private String texto;
  private String nomeUsuario;
  private String nomePerfil;
  private LocalDateTime data;

  public Comentario(String texto, LocalDateTime data, String nomeUsuario, String nomePerfil) {
    this.texto = texto;
    this.data = data;
    this.nomeUsuario = nomeUsuario;
    this.nomePerfil = nomePerfil;
  }

  /**
   * Permite ao Usuário e ao Administrador editar comentários já feitos.
   *
   * @param texto
   */
  public void editarTexto(String texto) {
    this.texto = texto;
  }

  @Override
  public String toString() {
    return "Comentário: " + texto + "\n" + "Data: " + data + "\n" + "Usuário: " + nomeUsuario + "\n"
        + "Perfil: " + nomePerfil;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Comentario)) {
      return false;
    }
    Comentario that = (Comentario) o;
    return Objects.equals(texto, that.texto) && Objects.equals(data, that.data)
        && Objects.equals(nomeUsuario, that.nomeUsuario) && Objects
        .equals(nomePerfil, that.nomePerfil);
  }

  @Override
  public int hashCode() {
    return Objects.hash(texto, data, nomeUsuario, nomePerfil);
  }

  //Setters e Getters da classe

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public LocalDateTime getData() {
    return data;
  }

  public void setData(LocalDateTime data) {
    this.data = data;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getNomePerfil() {
    return nomePerfil;
  }

  public void setNomePerfil(String nomePerfil) {
    this.nomePerfil = nomePerfil;
  }
}
