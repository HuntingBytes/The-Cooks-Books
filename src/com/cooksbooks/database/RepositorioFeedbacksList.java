package com.cooksbooks.database;

import com.cooksbooks.database.interfaces.IRepositorioFeedback;
import com.cooksbooks.entity.Feedback;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioFeedbacksList implements IRepositorioFeedback, Serializable {

  @Serial
  private static final long serialVersionUID = -8916215423092198843L;
  private static RepositorioFeedbacksList instancia = null;

  private List<Feedback> feedbackList;

  private RepositorioFeedbacksList() {
    this.feedbackList = new ArrayList<>();
  }

  public static RepositorioFeedbacksList getInstancia() {
    if (RepositorioFeedbacksList.instancia == null) {
      RepositorioFeedbacksList.instancia = RepositorioFeedbacksList.lerArquivo();
    }
    return RepositorioFeedbacksList.instancia;
  }

  private static RepositorioFeedbacksList lerArquivo() {
    RepositorioFeedbacksList instanciaLocal;

    File in = new File("feedbacks.dat");
    FileInputStream fis;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(in);
      ois = new ObjectInputStream(fis);
      Object o = ois.readObject();
      instanciaLocal = (RepositorioFeedbacksList) o;
    } catch (Exception e) {
      instanciaLocal = new RepositorioFeedbacksList();
    } finally {
      if (ois != null) {
        try {
          ois.close();
        } catch (IOException e) {/* Silent exception */
        }
      }
    }
    return instanciaLocal;
  }

  @Override
  public void salvarArquivo() {
    if (RepositorioFeedbacksList.instancia == null) {
      return;
    }
    File out = new File("feedbacks.dat");
    FileOutputStream fos;
    ObjectOutputStream oos = null;

    try {
      fos = new FileOutputStream(out);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(RepositorioFeedbacksList.instancia);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          /* Silent */
        }
      }
    }
  }

  @Override
  public void cadastrarFeedback(Feedback feedback) {
    this.feedbackList.add(feedback);
  }

  @Override
  public Feedback buscarFeedback(String idFeedback) {
    for (Feedback feedback : this.feedbackList) {
      if (feedback.getIdFeedback().equals(idFeedback)) {
        return feedback;
      }
    }
    return null;
  }

  @Override
  public boolean existeFeedback(String idFeedback) {
    for (Feedback feedback : this.feedbackList) {
      if (feedback.getIdFeedback().equals(idFeedback)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<Feedback> buscarTodosFeedbacks() {
    return Collections.unmodifiableList(this.feedbackList);
  }

  @Override
  public List<Feedback> buscarTodosFeedbacks(LocalDate dataInicial, LocalDate dataFinal) {
    List<Feedback> feedbacks = new ArrayList<>();
    for (Feedback feedback : this.feedbackList) {
      LocalDate dataFeedback = feedback.getData().toLocalDate();
      if (dataFeedback.isAfter(dataInicial) && dataFeedback.isBefore(dataFinal)) {
        feedbacks.add(feedback);
      }
    }
    return Collections.unmodifiableList(feedbacks);
  }

  @Override
  public int totalFeedbacks() {
    return this.feedbackList.size();
  }
}
