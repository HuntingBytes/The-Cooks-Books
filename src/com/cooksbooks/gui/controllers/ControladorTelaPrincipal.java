package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.gui.Telas;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorTelaPrincipal {

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    private final String[] dropDownContent = {"Caderno", "Receita", "Usuario"};

    @FXML
    private Tab nomeUsuarioTab;

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


    private void initialize(){

        this.nomeUsuarioTab.setText(sistema.getUsuarioLogado().getNomePerfil());
        this.nomeUsuario.setText(sistema.getUsuarioLogado().getNomePerfil());
        this.experienciaCulinaria.setText
                (sistema.getUsuarioLogado().getExperienciaCulinaria().toString());
        //this.imagemPerfil.getImage();

        this.listViewCadernos.setItems(FXCollections.observableArrayList(
                sistema.buscarTodosCadernosDoUsuarioAtual()));
        this.listViewReceitas.setItems((FXCollections.observableArrayList(buscarTodasReceitas())));

        this.choiceBoxPesquisa.setItems(FXCollections.observableArrayList(dropDownContent));
    }


    //TODO: fazer isso direito
    private List<Receita> buscarTodasReceitas(){
        List<Receita> todasReceitas = new ArrayList<>();
        for(CadernoReceitas c : sistema.buscarTodosCadernosDoUsuarioAtual()){
            todasReceitas.addAll(sistema.listarReceitasDoCaderno(c.getIdCaderno()));
        }
        return todasReceitas;
    }

    @FXML
    private void handleCriarCaderno() throws IOException {
        //muda de tela
    }

    @FXML
    private void handleCriarReceita(){
        //muda de tela
    }

    @FXML
    private void handleMostrarPerfil(){
        //muda de tela
    }

    @FXML
    private void handlePesquisar(){
        if(choiceBoxPesquisa == null){
            alertPesquisa();
        }else{
            //TODO: alterar assinatura do método para receber nome de perfil como parâmetro
            switch (choiceBoxPesquisa.getValue()) {
                case "Caderno" -> sistema.buscarCaderno(textFieldPesquisa.getText());
                case "Receita" -> sistema.buscarReceita(textFieldPesquisa.getText());
                case "Usuário" -> sistema.buscarUsuario(textFieldPesquisa.getText());
            }
        }
        //app.alterarTela(TELA_RESULTADOS); muda para tela de resultados
        //TODO: pensar em uma maneira de passar a pesquisa para a tela de resultados
    }

    private void alertPesquisa(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText("Tipo de Pesquisa Não Informado");
        alert.showAndWait();
    }
}
