package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Relatorio;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;
import com.cooksbooks.exceptions.UsuarioJaLogado;
import com.cooksbooks.exceptions.UsuarioSenhaIncorreta;
import java.time.LocalDate;
import java.util.List;

public class CooksBooksFachada implements ICooksBooks {

  private static CooksBooksFachada instancia;

  private final ControladorUsuario controladorUsuario;
  private final ControladorCaderno controladorCaderno;
  private final ControladorReceita controladorReceita;
  private Usuario usuarioLogado;

  public static CooksBooksFachada getInstancia() {
    if (instancia == null) {
      instancia = new CooksBooksFachada();
    }
    return instancia;
  }

  private CooksBooksFachada() {
    this.controladorUsuario = ControladorUsuario.getInstancia();
    this.controladorCaderno = ControladorCaderno.getInstancia();
    this.controladorReceita = ControladorReceita.getInstancia();
  }

  // Usuário
  @Override
  public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, CampoInvalido {
    this.controladorUsuario.cadastrarUsuario(usuario);
  }

  @Override
  public void removerUsuario(String login) throws UsuarioInexistente {
    this.controladorUsuario.removerUsuario(login);
  }

  @Override
  public void alterarBiografia(String login, String biografia)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarBiografia(login, biografia);
  }

  @Override
  public void alterarNomePerfil(String login, String nomePerfil)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarNomePerfil(login, nomePerfil);
  }

  @Override
  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarCaminhoImagemPerfil(login, caminhoImagemPerfil);
  }

  @Override
  public void alterarUsuario(String login, Usuario novoUsuario) {

  }

  @Override
  public void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarExperienciaCulinaria(login, experienciaCulinaria);
  }

  /**
   * Efetua o login do usuário
   *
   * @param login login do usuário
   * @param senha senha do usuário
   */
  public void efetuarLogin(String login, String senha)
      throws UsuarioInexistente, UsuarioJaLogado, UsuarioSenhaIncorreta {
    if (this.usuarioLogado != null) {
      throw new UsuarioJaLogado(this.getUsuarioLogado().getLogin());
    }

    Usuario usuarioASerLogado = this.controladorUsuario.buscarUsuario(login);

    if (usuarioASerLogado.getSenha().equals(senha)) {
      this.usuarioLogado = usuarioASerLogado;
    } else {
      throw new UsuarioSenhaIncorreta(usuarioASerLogado.getLogin());
    }
  }

  @Override
  public Usuario getUsuarioLogado() {
    return this.usuarioLogado;
  }

  @Override
  public Usuario buscarUsuario(String login) throws UsuarioInexistente {
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
  public void alterarReceita(String idReceita, Receita novaReceita) {

  }

  @Override
  public Receita buscarReceita(String idReceita) {
    return this.controladorReceita.buscarReceita(idReceita);
  }

  @Override
  public List<Receita> buscarReceitasDoCaderno(String idCaderno) {
    return this.controladorReceita.listarReceitas(idCaderno);
  }

  @Override
  public List<Receita> buscarTodasReceitasDoUsuario(String loginUsuario) {
    return null;
  }

  // Caderno
  @Override
  public void cadastrarCaderno(CadernoReceitas caderno) {
    caderno.setIdDono(this.usuarioLogado.getLogin());
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
  public void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno) {

  }

  @Override
  public CadernoReceitas buscarCaderno(String idCaderno) {
    return this.controladorCaderno.procurarCaderno(idCaderno);
  }

  /**
   * Retorna uma lista de cadernos de receita
   *
   * @param nomeUsuario
   * @return
   */
  @Override
  public List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario) {
    return this.controladorCaderno.listarCadernosDoUsuario(nomeUsuario);
  }

  @Override
  public Relatorio gerarRelatorio(LocalDate dataInicial, LocalDate dataFinal) {
    return null;
  }
}
