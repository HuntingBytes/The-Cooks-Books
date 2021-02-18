package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.gui.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControladorTelaEditarPerfil {

    private Usuario usuarioDoPerfil;

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    private static ScreenManager screenManager;

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
    private ChoiceBox<ExperienciaCulinaria> cbEscolherExperiencia;

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

    private void initialize() {

        this.lbNomeUsuario.setText(usuarioDoPerfil.getNomePerfil());
        this.lbExperiencia.setText(usuarioDoPerfil.getExperienciaCulinaria().toString());
        this.cbEscolherExperiencia.getItems().addAll(ExperienciaCulinaria.values());

    }
    //Tem que ter algum lbErro para indicar as mudanças sendo feitas para o usuario
    @FXML
    void handleAlterarExperiencia(ActionEvent event) {
        usuarioDoPerfil.setExperienciaCulinaria(cbEscolherExperiencia.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleAlterarNome(ActionEvent event) {
        usuarioDoPerfil.setNomePerfil(tfDigitarNome.getText());
    }

    @FXML
    void handleAlterarSobreMim(ActionEvent event) {
        usuarioDoPerfil.setBiografia(taDigitarSobre.getText());
    }

    @FXML
    void handleSalvar(ActionEvent event) {

            String nomeMudado = tfDigitarNome.getText();
            String sobreMimMudado = taDigitarSobre.getText();

            if(!nomeMudado.isBlank()){ handleAlterarNome(event);}
            if(!sobreMimMudado.isBlank()){handleAlterarSobreMim(event);}
            if(cbEscolherExperiencia.getSelectionModel().getSelectedItem()!=null){ handleAlterarExperiencia(event);}

    }

    @FXML
    void handleVoltar(ActionEvent event) {
        screenManager.abrirTelaPerfil(usuarioDoPerfil);
    }

    public void setUsuarioDoPerfil(Usuario usuarioDoPerfil) {
        this.usuarioDoPerfil = usuarioDoPerfil;
    }
}
