package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControladorCadernoRelatorio {

  private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

  @FXML
  private ListView<CadernoReceitas> lvCadernosUsuario;

  @FXML
  private Button btRemoverCaderno;

  @FXML
  private Button btFechar;

  @FXML
  private Label lbTitulo;

  @FXML
  public void initialize() {
    this.lvCadernosUsuario.setCellFactory(param -> new ListCell<>() {
      @Override
      protected void updateItem(CadernoReceitas item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
          setText(null);
        } else {
          setText(String.format("%s | %s", item.getNomeCaderno(), item.getInformacoesCaderno()));
          setMaxWidth(param.getWidth());
          setPrefWidth(param.getWidth());
          setWrapText(false);
        }
      }
    });
  }

  @FXML
  private void handleRemoverItem() {
    CadernoReceitas caderno = this.lvCadernosUsuario.getSelectionModel().getSelectedItem();
    int indiceCaderno = this.lvCadernosUsuario.getSelectionModel().getSelectedIndex();
    if (caderno != null) {
      try {
        sistema.removerCaderno(caderno.getIdCaderno());
        this.lvCadernosUsuario.getItems().remove(indiceCaderno);
        this.lvCadernosUsuario.refresh();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @FXML
  private void handleFechar() {
    ((Stage) this.btFechar.getScene().getWindow()).close();
    this.clearCampos();
  }

  private void clearCampos() {
    this.lbTitulo.setText("Caderno(s) de");
    this.lvCadernosUsuario.getItems().clear();
    this.lvCadernosUsuario.refresh();
  }

  public void inicializar(String loginUsuario) {
    this.lbTitulo.setText(String.format("Caderno(s) de %s", loginUsuario));
    ObservableList<CadernoReceitas> cadernoReceitas =
        FXCollections.observableList(sistema.buscarTodosCadernosDoUsuario(loginUsuario));
    this.lvCadernosUsuario.setItems(cadernoReceitas);
  }

}
