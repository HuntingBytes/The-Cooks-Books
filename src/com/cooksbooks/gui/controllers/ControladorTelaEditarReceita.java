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
    private Button btGeralConfirmar;

    @FXML
    private Button btGeralVoltar;

    @FXML
    private Button btAddCat;

    @FXML
    private Button btRemoverCat;

    @FXML
    private ListView<Categoria> lvCategorias;

    private void initialize() {

        this.cbTempoDePreparo.getItems().addAll(TempoPreparo.values());
        this.cbCustoMedio.getItems().addAll(Custo.values());
        this.cbRendimento.getItems().addAll(Rendimento.values());
        this.cbDificuldade.getItems().addAll(Dificuldade.values());
        this.lvCategorias.getItems().addAll(Categoria.values());

    }

    @FXML
    void handleConfirmarReceitaGeral(ActionEvent event) {
        String loginMudado = tfAlterarNome.getText();
        String modoPreparoMudado = taAlterarModo.getText();
        if(!loginMudado.isBlank()){ handleConfirmarNome(event);}
        if(!modoPreparoMudado.isBlank()){handleConfirmarModoPreparo(event);}
        if(cbTempoDePreparo.getSelectionModel().getSelectedItem()!=null){ handleConfirmarTempoPreparo(event);}
        if(cbDificuldade.getSelectionModel().getSelectedItem()!=null){ handleConfirmarDificuldade(event);}
        if(cbCustoMedio.getSelectionModel().getSelectedItem()!=null){ handleConfirmarCustoMedio(event);}
        if(cbRendimento.getSelectionModel().getSelectedItem()!=null){ handleConfirmarRendimento(event);}
    }

    @FXML
    void handleConfirmarCustoMedio(ActionEvent event) {
        receita.setCusto(cbCustoMedio.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleConfirmarDificuldade(ActionEvent event) {
        receita.setDificuldade(cbDificuldade.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleConfirmarModoPreparo(ActionEvent event) {
        receita.setModoPreparo(taAlterarModo.getText());
    }

    @FXML
    void handleConfirmarNome(ActionEvent event) {
        receita.setTitulo(tfAlterarNome.getText());
    }

    @FXML
    void handleConfirmarRendimento(ActionEvent event) {
        receita.setRendimento(cbRendimento.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleConfirmarTempoPreparo(ActionEvent event) {
        receita.setTempoPreparo(cbTempoDePreparo.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleRemoverCat(ActionEvent event) {
        receita.removerCategoria(lvCategorias.getSelectionModel().getSelectedItem());
    }

    @FXML
    void handleAddCat(ActionEvent event) {
        receita.setCategorias(lvCategorias.getSelectionModel().getSelectedItems());
    }

    @FXML
    void handleVoltar(ActionEvent event) {
        screenManager.abrirTelaReceita(receita);
    }

    public void setReceita(Receita receita){this.receita = receita;}

}
