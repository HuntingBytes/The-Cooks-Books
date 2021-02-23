package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Relatorio;
import com.cooksbooks.entity.utils.Comentario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ControladorTelaRelatorio {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private DatePicker dpDataInicial;

  @FXML
  private DatePicker dpDataFinal;

  @FXML
  private Button btGerar;

  @FXML
  private TextArea taResultado;

  @FXML
  private Button btFechar;

  @FXML
  private void handleGerarRelatorio() {
    if (areCamposValidos()) {
      Relatorio relatorio = sistema.gerarRelatorio(
          this.dpDataInicial.getValue(), this.dpDataFinal.getValue());
      this.taResultado.setText(this.formatRelatorio(relatorio));
    }
  }

  @FXML
  private void handleFechar() {
    ((Stage) this.btFechar.getScene().getWindow()).close();
    clearCampos();
  }

  private boolean areCamposValidos() {
    LocalDate dataInicial = this.dpDataInicial.getValue();
    LocalDate dataFinal = this.dpDataFinal.getValue();
    return dataInicial != null && dataFinal != null && dataFinal.isAfter(dataInicial);
  }

  private void clearCampos() {
    this.dpDataInicial.setValue(null);
    this.dpDataFinal.setValue(null);
    this.taResultado.setText("");
  }

  private String formatRelatorio(Relatorio relatorio) {
    StringBuilder result = new StringBuilder();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    result.append(String.format("%s\n", "Relatório do Sistema"));
    result.append(String.format("Período: %s - %s\n",
            dateFormatter.format(relatorio.getDataIncial()),
            dateFormatter.format(relatorio.getDataFinal())));
    result.append(String.format("Quantidade de usuários cadastrados: %d\n",
            relatorio.getQtdUsuariosCadastrados()));
    result.append(String.format("Quantidade de usuários ativos: %d\n",
        relatorio.getQtdUsuariosAtivos()));
    result.append(String.format("Quantidade de novos usuários: %d\n",
            relatorio.getQtdNovosUsuarios()));
    result.append(String.format("Percentual usuários ativos: %.2f%%\n",
        relatorio.percentualUsuariosAtivos()));
    result.append(String.format("Percentual novos usuários: %.2f%%\n",
        relatorio.percentualAumentoUsuarios()));
    result.append(String.format("%s\n", "Feedbacks recebidos:"));
    for (Comentario comentario : relatorio.listarComentarios()) {
      result.append(String.format("Usuário: %s Data: %s\n\t%s\n", comentario.getNomeUsuario(),
          dateFormatter.format(comentario.getData()),
          comentario.getTexto()));
    }
    return result.toString();
  }
}
