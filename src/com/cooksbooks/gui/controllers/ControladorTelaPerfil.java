package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControladorTelaPerfil {

    private Usuario usuarioDoPefil;

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    private ScreenManager screenManager;

    @FXML
    private Label lbNomeUsuario;

    @FXML
    private Button btReceitas;

    @FXML
    private Button btCadernos;

    @FXML
    private Button btEditarPerfil;

    @FXML
    private Button btVoltar;

    @FXML
    private TextArea taSobreMim;


    @FXML
    private TextField tfExperiencia;

    @FXML
    private ChoiceBox<CadernoReceitas> cbCadernosPerfil;

    @FXML
    private ChoiceBox<Receita> cbReceitasPerfil;

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    private void initialize() {
        if(!usuarioDoPefil.equals(sistema.getUsuarioLogado())){ this.btEditarPerfil.setVisible(false); }
        this.cbCadernosPerfil.getItems().addAll(sistema.buscarTodosCadernosDoUsuario(usuarioDoPefil.getLogin()));
        //tem que criar um buscarTodasReceitasUsuario para inicializar
        //this.cbCadernosPerfil.getItems().addAll(sistema.buscarTodosCadernosDoUsuario(usuarioDoPefil.getLogin()));
        this.cbCadernosPerfil.setVisible(false);
        this.cbReceitasPerfil.setVisible(false);
        this.lbNomeUsuario.setText(usuarioDoPefil.getNomePerfil());
        this.taSobreMim.setText(usuarioDoPefil.getBiografia());
        this.tfExperiencia.setText(usuarioDoPefil.getExperienciaCulinaria().toString());

    }

    @FXML
    void handlEditarPerfil(ActionEvent event) {
        screenManager.abrirTelaEditarPerfil();
    }

    @FXML
    void handleAcessarCadernos(ActionEvent event) {
        cbCadernosPerfil.setVisible(true);
    }

    @FXML
    void handleIrCaderno(MouseEvent event) {
        screenManager.abrirTelaCaderno(cbCadernosPerfil.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleAcessarReceitas(ActionEvent event) {

    }

    @FXML
    void handleVoltar(ActionEvent event) {
        screenManager.abrirTelaPrincipal();
    }

    public void setUsuarioDoPefil(Usuario usuarioDoPefil){this.usuarioDoPefil = usuarioDoPefil; }
}
