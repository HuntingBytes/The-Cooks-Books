package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Relatorio;
import java.time.LocalDate;
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
      Relatorio relatorio = new Relatorio();
      relatorio.setDataIncial(this.dpDataInicial.getValue());
      relatorio.setDataFinal(this.dpDataFinal.getValue());
      relatorio.setQtdUsuariosCadastrados(0L);
      relatorio.setQtdNovosUsuarios(0L);
      relatorio.setQtdUsuariosAtivos(0L);
      relatorio.setComentarios(null);
      // Adicionar métodos na fachada para obter os valores necessários
      // Ou método para gerar um Relatorio (sistema.gerarRelatorio(DataInicial, DataFinal))
      this.taResultado.setText(relatorio.toString());
      // Adicionar uma função em Relatorio que retorna uma String
      // já formatada com todas informações
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
}
