package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import java.util.List;

public class CooksBooksFachada implements ICooksBooks {

  // Talvez o Usuario não precise ser estático
  // Seguindo a mesma ideia dos controladores
  private static Usuario usuarioLogado;
  private static CooksBooksFachada instancia;

  private final ControladorUsuario controladorUsuario;
  private final ControladorCaderno controladorCaderno;
  private final ControladorReceita controladorReceita;

  // Podemos adicionar um getInstancia, como o construtor é privado
  public CooksBooksFachada() {
    this.controladorUsuario = ControladorUsuario.getInstancia();
    this.controladorCaderno = ControladorCaderno.getInstancia();
    this.controladorReceita = ControladorReceita.getInstancia();
  }

  public static CooksBooksFachada getInstancia() {
    if (instancia == null) {
      instancia = new CooksBooksFachada();
    }
    return instancia;
  }

  // Usuário
  @Override
  public void cadastrarUsuario(Usuario usuario) {
    this.controladorUsuario.cadastrarUsuario(usuario);
  }

  @Override
  public void removerUsuario(String login) {
    this.controladorUsuario.removerUsuario(login);
  }

  @Override
  public void alterarBiografia(String login, String biografia) {
    this.controladorUsuario.alterarBiografia(login, biografia);
  }

  @Override
  public void alterarNomePerfil(String login, String nomePerfil) {
    this.controladorUsuario.alterarNomePerfil(login, nomePerfil);
  }

  @Override
  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil) {
    this.controladorUsuario.alterarCaminhoImagemPerfil(login, caminhoImagemPerfil);
  }

  @Override
  public void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria) {
    this.controladorUsuario.alterarExperienciaCulinaria(login, experienciaCulinaria);
  }

  /**
   * Efetua o login do usuário
   *
   * @param login login do usuário
   * @param senha senha do usuário
   *
   */
  public boolean efetuarLogin(String login, String senha) {
    if(CooksBooksFachada.usuarioLogado != null)
      return true;

    Usuario usuarioASerLogado = this.controladorUsuario.buscarUsuario(login);
    if (usuarioASerLogado != null && usuarioASerLogado.getSenha().equals(senha)) {
      usuarioLogado = usuarioASerLogado;
      return true;
    }

    return false;
  }

  @Override
  public Usuario getUsuarioLogado() {
    return CooksBooksFachada.usuarioLogado;
  }

  @Override
  public Usuario buscarUsuario(String login){
    return this.controladorUsuario.buscarUsuario(login);
  }

  // Receita
  @Override
  public void cadastrarReceita(Receita receita, String idCadernoDono) {
    receita.setIdCadernoDono(idCadernoDono);
    this.controladorReceita.cadastrarReceita(receita);
  }

  @Override
  public void removerReceita(String idReceita) {
    this.controladorReceita.removerReceita(idReceita);
  }

  @Override
  public void alterarModoPreparo(String idReceita, String modoPreparo) {
    this.controladorReceita.alterarModoPreparoReceita(idReceita, modoPreparo);
  }

  @Override
  public void alterarTitulo(String idReceita, String titulo) {
    this.controladorReceita.alterarTituloReceita(idReceita, titulo);
  }

  @Override
  public Receita buscarReceita(String idReceita) {
    return this.controladorReceita.buscarReceita(idReceita);
  }

  @Override
  public List<Receita> listarReceitasDoCaderno(String idCaderno) {
    return this.controladorReceita.listarReceitas(idCaderno);
  }


  // Caderno
  @Override
  public void cadastrarCaderno(CadernoReceitas caderno) {
    caderno.setIdDono(CooksBooksFachada.usuarioLogado.getLogin());
    caderno.setIdCaderno(caderno.getNomeCaderno());
    this.controladorCaderno.cadastrarCaderno(caderno);
  }

  @Override
  public void removerCaderno(String idCaderno) {
    this.controladorCaderno.removerCaderno(idCaderno);
  }

  @Override
  public void alterarNomeCaderno(String idCaderno, String nomeCaderno) {
    this.controladorCaderno.alterarNomeCaderno(idCaderno, nomeCaderno);
  }

  @Override
  public void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno) {

  }

  @Override
  public void alterarVisibilidadeCaderno(String idCaderno, boolean estaVisivel) {
    this.controladorCaderno.alterarCadernoPublico(idCaderno, estaVisivel);
  }

  @Override
  public CadernoReceitas buscarCaderno(String idCaderno) {
    return this.controladorCaderno.procurarCaderno(idCaderno);
  }

  /**
   *
   *Retorna uma lista de cadernos de receita
   * @param nomeUsuario
   * @return
   */
  @Override
  // Pode ser uma função da camada de dados
  // O repositório busca por todos os cadernos que possuem o nome do usuário
  public List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario) {
    return this.controladorCaderno.listarCadernosDoUsuario(nomeUsuario);
  }

  @Override
  public List<CadernoReceitas> buscarTodosCadernosDoUsuarioAtual() {
    return buscarTodosCadernosDoUsuario(CooksBooksFachada.usuarioLogado.getLogin());
  }
}
