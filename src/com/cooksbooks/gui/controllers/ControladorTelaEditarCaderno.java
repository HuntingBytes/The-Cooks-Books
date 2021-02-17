package com.cooksbooks.gui.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorTelaEditarCaderno {

    //Está implementado apenas o esqueleto simples

    private CadernoReceitas caderno;

    @FXML
    private TextField tfNovoNome;

    @FXML
    private Button btAlterarNome;

    @FXML
    private Label lbNomeCaderno;

    @FXML
    private TextArea taAlterarDesc;

    @FXML
    private Label lbAlterarDesc;

    @FXML
    private Button btAlterarDescricao;


    @FXML
    private Button btVoltar;

    @FXML
    private ListView<Receita> lvReceitasBuscadas;

    @FXML
    private Button btAddReceita;

    @FXML
    private Button btRemoveReceita;

    @FXML
    private ListView<Categoria> lvCategoriasBuscadas;

    @FXML
    private Button btRemoveCategoria;

    @FXML
    private Button btAddCategoria;

    @FXML
    void handleAddCat(ActionEvent event) {

    }

    @FXML
    void handleAddReceita(ActionEvent event) {

    }

    @FXML
    void handleAlterarDescricao(ActionEvent event) {

    }

    @FXML
    void handleAlterarNome(ActionEvent event) {

    }

    @FXML
    void handleRemoveCat(ActionEvent event) {

    }

    @FXML
    void handleRemoveReceita(ActionEvent event) {

    }

    @FXML
    void handleVoltar(ActionEvent event) {

    }


    public void setCaderno(CadernoReceitas caderno) {
        this.caderno = caderno;
    }
}
