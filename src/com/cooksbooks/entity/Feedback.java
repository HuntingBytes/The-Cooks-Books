package com.cooksbooks.entity;

import com.cooksbooks.entity.utils.Comentario;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Feedback extends Comentario implements Serializable {

  @Serial
  private static final long serialVersionUID = 6381874116293826604L;

  private String idFeedback;

  public Feedback(String texto, LocalDateTime data, String nomeUsuario,
      String nomePerfil) {
    super(texto, data, nomeUsuario, nomePerfil);
    this.idFeedback = "";
  }

  public Feedback(String texto, LocalDateTime data, String nomeUsuario,
      String nomePerfil, String idFeedback) {
    super(texto, data, nomeUsuario, nomePerfil);
    this.idFeedback = idFeedback;
  }

  public String getIdFeedback() {
    return this.idFeedback;
  }

  public void setIdFeedback(String idFeedback) {
    this.idFeedback = idFeedback;
  }
}
