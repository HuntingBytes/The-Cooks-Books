package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Feedback;
import com.cooksbooks.entity.Usuario;
import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ControladorTelaEnviarFeedback {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private TextArea taTexto;

  @FXML
  private void handleEnviar() {
    if (taTexto.getText() != null) {
      Usuario usuarioAtual = this.sistema.getUsuarioLogado();
      Feedback feedback = new Feedback(taTexto.getText(), LocalDateTime.now(),
          usuarioAtual.getLogin(), usuarioAtual.getNomePerfil());
      this.sistema.cadastrarFeedback(feedback);
      this.clearCampos();
    }
  }

  private void clearCampos() {
    this.taTexto.clear();
  }
}
