package com.cooksbooks.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaEditarCaderno {

    //Está implementado apenas o esqueleto simples

    @FXML
    private TextField tfNovoNome;

    @FXML
    private Label lbNomeCaderno;

    @FXML
    private TextArea taAlterarDesc;

    @FXML
    private Label lbAlterarDesc;

    @FXML
    private Button btVoltar;

    @FXML
    private ListView<?> lvReceitasBuscadas;

    @FXML
    private TextField tfDigiteReceita;

    @FXML
    private Button btBuscarReceita;

    @FXML
    private Button btAddReceita;

    @FXML
    private Button btRemoveReceita;

    @FXML
    private ListView<?> lvCategoriasBuscadas;

    @FXML
    private TextField tfDigiteCategoria;

    @FXML
    private Button btBuscarCategoria;

    @FXML
    private Button btRemoveCategoria;

    @FXML
    private Button btAddCategoria;
}
