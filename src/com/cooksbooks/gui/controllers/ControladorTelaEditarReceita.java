package com.cooksbooks.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaEditarReceita {

    //Apenas Esqueleto Simples

    @FXML
    private TextField tfAlterarNome;

    @FXML
    private Button btConfirmarNome;

    @FXML
    private Button btCancelarNome;

    @FXML
    private Label lbAlterarNome;

    @FXML
    private ChoiceBox<?> cbTempoDePreparo;

    @FXML
    private Label lbTempoDePreparo;

    @FXML
    private Button btConfirmarTempo;

    @FXML
    private Button btCancelarTempo;

    @FXML
    private Label lbCustoMedio;

    @FXML
    private ChoiceBox<?> cbCustoMedio;

    @FXML
    private Button btConfirmarCusto;

    @FXML
    private Button btCancelarCusto;

    @FXML
    private Label lbRendimento;

    @FXML
    private ChoiceBox<?> cbRendimento;

    @FXML
    private Button btConfirmarRendimento;

    @FXML
    private Button btCancelarRendimento;

    @FXML
    private Label lbDificuldade;

    @FXML
    private ChoiceBox<?> cbDificuldade;

    @FXML
    private Button btConfirmarDificuldade;

    @FXML
    private Button brCancelarDificuldade;

    @FXML
    private Separator spSeparadorVertical;

    @FXML
    private Label lbAlterarModoPreparo;

    @FXML
    private TextArea taAlterarModo;

    @FXML
    private Button btConfirmarModo;

    @FXML
    private Button btCancelarModo;

    @FXML
    private Label lbAlterarCategoria;

    @FXML
    private TextArea tfAlterarCategoria;

    @FXML
    private Button btConfirmarCategoria;

    @FXML
    private Button btCancelarCategoria;

    @FXML
    private Separator spSeparadorHorizontal;

    @FXML
    private Button btGeralConfirmar;

    @FXML
    private Button btGeralReverter;

    @FXML
    private Button btGeralVoltar;
}
