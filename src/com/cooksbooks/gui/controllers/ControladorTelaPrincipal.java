package com.cooksbooks.gui.controllers;

import com.cooksbooks.App;
import com.cooksbooks.ControladorGUI;
import com.cooksbooks.DataSender;
import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.database.RepositorioUsuariosList;
import com.cooksbooks.database.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.facilities.Telas;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControladorTelaPrincipal implements DataSender, ControladorGUI {

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();
    private App app;

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
    public void initialize(){
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
        this.app.alterarTela(Telas.TELA_CRIACAO_CADERNO, this);
    }

    @FXML
    private void handleCriarReceita(){
        //TODO:app.alterarTela(TELA_CRIACAO_RECEITA); muda para tela de criacao de receita
    }

    @FXML
    private void handleMostrarPerfil(){
        //TODO:app.alterarTela(TELA_PERFIL); muda para tela do perfil
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

    public void setApp(App app) {
        this.app = app;
    }

    public Object[] getInformation(){
        Object [] information = new Object[2];
        information[0] = this.choiceBoxPesquisa.getValue();
        information[1] = this.
        return information;
    }
}
