package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.gui.ScreenManager;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladorTelaPerfil {

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    private static ScreenManager screenManager;

    static {
        try {
            screenManager = ScreenManager.getInstancia();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private ImageView ivImagemPerfil;

    @FXML
    private Label lbNomeUsuario;

    @FXML
    private Button btMinhasReceitas;

    @FXML
    private Button btMeusCadernos;

    @FXML
    private Button btEditarPerfil;

    @FXML
    private Button btVoltar;

    @FXML
    private TextArea taSobreMim;

    @FXML
    private Label lbSobreMim;

    @FXML
    private Label lbExperiencia;

    @FXML
    private TextField tfExperiencia;

    private void initialize() {

        this.lbNomeUsuario.setText(sistema.getUsuarioLogado().getNomePerfil());
        this.taSobreMim.setText(sistema.getUsuarioLogado().getBiografia());
        this.tfExperiencia.setText(sistema.getUsuarioLogado().getExperienciaCulinaria().toString());

    }

    @FXML
    void handlEditarPerfil(ActionEvent event) {
        screenManager.abrirTelaEditarPerfil();
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        screenManager.abrirTelaPrincipal();
    }
}
