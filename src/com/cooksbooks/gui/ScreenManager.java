package com.cooksbooks.gui;

import com.cooksbooks.gui.controllers.ControladorAdm;
import com.cooksbooks.gui.controllers.ControladorTelaCadastro;
import com.cooksbooks.gui.controllers.ControladorTelaCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoRec;
import com.cooksbooks.gui.controllers.ControladorTelaEditarCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaEditarPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaEditarReceita;
import com.cooksbooks.gui.controllers.ControladorTelaLogin;
import com.cooksbooks.gui.controllers.ControladorTelaPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaPrincipal;
import com.cooksbooks.gui.controllers.ControladorTelaReceita;
import com.cooksbooks.gui.controllers.ControladorTelaUsuarioPesquisado;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {


  private static Stage stagePrincipal;
  private static ScreenManager instancia;
  private Scene telaCadastro, telaCriacaoCaderno, telaCriacaoReceita, telaCaderno,
      telaEditarCaderno, telaEditarPerfil, telaLogin,
      telaPerfil, telaPrincipalUsuario, telaResultadosPesquisa;

  private ControladorAdm controladorAdm;
  private ControladorTelaCadastro controladorTelaCadastro;
  private ControladorTelaCaderno controladorTelaCaderno;
  private ControladorTelaCriacaoRec controladorTelaCriacaoRec;
  private ControladorTelaEditarCaderno controladorTelaEditarCaderno;
  private ControladorTelaEditarPerfil controladorTelaEditarPerfil;
  private ControladorTelaEditarReceita controladorTelaEditarReceita;
  private ControladorTelaLogin controladorTelaLogin;
  private ControladorTelaPerfil controladorTelaPerfil;
  private ControladorTelaPrincipal controladorTelaPrincipal;
  private ControladorTelaReceita controladorTelaReceita;
  private ControladorTelaUsuarioPesquisado controladorTelaUsuarioPesquisado;


  public ScreenManager getInstancia() throws IOException {
    if (instancia == null) {
      instancia = new ScreenManager();
    }

    return instancia;
  }

  private ScreenManager() throws IOException {
    FXMLLoader loaderTelaCadastro = new FXMLLoader(getClass().getResource(Telas.TELA_CADASTRO.caminho()));
    telaCadastro = new Scene(loaderTelaCadastro.load());
    controladorTelaCadastro = loaderTelaCadastro.getController();

    FXMLLoader loaderTelaCriacaoCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_CADERNO.caminho()));
    telaCriacaoCaderno = new Scene(loaderTelaCriacaoCaderno.load());
    controladorTelaCadastro = loaderTelaCriacaoCaderno.getController();

    FXMLLoader loaderTelaCriacaoReceita = new FXMLLoader(getClass().getResource(Telas.TELA_CRIACAO_RECEITA.caminho()));
    telaCriacaoReceita = new Scene(loaderTelaCriacaoReceita.load());
    controladorTelaCriacaoRec = loaderTelaCriacaoReceita.getController();
    
    FXMLLoader loaderTelaLogin = new FXMLLoader(getClass().getResource(Telas.TELA_LOGIN.caminho()));
    telaLogin = new Scene(loaderTelaLogin.load());
    controladorTelaLogin = loaderTelaLogin.getController();

    FXMLLoader loaderTelaPerfil = new FXMLLoader(getClass().getResource(Telas.TELA_PERFIL.caminho()));
    telaPerfil = new Scene(loaderTelaPerfil.load());
    controladorTelaPerfil = loaderTelaPerfil.getController();

    FXMLLoader loaderTelaPrincipal = new FXMLLoader(getClass().getResource(Telas.TELA_PRINCIPAL_USUARIO.caminho()));
    telaPrincipalUsuario = new Scene(loaderTelaPrincipal.load());
    controladorTelaPrincipal = loaderTelaPrincipal.getController();

    FXMLLoader loaderTelaDoCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_CADERNO.caminho()));
    telaCaderno = new Scene(loaderTelaDoCaderno.load());
    controladorTelaCaderno = loaderTelaDoCaderno.getController();

    FXMLLoader  loaderEditarCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_CRIACAO_CADERNO.caminho()));
    telaEditarCaderno = new Scene(loaderTelaCriacaoReceita.load());
    controladorTelaEditarCaderno = loaderEditarCaderno.getController();

    FXMLLoader loaderEditarPerfil = new FXMLLoader(getClass().getResource(Telas.TELA_EDITAR_PERFIL.caminho()));
    telaEditarPerfil = new Scene(loaderEditarPerfil.load());
    controladorTelaEditarPerfil = loaderEditarPerfil.getController();
  }

  public void setStagePrincipal(Stage stage) {
    stagePrincipal = stage;
  }

}
