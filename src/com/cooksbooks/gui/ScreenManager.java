package com.cooksbooks.gui;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.gui.controllers.ControladorAdm;
import com.cooksbooks.gui.controllers.ControladorCadernoRelatorio;
import com.cooksbooks.gui.controllers.ControladorReceitaRelatorio;
import com.cooksbooks.gui.controllers.ControladorTelaCadastro;
import com.cooksbooks.gui.controllers.ControladorTelaCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoIngr;
import com.cooksbooks.gui.controllers.ControladorTelaCriacaoRec;
import com.cooksbooks.gui.controllers.ControladorTelaEditarCaderno;
import com.cooksbooks.gui.controllers.ControladorTelaEditarPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaEditarReceita;
import com.cooksbooks.gui.controllers.ControladorTelaEnviarFeedback;
import com.cooksbooks.gui.controllers.ControladorTelaLogin;
import com.cooksbooks.gui.controllers.ControladorTelaPerfil;
import com.cooksbooks.gui.controllers.ControladorTelaPrincipal;
import com.cooksbooks.gui.controllers.ControladorTelaReceita;
import com.cooksbooks.gui.controllers.ControladorTelaRelatorio;
import com.cooksbooks.gui.controllers.ControladorTelaResultado;
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
  private Scene scenePrincipal;

  private TabPane tabPane;
  private Tab tabPrincipal;
  private Tab tabAdmin;

  private Parent telaCadastro;
  private Parent telaCriacaoCaderno;
  private Parent telaCriacaoReceita;
  private Parent telaCriacaoIngrediente;
  private Parent telaCaderno;
  private Parent telaCadernoModal;
  private Parent telaEditarCaderno;
  private Parent telaEditarPerfil;
  private Parent telaLogin;
  private Parent telaEditarReceita;
  private Parent telaPerfil;
  private Parent telaPrincipalUsuario;
  private Parent telaEnviarFeedback;
  private Parent telaResultadosPesquisa;
  private Parent telaInicialAdm;
  private Parent telaUsuarioBuscado;
  private Parent telaCadernoRelatorio;
  private Parent telaReceitaRelatorio;
  private Parent telaGerarRelatorio;
  private Parent telaReceita;
  private Parent telaReceitaModal;

  private ControladorAdm controladorAdm;
  private ControladorTelaCadastro controladorTelaCadastro;
  private ControladorTelaCaderno controladorTelaCaderno;
  private ControladorTelaCaderno controladorTelaCadernoModal;
  private ControladorTelaCriacaoCaderno controladorTelaCriacaoCaderno;
  private ControladorTelaCriacaoRec controladorTelaCriacaoRec;
  private ControladorTelaCriacaoIngr controladorTelaCriacaoIngr;
  private ControladorTelaEditarCaderno controladorTelaEditarCaderno;
  private ControladorTelaEditarPerfil controladorTelaEditarPerfil;
  private ControladorTelaEditarReceita controladorTelaEditarReceita;
  private ControladorTelaLogin controladorTelaLogin;
  private ControladorTelaPerfil controladorTelaPerfil;
  private ControladorTelaPrincipal controladorTelaPrincipal;
  private ControladorTelaEnviarFeedback controladorTelaEnviarFeedback;
  private ControladorTelaReceita controladorTelaReceita;
  private ControladorTelaReceita controladorTelaReceitaModal;
  private ControladorTelaUsuarioBuscado controladorTelaUsuarioBuscado;
  private ControladorCadernoRelatorio controladorCadernoRelatorio;
  private ControladorReceitaRelatorio controladorReceitaRelatorio;
  private ControladorTelaRelatorio controladorTelaRelatorio;
  private ControladorTelaResultado controladorTelaResultados;

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

      FXMLLoader loaderTelaEnviarFeedback = new FXMLLoader(
          getClass().getResource(Telas.TELA_ENVIAR_FEEDBACK.caminho()));
      telaEnviarFeedback = loaderTelaEnviarFeedback.load();
      controladorTelaEnviarFeedback = loaderTelaEnviarFeedback.getController();

      FXMLLoader loaderTelaCaderno = new FXMLLoader(
          getClass().getResource(Telas.TELA_CADERNO.caminho()));
      telaCaderno = loaderTelaCaderno.load();
      controladorTelaCaderno = loaderTelaCaderno.getController();
      controladorTelaCaderno.setScreenManager(this);

      FXMLLoader loaderTelaCadernoModal = new FXMLLoader(
          getClass().getResource(Telas.TELA_CADERNO.caminho()));
      telaCadernoModal = loaderTelaCadernoModal.load();
      controladorTelaCadernoModal = loaderTelaCadernoModal.getController();
      controladorTelaCadernoModal.setScreenManager(this);
      controladorTelaCadernoModal.setTelaComoModal();

      FXMLLoader loaderEditarCaderno = new FXMLLoader(
          getClass().getResource(Telas.TELA_EDITAR_CADERNO.caminho()));
      telaEditarCaderno = loaderEditarCaderno.load();
      controladorTelaEditarCaderno = loaderEditarCaderno.getController();
      controladorTelaEditarCaderno.setScreenManager(this);

      FXMLLoader loaderEditarPerfil = new FXMLLoader(
          getClass().getResource(Telas.TELA_EDITAR_PERFIL.caminho()));
      telaEditarPerfil = loaderEditarPerfil.load();
      controladorTelaEditarPerfil = loaderEditarPerfil.getController();
      controladorTelaEditarPerfil.setScreenManager(this);

      FXMLLoader loaderEditarReceita = new FXMLLoader(
          getClass().getResource(Telas.TELA_EDITAR_RECEITA.caminho()));
      telaEditarReceita = loaderEditarReceita.load();
      controladorTelaEditarReceita = loaderEditarReceita.getController();
      //controladorTelaEditarCaderno.setScreenManager(this);

      FXMLLoader loaderCriacaoIng = new FXMLLoader(
          getClass().getResource(Telas.TELA_CRIACAO_INGREDIENTE.caminho()));
      telaCriacaoIngrediente = loaderCriacaoIng.load();
      controladorTelaCriacaoIngr = loaderCriacaoIng.getController();

      FXMLLoader loaderInicialAdm = new FXMLLoader(
          getClass().getResource(Telas.TELA_INICIAL_ADM.caminho()));
      telaInicialAdm = loaderInicialAdm.load();
      controladorAdm = loaderInicialAdm.getController();
      //controladorAdm.setScreenManager(this);

      FXMLLoader loaderUsuarioBuscado = new FXMLLoader(
          getClass().getResource(Telas.TELA_USUARIO_BUSCADO.caminho()));
      telaUsuarioBuscado = loaderUsuarioBuscado.load();
      controladorTelaUsuarioBuscado = loaderUsuarioBuscado.getController();
      controladorTelaUsuarioBuscado.setScreenManager(this);

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

      FXMLLoader loaderExibirReceitaModal = new FXMLLoader(
          getClass().getResource(Telas.TELA_RECEITA.caminho()));
      telaReceitaModal = loaderExibirReceitaModal.load();
      controladorTelaReceitaModal = loaderExibirReceitaModal.getController();
      controladorTelaReceitaModal.setScreenManager(this);
      controladorTelaReceitaModal.setTelaComoModal();

      FXMLLoader loaderExibirResultados = new FXMLLoader(
          getClass().getResource(Telas.TELA_RESULTADOS_PESQUISA.caminho()));
      telaResultadosPesquisa = loaderExibirResultados.load();
      controladorTelaResultados = loaderExibirResultados.getController();
      controladorTelaResultados.setScreenManager(this);

      tabPrincipal = new Tab();
      tabPrincipal.setClosable(false);
      tabPrincipal.setText("Principal");

      tabAdmin = new Tab();
      tabAdmin.setClosable(false);
      tabAdmin.setText("Administrador");

      tabPane = new TabPane();
      tabPane.getTabs().add(tabPrincipal);
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
    stagePrincipal.setTitle("Cook's Books");
    stagePrincipal.setResizable(false);
    scenePrincipal = new Scene(telaLogin, 600, 420);
    stagePrincipal.setScene(scenePrincipal);
    stagePrincipal.show();
  }

  // Login
  public void abrirLogin() {
    scenePrincipal.setRoot(telaLogin);
  }

  // Cadastro
  public void abrirCadastro(String login, String senha) {
    controladorTelaCadastro.setLoginSenha(login, senha);
    scenePrincipal.setRoot(telaCadastro);
  }

  // TelaPrincipal
  public void abrirTelaPrincipal() {
    controladorTelaPrincipal.inicializar();
    tabPrincipal.setContent(telaPrincipalUsuario);
    scenePrincipal.setRoot(tabPane);
  }

  public void abrirTelaAdmin() {
    tabAdmin.setContent(telaInicialAdm);
    if (tabAdmin.getTabPane() == null) {
      tabPane.getTabs().add(tabAdmin);
    }
    scenePrincipal.setRoot(tabPane);
  }

  public void abrirTelaEnviarRelatorio() {
    modalStage(telaEnviarFeedback, stagePrincipal, "Enviar Feedback").showAndWait();
  }

  // TelaCaderno
  public void abrirTelaCaderno(CadernoReceitas caderno) {
    controladorTelaCaderno.setCaderno(caderno);
    controladorTelaCaderno.inicializar();
    tabPrincipal.setContent(telaCaderno);
  }

  public void abrirTelaCadernoModal(CadernoReceitas caderno) {
    controladorTelaCadernoModal.setCaderno(caderno);
    controladorTelaCadernoModal.inicializar();
    controladorTelaCadernoModal.setTelaComoModal();
    modalStage(telaCadernoModal, stagePrincipal, "Caderno").showAndWait();
  }

  public void abrirTelaCadernoModal(CadernoReceitas caderno, Stage owner) {
    controladorTelaCadernoModal.setCaderno(caderno);
    controladorTelaCadernoModal.inicializar();
    controladorTelaCadernoModal.setTelaComoModal();
    modalStage(telaCadernoModal, owner, "Caderno").showAndWait();
  }

  // TelaEditarCaderno
  public void abrirTelaEditarCaderno(CadernoReceitas caderno) {
    controladorTelaEditarCaderno.setCaderno(caderno);
    controladorTelaEditarCaderno.inicializar();
    tabPrincipal.setContent(telaEditarCaderno);
  }

  // TelaReceita
  public void abrirTelaReceita(Receita receita) {
    controladorTelaReceita.setReceita(receita);
    controladorTelaReceita.inicializar();
    tabPrincipal.setContent(telaReceita);
  }

  public void abrirTelaReceitaModal(Receita receita) {
    controladorTelaReceitaModal.setReceita(receita);
    controladorTelaReceitaModal.inicializar();
    controladorTelaReceitaModal.setTelaComoModal();
    modalStage(telaReceitaModal, stagePrincipal, "Receita").showAndWait();
  }

  public void abrirTelaReceitaModal(Receita receita, Stage owner) {
    controladorTelaReceitaModal.setReceita(receita);
    controladorTelaReceitaModal.inicializar();
    controladorTelaReceitaModal.setTelaComoModal();
    modalStage(telaReceitaModal, owner, "Receita").showAndWait();
  }

  // TelaEditarReceita
  public void abrirTelaEditarReceita(Receita receita) {
    controladorTelaEditarReceita.setReceita(receita);
    tabPrincipal.setContent(telaEditarReceita);
  }

  public void abrirTelaCriacaoIngrediente(ObservableList<Ingrediente> ingredientes) {
    controladorTelaCriacaoIngr.setObIngredientes(ingredientes);
    modalStage(telaCriacaoIngrediente, (Stage) telaCriacaoReceita.getScene().getWindow(),
        "Criação Ingredientes").showAndWait();
  }

  // TelaCriacaoCaderno
  public void abrirTelaCriacaoCaderno() {
    tabPrincipal.setContent(telaCriacaoCaderno);
  }

  // TelaCriacaoReceita
  public void abrirTelaCriacaoReceita(String idCaderno) {
    controladorTelaCriacaoRec.setIdCadernoDono(idCaderno);
    modalStage(telaCriacaoReceita, stagePrincipal, "Criação Receita").showAndWait();
  }

  // TelaPerfil
  public void abrirTelaPerfil(Usuario usuarioDoPerfil) {
    controladorTelaPerfil.setUsuarioDoPefil(usuarioDoPerfil);
    controladorTelaPerfil.inicializar();
    tabPrincipal.setContent(telaPerfil);
  }

  // TelaPerfil
  public void abrirTelaEditarPerfil(Usuario usuario) {
    controladorTelaEditarPerfil.setUsuarioDoPerfil(usuario);
    controladorTelaEditarPerfil.inicializar();
    tabPrincipal.setContent(telaEditarPerfil);
  }

  public void abrirTelaResultadosPesquisa(String pesquisa, TiposPesquisas tipoPesquisa) {
    controladorTelaResultados.setPesquisa(pesquisa, tipoPesquisa);
    controladorTelaResultados.inicializar();
    tabPrincipal.setContent(telaResultadosPesquisa);
  }

  public void abrirTelaUsuarioBuscado(Usuario usuario) {
    controladorTelaUsuarioBuscado.setUsuario(usuario);
    controladorTelaUsuarioBuscado.inicializar();

    modalStage(telaUsuarioBuscado, stagePrincipal, "Pesquisa Usuário").showAndWait();
  }

  public void abrirTelaRelatorio() {
    modalStage(telaGerarRelatorio, stagePrincipal, "Gerar Relatório").showAndWait();
  }

  public void abrirTelaRelatorioCaderno(String loginUsuario) {
    controladorCadernoRelatorio.inicializar(loginUsuario);
    modalStage(telaCadernoRelatorio, stagePrincipal, "Cadernos").showAndWait();
  }

  public void abrirTelaRelatorioReceita(String loginUsuario) {
    controladorReceitaRelatorio.inicializar(loginUsuario);
    modalStage(telaReceitaRelatorio, stagePrincipal, "Receitas").showAndWait();
  }

  private Stage modalStage(Parent root, Stage owner, String title) {
    Scene modalScene = root.getScene();
    if (modalScene == null) {
      modalScene = new Scene(root);
    }

    Stage modalStage = new Stage();
    modalStage.setTitle((title != null && !title.isBlank()) ? title : "Janela");
    modalStage.initModality(Modality.APPLICATION_MODAL);
    modalStage.initOwner(owner);
    modalStage.setResizable(false);
    modalStage.setScene(modalScene);

    return modalStage;
  }
}
