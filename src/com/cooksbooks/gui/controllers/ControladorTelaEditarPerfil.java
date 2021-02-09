package com.cooksbooks.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladorTelaEditarPerfil {

    //Está implementado apenas o esqueleto simples

    @FXML
    private ImageView ivImagemUsuario;

    @FXML
    private Label lbNomeUsuario;

    @FXML
    private Label lbExperiencia;

    @FXML
    private Label lbAlterarNome;

    @FXML
    private TextField tfDigitarNome;

    @FXML
    private Button btAlterarNome;

    @FXML
    private Label lbAlterarExperiencia;

    @FXML
    private Button btAlterarExperiencia;

    @FXML
    private ChoiceBox<?> cbEscolherExperiencia;

    @FXML
    private Button btVoltar;

    @FXML
    private Label lbAlterarSobre;

    @FXML
    private TextArea taDigitarSobre;

    @FXML
    private Button btAlterarSobre;

    @FXML
    private Button btSalvarPerfil;

    @FXML
    private Button btCancelar;
}
