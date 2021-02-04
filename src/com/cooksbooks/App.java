package com.cooksbooks;

import com.cooksbooks.controllers.CooksBooksFachada;
import com.cooksbooks.facilities.Telas;
import com.cooksbooks.gui.controllers.ControladorTelaCadastro;
import com.cooksbooks.gui.controllers.ControladorTelaCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoRec;
import com.cooksbooks.gui.controllers.ControladorTelaLogin;
import com.cooksbooks.gui.controllers.ControladorTelaPrincipal;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class App extends Application {

  private static Stage estagio;
  private static App instancia;

  public static App getInstancia() {
    if (instancia == null) {
      instancia = new App();
    }
    return instancia;
  }


  @Override
  public void start(Stage stage) throws Exception {
    estagio = stage;
    FXMLLoader telaLoginLoader = new FXMLLoader(getClass().getResource(Telas.TELA_LOGIN.caminho()));
    Scene cenaTelaLogin = new Scene(telaLoginLoader.load());

    estagio.setScene(cenaTelaLogin);
    estagio.setTitle("Cook's Books");

    estagio.show();
  }

  public static void main(String[] args) {
    launch();
  }

  /**
   * Encaminha o usuario para uma nova tela sem precisar transferir informacoes
   *
   * @param tela tela ao qual o usuario sera migrado
   * @throws IOException caso broncas ocorram
   */
  public void alterarTela(Telas tela) throws IOException {
    FXMLLoader novaTelaLoader = new FXMLLoader(getClass().getResource(tela.caminho()));
    Scene novaCena = new Scene(novaTelaLoader.load());


    estagio.setScene(novaCena);
  }

  /**
   * Encaminha o usuario para uma nova tela transferindo as informacoes pertinentes
   * do controlador da tela anterior
   *
   * @param tela tela ao qual o usuario sera migrado
   * @param sender informacoes pertinentes do controlador da tela anterior a serem
   *               enviadas para o controlador da nova tela
   *
   * @throws IOException
   */
  public void alterarTela(Telas tela, DataSender sender) throws IOException {
    FXMLLoader novaTelaLoader = new FXMLLoader(getClass().getResource(tela.caminho()));
    Scene novaCena = new Scene(novaTelaLoader.load());

    Object controllerObj = novaTelaLoader.getController();
    DataReceiver receiver = (DataReceiver) controllerObj;

    if(sender.getInformation().keySet().containsAll(receiver.requiredKeys())) {
      receiver.setInformation(sender.getInformation());
    }

    estagio.setScene(novaCena);
  }
}
