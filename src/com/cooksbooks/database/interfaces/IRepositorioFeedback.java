package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Feedback;
import java.time.LocalDate;
import java.util.List;

public interface IRepositorioFeedback {

  void cadastrarFeedback(Feedback feedback);

  Feedback buscarFeedback(String idFeedback);

  boolean existeFeedback(String idFeedback);

  List<Feedback> buscarTodosFeedbacks();

  List<Feedback> buscarTodosFeedbacks(LocalDate dataInicial, LocalDate dataFinal);

  int totalFeedbacks();

  void salvarArquivo();
}
