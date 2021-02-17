package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.*;
import com.cooksbooks.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaEditarReceita {

    private Receita receita;

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    private static ScreenManager screenManager;

    @FXML
    private TextField tfAlterarNome;

    @FXML
    private Button btConfirmarNome;

    @FXML
    private ChoiceBox<TempoPreparo> cbTempoDePreparo;

    @FXML
    private Button btConfirmarTempo;

    @FXML
    private ChoiceBox<Custo> cbCustoMedio;

    @FXML
    private Button btConfirmarCusto;

    @FXML
    private ChoiceBox<Rendimento> cbRendimento;

    @FXML
    private Button btConfirmarRendimento;

    @FXML
    private ChoiceBox<Dificuldade> cbDificuldade;

    @FXML
    private Button btConfirmarDificuldade;

    @FXML
    private TextArea taAlterarModo;

    @FXML
    private Button btConfirmarModo;

    @FXML
    private TextArea tfAlterarCategoria;

    @FXML
    private Button btConfirmarCategoria;

    @FXML
    private Button btGeralConfirmar;

    @FXML
    private Button btGeralVoltar;

    @FXML
    private ListView<Categoria> lvCategorias;

    private void initialize() {

        this.cbTempoDePreparo.getItems().addAll(TempoPreparo.values());
        this.cbCustoMedio.getItems().addAll(Custo.values());
        this.cbRendimento.getItems().addAll(Rendimento.values());
        this.cbDificuldade.getItems().addAll(Dificuldade.values());
        this.lvCategorias.getItems().addAll(receita.listarCategorias());

    }

    @FXML
    void handleConfirmarCategorias(ActionEvent event) {

    }

    @FXML
    void handleConfirmarCustoMedio(ActionEvent event) {

    }

    @FXML
    void handleConfirmarDificuldade(ActionEvent event) {

    }

    @FXML
    void handleConfirmarModoPreparo(ActionEvent event) {

    }

    @FXML
    void handleConfirmarNome(ActionEvent event) {

    }

    @FXML
    void handleConfirmarReceitaGeral(ActionEvent event) {

    }

    @FXML
    void handleConfirmarRendimento(ActionEvent event) {

    }

    @FXML
    void handleConfirmarTempoPreparo(ActionEvent event) {

    }

    @FXML
    void handleVoltar(ActionEvent event) {

    }

    public void setReceita(Receita receita){this.receita = receita;}

}
