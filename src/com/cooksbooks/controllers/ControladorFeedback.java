package com.cooksbooks.controllers;

import com.cooksbooks.database.RepositorioFeedbacksList;
import com.cooksbooks.database.RepositorioUsuariosList;
import com.cooksbooks.database.interfaces.IRepositorioFeedback;
import com.cooksbooks.entity.Feedback;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorFeedback {

  private static ControladorFeedback instancia;

  private final IRepositorioFeedback repositorioFeedbacks;

  private ControladorFeedback() {
    this.repositorioFeedbacks = RepositorioFeedbacksList.getInstancia();
  }

  public static ControladorFeedback getInstancia() {
    if (instancia == null) {
      instancia = new ControladorFeedback();
    }
    return instancia;
  }

  public void cadastrarFeedback(Feedback feedback) {
    feedback.setIdFeedback(String.format("feedback-%d",
        this.repositorioFeedbacks.totalFeedbacks()));
    if (this.isFeedbackValido(feedback)) {
      if (!this.repositorioFeedbacks.existeFeedback(feedback.getIdFeedback())) {
        this.repositorioFeedbacks.cadastrarFeedback(feedback);
        this.repositorioFeedbacks.salvarArquivo();
      }
    }
  }

  public Feedback buscarFeedback(String idFeedback) {
    if (this.repositorioFeedbacks.existeFeedback(idFeedback)) {
      return this.repositorioFeedbacks.buscarFeedback(idFeedback);
    }
    return null; // Correto seria levantar exceção
  }

  public List<Feedback> buscarTodosFeedbacks() {
    return this.repositorioFeedbacks.buscarTodosFeedbacks();
  }

  public List<Feedback> buscarTodosFeedbacks(LocalDate dataInicial, LocalDate dataFinal) {
    if (dataInicial.isBefore(dataFinal)) {
      return this.repositorioFeedbacks.buscarTodosFeedbacks(dataInicial, dataFinal);
    }
    return new ArrayList<>(); // Correto seria levantar exceção
  }

  private boolean isFeedbackValido(Feedback feedback) {
    return true;
  }
}
