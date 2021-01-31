package com.cooksbooks;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.facilities.Telas;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class App extends Application {

  private static Scene cenaTelaCadastro, cenaTelaCriacaoCaderno,
      cenaTelaCriacaoReceita, cenaTelaCaderno, cenaTelaLogin, cenaTelaPrincipalUsuario;

  private static Stage estagio;
  private CooksBooksFachada fachada = CooksBooksFachada.getInstancia();
  private static App instance;

  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader telaLogin = new FXMLLoader().load(getClass().getResource(Telas.TELA_LOGIN.caminho()));
    Parent parentTelaLogin = telaLogin.load();
    cenaTelaLogin = new Scene(parentTelaLogin);

    estagio = stage;
    estagio.setTitle("Cook's Books");

    estagio.show();
  }


  public void alterarTela(Telas tela) {
    FXMLLoader novaTela = new FXMLLoader();
    
  }
}
