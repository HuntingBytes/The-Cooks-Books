package com.cooksbooks.gui.controllers;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.controllers.ICooksBooks;
import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class ControladorTelaResultado {

    private ScreenManager screenManager;

    private final ICooksBooks sistema = CooksBooksFachada.getInstancia();

    @FXML
    private ListView<?> listViewResultados;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoSelecionarResult;

    @FXML
    void handleSelecionarResult() {
        Object o = listViewResultados.getSelectionModel().getSelectedItem();
        if(o != null){
            if(o instanceof Usuario){

            }else if(o instanceof Receita){
                screenManager.abrirTelaReceita((Receita) o);
            }else{
                screenManager.abrirTelaCaderno((CadernoReceitas) o);
            }
        }else{
            alertSelecionarItem();
        }
    }

    private void alertSelecionarItem() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText("Nada foi Selecionado!");
        //alert.setContentText(String.format("Favor selecionar %s para acessar", item));
        alert.showAndWait();
    }

    //TODO: fazer isso direito e colocar no lugar certo
    private List<Receita> buscarTodasReceitas(){
        List<Receita> todasReceitas = new ArrayList<>();
        for(CadernoReceitas c : sistema.buscarTodosCadernosDoUsuarioAtual()){
            todasReceitas.addAll(sistema.listarReceitasDoCaderno(c.getIdCaderno()));
        }
        return todasReceitas;
    }
}
