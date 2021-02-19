package com.cooksbooks.gui;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.gui.controllers.*;

import java.io.IOException;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.gui.controllers.ControladorAdm;
import com.cooksbooks.gui.controllers.ControladorCadernoRelatorio;
import com.cooksbooks.gui.controllers.ControladorReceitaRelatorio;
import com.cooksbooks.gui.controllers.ControladorTelaCadastro;
import com.cooksbooks.gui.controllers.ControladorTelaCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoRec;
import com.cooksbooks.gui.controllers.ControladorTelaEditarCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaEditarPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaEditarReceita;
import com.cooksbooks.gui.controllers.ControladorTelaLogin;
import com.cooksbooks.gui.controllers.ControladorTelaPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaPrincipal;
import com.cooksbooks.gui.controllers.ControladorTelaReceita;
import com.cooksbooks.gui.controllers.ControladorTelaRelatorio;
import com.cooksbooks.gui.controllers.ControladorTelaUsuarioBuscado;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScreenManager {

  private static ScreenManager instancia;

  private Stage stagePrincipal;

  private Scene mainScene;

  private Tab tabPrincipal;
  private Tab tabAdm;

  private Parent telaCadastro;
  private Parent telaCriacaoCaderno;
  private Parent telaCriacaoReceita;
  private Parent telaCaderno;
  private Parent telaEditarCaderno;
  private Parent telaEditarPerfil;
  private Parent telaLogin;
  private Parent telaEditarReceita;
  private Parent telaPerfil;
  private Parent telaPrincipalUsuario;
  private Parent telaResultadosPesquisa;
  private Parent telaInicialAdm;
  private Parent telaUsuarioBuscado;
  private Parent telaCadernoRelatorio;
  private Parent telaReceitaRelatorio;
  private Parent telaGerarRelatorio;
  private Parent telaReceita;
  private Parent telaCriacaoIngrediente;

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
  private ControladorTelaResultado controladorTelaResultados;
  private ControladorTelaCriacaoIngr controladorTelaCriacaoIngr;

  private ScreenManager() {
    try {
      FXMLLoader loaderTelaCadastro = new FXMLLoader(
          getClass().getResource(Telas.TELA_CADASTRO.caminho()));
      telaCadastro = loaderTelaCadastro.load();
      controladorTelaCadastro = loaderTelaCadastro.getController();
      controladorTelaCadastro.setScreenManager(this);

      FXMLLoader loaderTelaCriacaoCaderno = new FXMLLoader(
          getClass().getResource(Telas.TELA_CRIACAO_CADERNO.caminho()));
      telaCriacaoCaderno = loaderTelaCriacaoCaderno.load();
      controladorTelaCriacaoCaderno = loaderTelaCriacaoCaderno.getController();
      //controladorTelaCriacaoCaderno.setScreenManager();

      FXMLLoader loaderTelaCriacaoReceita = new FXMLLoader(
          getClass().getResource(Telas.TELA_CRIACAO_RECEITA.caminho()));
      telaCriacaoReceita = loaderTelaCriacaoReceita.load();
      controladorTelaCriacaoRec = loaderTelaCriacaoReceita.getController();
      //controladorTelaCriacaoRec.setScreenManager();

      FXMLLoader loaderTelaLogin = new FXMLLoader(
          getClass().getResource(Telas.TELA_LOGIN.caminho()));
      telaLogin = loaderTelaLogin.load();
      controladorTelaLogin = loaderTelaLogin.getController();
      controladorTelaLogin.setScreenManager(this);

      FXMLLoader loaderTelaPerfil = new FXMLLoader(
          getClass().getResource(Telas.TELA_PERFIL.caminho()));
      telaPerfil = loaderTelaPerfil.load();
      controladorTelaPerfil = loaderTelaPerfil.getController();
      controladorTelaPerfil.setScreenManager(this);

      FXMLLoader loaderTelaPrincipal = new FXMLLoader(
          getClass().getResource(Telas.TELA_PRINCIPAL_USUARIO.caminho()));
      telaPrincipalUsuario = loaderTelaPrincipal.load();
      controladorTelaPrincipal = loaderTelaPrincipal.getController();
      controladorTelaPrincipal.setScreenManager(this);

      FXMLLoader loaderTelaCaderno = new FXMLLoader(
          getClass().getResource(Telas.TELA_CADERNO.caminho()));
      telaCaderno = loaderTelaCaderno.load();
      controladorTelaCaderno = loaderTelaCaderno.getController();
      controladorTelaCaderno.setScreenManager(this);

      FXMLLoader loaderEditarCaderno = new FXMLLoader(
          getClass().getResource(Telas.TELA_EDITAR_CADERNO.caminho()));
      telaEditarCaderno = loaderEditarCaderno.load();
      controladorTelaEditarCaderno = loaderEditarCaderno.getController();
      controladorTelaEditarCaderno.setScreenManager(this);

      FXMLLoader loaderEditarPerfil = new FXMLLoader(
          getClass().getResource(Telas.TELA_EDITAR_PERFIL.caminho()));
      telaEditarPerfil = loaderEditarPerfil.load();
      controladorTelaEditarPerfil = loaderEditarPerfil.getController();
      //controladorTelaEditarPerfil.setScreenManager(this);

      FXMLLoader loaderEditarReceita = new FXMLLoader(
          getClass().getResource(Telas.TELA_EDITAR_RECEITA.caminho()));
      telaEditarReceita = loaderEditarReceita.load();
      controladorTelaEditarReceita = loaderEditarReceita.getController();
      //controladorTelaEditarCaderno.setScreenManager(this);

      FXMLLoader loaderInicialAdm = new FXMLLoader(
          getClass().getResource(Telas.TELA_INICIAL_ADM.caminho()));
      telaInicialAdm = loaderInicialAdm.load();
      controladorAdm = loaderInicialAdm.getController();
      //controladorAdm.setScreenManager(this);

      FXMLLoader loaderUsuarioBuscado = new FXMLLoader(
          getClass().getResource(Telas.TELA_USUARIO_BUSCADO.caminho()));
      telaUsuarioBuscado = loaderUsuarioBuscado.load();
      controladorTelaUsuarioBuscado = loaderUsuarioBuscado.getController();
      //controladorTelaUsuarioBuscado.setScreenManager(this);

      FXMLLoader loaderCadernoRelatorio = new FXMLLoader(
          getClass().getResource(Telas.TELA_CADERNO_RELATORIO.caminho()));
      telaCadernoRelatorio = loaderCadernoRelatorio.load();
      controladorCadernoRelatorio = loaderCadernoRelatorio.getController();
      //controladorCadernoRelatorio.setScreenManager(this);

      FXMLLoader loaderReceitaRelatorio = new FXMLLoader(
          getClass().getResource(Telas.TELA_RECEITA_RELATORIO.caminho()));
      telaReceitaRelatorio = loaderReceitaRelatorio.load();
      controladorReceitaRelatorio = loaderReceitaRelatorio.getController();
      //controladorReceitaRelatorio.setScreenManager(this);

      FXMLLoader loaderGerarRelatorio = new FXMLLoader(
          getClass().getResource(Telas.TELA_GERAR_RELATORIO.caminho()));
      telaGerarRelatorio = loaderGerarRelatorio.load();
      controladorTelaRelatorio = loaderGerarRelatorio.getController();
      //controladorTelaRelatorio.setScreenManager(this);

      FXMLLoader loaderExibirReceita = new FXMLLoader(
          getClass().getResource(Telas.TELA_RECEITA.caminho()));
      telaReceita = loaderExibirReceita.load();
      controladorTelaReceita = loaderExibirReceita.getController();
      controladorTelaReceita.setScreenManager(this);

      FXMLLoader loaderExibirResultados = new FXMLLoader(
              getClass().getResource(Telas.TELA_RESULTADOS_PESQUISA.caminho()));
      telaResultadosPesquisa = loaderExibirResultados.load();
      controladorTelaResultados = loaderExibirResultados.getController();
      //controladorTelaResultados.setScreenManager(this);

      FXMLLoader loaderCriacaoIng = new FXMLLoader(
          getClass().getResource(Telas.TELA_CRIACAO_INGREDIENTE.caminho()));
      telaCriacaoIngrediente = loaderCriacaoIng.load();
      controladorTelaCriacaoIngr = loaderCriacaoIng.getController();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public static ScreenManager getInstancia() {
    if (ScreenManager.instancia == null) {
      ScreenManager.instancia = new ScreenManager();
    }

    return ScreenManager.instancia;
  }

  public void setStagePrincipal(Stage stage) {
    stagePrincipal = stage;
  }

  public void iniciarTelas() {
    mainScene = new Scene(telaLogin, 600, 420);
    stagePrincipal.setScene(mainScene);
    stagePrincipal.setTitle("Cook's Books");
    stagePrincipal.setResizable(false);
    stagePrincipal.show();
  }

  // Login
  public void abrirLogin() {
    mainScene.setRoot(telaLogin);
  }

  // Cadastro
  public void abrirCadastro(String login, String senha) {
    controladorTelaCadastro.setLoginSenha(login, senha);
    controladorTelaCadastro.inicializar();
    mainScene.setRoot(telaCadastro);
  }

  // TelaUsuario
  public void abrirTelaUsuarioBuscado(Usuario usuario){

  }
  // TelaPrincipal
  public void abrirTelaPrincipal() {
    controladorTelaPrincipal.inicializar();
    if (mainScene.getRoot() instanceof TabPane) {
      ObservableList<Tab> tabs = ((TabPane) mainScene.getRoot()).getTabs();
      tabs.get(0).setContent(telaPrincipalUsuario);
    } else {
      TabPane tabPane = new TabPane();
      tabPane.getTabs().add(new Tab("Principal", telaPrincipalUsuario));
      tabPane.getTabs().get(0).setClosable(false);
      mainScene.setRoot(tabPane);
    }
  }

  public void adicionarTabAdm() {
    TabPane tabPane = (TabPane) mainScene.getRoot();
    if (tabPane.getTabs().size() < 2) {
      tabPane.getTabs().add(new Tab("Administrador", telaInicialAdm));
      tabPane.getTabs().get(1).setClosable(false);
    }
  }

  // TelaCaderno
  public void abrirTelaCaderno(CadernoReceitas caderno) {
    controladorTelaCaderno.setCaderno(caderno);
    controladorTelaCaderno.inicializar();
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaCaderno);
  }

  // TelaEditarCaderno
  public void abrirTelaEditarCaderno(CadernoReceitas caderno) {
    controladorTelaEditarCaderno.setCaderno(caderno);
    controladorTelaEditarCaderno.incializar();
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaEditarCaderno);
  }

  // TelaReceita
  public void abrirTelaReceita(Receita receita) {
    Stage modalStage = new Stage();
    modalStage.initModality(Modality.APPLICATION_MODAL);
    modalStage.initOwner(stagePrincipal);
    modalStage.setScene(new Scene(telaReceita));
    controladorTelaReceita.setReceita(receita);
    modalStage.setTitle("Visualização Receita");
    modalStage.showAndWait();
  }

  // TelaEditarReceita
  public void abrirTelaEditarReceita(Receita receita) {
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaEditarReceita);
    controladorTelaEditarReceita.setReceita(receita);
  }

  // TelaCriacaoCaderno
  public void abrirTelaCriacaoCaderno() {
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaCriacaoCaderno);
  }

  // TelaCriacaoReceita
  public void abrirTelaCriacaoReceita() {
    modalStage(telaCriacaoReceita, stagePrincipal, "Criação Receita");
  }

  // TelaPerfil
  public void abrirTelaPerfil(Usuario usuarioDoPerfil) {
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaPerfil);
    controladorTelaPerfil.setUsuarioDoPefil(usuarioDoPerfil);
  }

  // TelaPerfil
  public void abrirTelaEditarPerfil() {
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaEditarPerfil);
  }


  public void abrirTelaResultadosPesquisa() {
    ((TabPane) mainScene.getRoot()).getTabs().get(0).setContent(telaResultadosPesquisa);
    //TODO somente abre a tela quando selecionado a opcao de busca + nome pesquisado
  }

  public void abrirTelaRelatorio() {
    modalStage(telaGerarRelatorio, stagePrincipal, "Gerar Relatório");
  }

  public void abrirTelaRelatorioCaderno(String loginUsuario) {
    controladorCadernoRelatorio.inicializar(loginUsuario);
    modalStage(telaCadernoRelatorio, stagePrincipal, "Cadernos");
  }

  public void abrirTelaRelatorioReceita(String loginUsuario) {
    controladorReceitaRelatorio.inicializar(loginUsuario);
    modalStage(telaReceitaRelatorio, stagePrincipal, "Receitas");
  }

  public void abrirTelaCriacaoIngrediente(ObservableList<Ingrediente> ingredientes) {
    controladorTelaCriacaoIngr.setObIngredientes(ingredientes);
    modalStage(telaCriacaoIngrediente, (Stage) telaCriacaoReceita.getScene().getWindow(), "Criação Ingredientes");
  }


  private void modalStage(Parent root, Stage owner, String title) {
    Scene scene;
    if (root.getScene() != null) scene = root.getScene();
    else scene = new Scene(root);

    Stage modalStage = new Stage();
    modalStage.setTitle((title != null) ? title : "Janela");
    modalStage.initModality(Modality.APPLICATION_MODAL);
    modalStage.initOwner(owner);
    modalStage.setResizable(false);
    modalStage.setScene(scene);
    modalStage.showAndWait();
  }
}
