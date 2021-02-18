package com.cooksbooks.gui;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.gui.controllers.*;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {


  private static Stage stagePrincipal;
  private static ScreenManager instancia;
  private Scene telaCadastro, telaCriacaoCaderno, telaCriacaoReceita, telaCaderno,
      telaEditarCaderno, telaEditarPerfil, telaLogin, telaEditarReceita,
      telaPerfil, telaPrincipalUsuario, telaResultadosPesquisa, telaInicialAdm, telaUsuarioBuscado, telaCadernoRelatorio,
      telaReceitaRelatorio, telaGerarRelatorio, telaReceita;

  private ControladorAdm controladorAdm;
  private ControladorTelaCadastro controladorTelaCadastro;
  private ControladorTelaCaderno controladorTelaCaderno;
  private ControladorTelaCriacaoCaderno controladorTelaCriacaoCaderno;
  private ControladorTelaCriacaoRec controladorTelaCriacaoRec;
  private ControladorTelaEditarCaderno controladorTelaEditarCaderno;
  private ControladorTelaEditarPerfil controladorTelaEditarPerfil;
  private ControladorTelaEditarReceita controladorTelaEditarReceita;
  private ControladorTelaLogin controladorTelaLogin;
  private ControladorTelaPerfil controladorTelaPerfil;
  private ControladorTelaPrincipal controladorTelaPrincipal;
  private ControladorTelaReceita controladorTelaReceita;
  private ControladorTelaUsuarioBuscado controladorTelaUsuarioBuscado;
  private ControladorCadernoRelatorio controladorCadernoRelatorio;
  private ControladorReceitaRelatorio controladorReceitaRelatorio;
  private ControladorTelaRelatorio controladorTelaRelatorio;
  private ControladorTelaResultado controladorTelaResultado;


  public static ScreenManager getInstancia() throws IOException {
    if (instancia == null) {
      instancia = new ScreenManager();
    }

    return instancia;
  }

  private ScreenManager() throws IOException {
    FXMLLoader loaderTelaCadastro = new FXMLLoader(getClass().getResource(Telas.TELA_CADASTRO.caminho()));
    telaCadastro = new Scene(loaderTelaCadastro.load());
    controladorTelaCadastro = loaderTelaCadastro.getController();

    FXMLLoader loaderTelaCriacaoCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_CRIACAO_CADERNO.caminho()));
    telaCriacaoCaderno = new Scene(loaderTelaCriacaoCaderno.load());
    controladorTelaCriacaoCaderno = loaderTelaCriacaoCaderno.getController();

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

    FXMLLoader loaderTelaCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_CADERNO.caminho()));
    telaCaderno = new Scene(loaderTelaCaderno.load());
    controladorTelaCaderno = loaderTelaCaderno.getController();

    FXMLLoader  loaderEditarCaderno = new FXMLLoader(getClass().getResource(Telas.TELA_EDITAR_CADERNO.caminho()));
    telaEditarCaderno = new Scene(loaderEditarCaderno.load());
    controladorTelaEditarCaderno = loaderEditarCaderno.getController();

    FXMLLoader loaderEditarPerfil = new FXMLLoader(getClass().getResource(Telas.TELA_EDITAR_PERFIL.caminho()));
    telaEditarPerfil = new Scene(loaderEditarPerfil.load());
    controladorTelaEditarPerfil = loaderEditarPerfil.getController();

    FXMLLoader loaderEditarReceita = new FXMLLoader(getClass().getResource(Telas.TELA_EDITAR_RECEITA.caminho()));
    telaEditarReceita = new Scene(loaderEditarReceita.load());
    controladorTelaEditarReceita = loaderEditarReceita.getController();

    FXMLLoader loaderInicialAdm = new FXMLLoader(getClass().getResource(Telas.TELA_INICIAL_ADM.caminho()));
    telaInicialAdm = new Scene(loaderInicialAdm.load());
    controladorAdm = loaderInicialAdm.getController();

    FXMLLoader loaderUsuarioBuscado = new FXMLLoader(getClass().getResource(Telas.TELA_USUARIO_BUSCADO.caminho()));
    telaUsuarioBuscado = new Scene(loaderUsuarioBuscado.load());
    controladorTelaUsuarioBuscado = loaderUsuarioBuscado.getController();

    FXMLLoader loaderCadernoRelatorio = new FXMLLoader(getClass().getResource(Telas.TELA_CADERNO_RELATORIO.caminho()));
    telaCadernoRelatorio = new Scene(loaderCadernoRelatorio.load());
    controladorCadernoRelatorio = loaderCadernoRelatorio.getController();

    FXMLLoader loaderReceitaRelatorio = new FXMLLoader(getClass().getResource(Telas.TELA_RECEITA_RELATORIO.caminho()));
    telaReceitaRelatorio = new  Scene(loaderReceitaRelatorio.load());
    controladorReceitaRelatorio = loaderReceitaRelatorio.getController();

    FXMLLoader loaderGerarRelatorio = new FXMLLoader(getClass().getResource(Telas.TELA_GERAR_RELATORIO.caminho()));
    telaGerarRelatorio = new Scene(loaderGerarRelatorio.load());
    controladorTelaRelatorio = loaderGerarRelatorio.getController();

    FXMLLoader loaderExibirReceita = new FXMLLoader(getClass().getResource(Telas.TELA_RECEITA.caminho()));
    telaReceita = new Scene(loaderExibirReceita.load());
    controladorTelaReceita = loaderExibirReceita.getController();
  }

  public void setStagePrincipal(Stage stage) {
    stagePrincipal = stage;
  }

  // Login
  public void abrirLogin() {
    stagePrincipal.setScene(telaLogin);
    controladorTelaLogin.inicializar();
    stagePrincipal.show();
  }

  // Cadastro
  public void abrirCadastro(String login, String senha) {

    controladorTelaCadastro.setLoginSenha(login, senha);
    controladorTelaCadastro.inicializar();

    stagePrincipal.setScene(telaCadastro);
    stagePrincipal.show();
  }

  // TelaPrincipal
  public void abrirTelaPrincipal() {

    controladorTelaPrincipal.inicializar();

    stagePrincipal.setScene(telaPrincipalUsuario);
    stagePrincipal.show();
  }

  // TelaCaderno
  public void abrirTelaCaderno(CadernoReceitas caderno) {

    controladorTelaCaderno.setCaderno(caderno);

    stagePrincipal.setScene(telaCaderno);
    stagePrincipal.show();
  }

  // TelaCaderno
  public void abrirTelaEditarCaderno(CadernoReceitas caderno) {

    controladorTelaEditarCaderno.setCaderno(caderno);

    stagePrincipal.setScene(telaEditarCaderno);
    stagePrincipal.show();
  }

  // TelaCaderno
  public void abrirTelaReceita(Receita receita) {
    controladorTelaReceita.setReceita(receita);

    stagePrincipal.setScene(telaReceita);
    stagePrincipal.show();
  }

  // TelaCriacaoCaderno
  public void abrirTelaCriacaoCaderno() {

    stagePrincipal.setScene(telaCriacaoCaderno);
    stagePrincipal.show();
  }

  // TelaCriacaoReceita
  public void abrirTelaCriacaoReceita() {

    stagePrincipal.setScene(telaCriacaoReceita);
    stagePrincipal.show();
  }

  // TelaPerfil
  public void abrirTelaPerfil() {

    stagePrincipal.setScene(telaPerfil);
    stagePrincipal.show();
  }

  // TelaPerfil
  public void abrirTelaEditarPerfil() {

    stagePrincipal.setScene(telaEditarPerfil);
    stagePrincipal.show();
  }


  public void abrirTelaResultadosPesquisa () {
    //TODO somente abre a tela quando selecionado a opcao de busca + nome pesquisado

    stagePrincipal.setScene(telaResultadosPesquisa);
    stagePrincipal.show();
  }

}
