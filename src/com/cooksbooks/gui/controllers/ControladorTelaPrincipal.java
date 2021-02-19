package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.gui.ScreenManager;
import com.cooksbooks.gui.Telas;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorTelaPrincipal {

    private ScreenManager screenManager;

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    private final String[] dropDownContent = {"Caderno", "Receita", "Usuario"};

    @FXML
    private ListView<CadernoReceitas> listViewCadernos;

    @FXML
    private ListView<Receita> listViewReceitas;

    @FXML
    private Label mostrarPerfil;

    @FXML
    private Button botaoCriarCaderno;

    @FXML
    private Button botaoCriarReceita;

    @FXML
    private ChoiceBox<String> choiceBoxPesquisa;

    @FXML
    private ImageView imagemPerfil;

    @FXML
    private Label nomeUsuario;

    @FXML
    private Label experienciaCulinaria;

    @FXML
    private TextField textFieldPesquisa;

    @FXML
    private Button botaoPesquisar;

    @FXML
    private Button botaoAcessarCaderno;

    @FXML
    private Button botaoAcessarReceita;

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public void inicializar(){
        this.nomeUsuario.setText(sistema.getUsuarioLogado().getNomePerfil());
        this.experienciaCulinaria.setText
                (sistema.getUsuarioLogado().getExperienciaCulinaria().toString());
        //this.imagemPerfil.getImage();
        this.listViewCadernos.setItems(FXCollections.observableArrayList(
                sistema.buscarTodosCadernosDoUsuarioAtual()));
        this.listViewReceitas.setItems((FXCollections.observableArrayList(buscarTodasReceitas())));

        this.choiceBoxPesquisa.setItems(FXCollections.observableArrayList(dropDownContent));
    }


    //TODO: fazer isso direito e colocar no lugar certo
    private List<Receita> buscarTodasReceitas(){
        List<Receita> todasReceitas = new ArrayList<>();
        for(CadernoReceitas c : sistema.buscarTodosCadernosDoUsuarioAtual()){
            todasReceitas.addAll(sistema.listarReceitasDoCaderno(c.getIdCaderno()));
        }
        return todasReceitas;
    }

    @FXML
    void handleAcessarCaderno(ActionEvent event) {
        if(listViewCadernos.getSelectionModel().getSelectedItem() != null){
            screenManager.abrirTelaCaderno(listViewCadernos.getSelectionModel().getSelectedItem());
        }else{
            //TODO? repensar passagem de parâmetros?
            alertSelecionarItem("um caderno");
        }
    }

    @FXML
    void handleAcessarReceita(ActionEvent event) {
        if(listViewReceitas.getSelectionModel().getSelectedItem() != null){
            screenManager.abrirTelaReceita(listViewReceitas.getSelectionModel().getSelectedItem());
        }else{
            alertSelecionarItem("uma receita");
        }
    }

    @FXML
    private void handleCriarCaderno() throws IOException {
        screenManager.abrirTelaCriacaoCaderno();
    }

    @FXML
    private void handleMostrarPerfil() {
        this.screenManager.abrirTelaPerfil(this.sistema.getUsuarioLogado());
    }

    @FXML
    private void handlePesquisar() throws UsuarioInexistente {
        //Object o = new Object();
        //try{
            /*switch (choiceBoxPesquisa.getValue()) {
                case "Caderno" -> o = sistema.buscarCaderno(textFieldPesquisa.getText());
                case "Receita" -> o = sistema.buscarReceita(textFieldPesquisa.getText());
                case "Usuário" -> {
                    try {
                        o = sistema.buscarUsuario(textFieldPesquisa.getText());
                    } catch (UsuarioInexistente e) {
                        System.out.println(e.getMessage());
                    }
                }
            }*/
            screenManager.abrirTelaResultadosPesquisa(textFieldPesquisa.getText());
        //}catch(NullPointerException | UsuarioInexistente e){
            //alertPesquisa();
        //}
        /*if(choiceBoxPesquisa != null){
            //TODO: alterar assinatura do método para receber nome de perfil como parâmetro
            switch (choiceBoxPesquisa.getValue()) {
                case "Caderno" -> sistema.buscarCaderno(textFieldPesquisa.getText());
                case "Receita" -> sistema.buscarReceita(textFieldPesquisa.getText());
                case "Usuário" -> {
                    try {
                        sistema.buscarUsuario(textFieldPesquisa.getText());
                    } catch (UsuarioInexistente e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }else{
            alertPesquisa();
        }*/
    }

    private void alertPesquisa(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText("Tipo de Pesquisa Não Informado");
        alert.showAndWait();
    }

    private void alertSelecionarItem(String item) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText("Nada foi Selecionado!");
        alert.setContentText(String.format("Favor selecionar %s para acessar", item));
        alert.showAndWait();
    }
}
