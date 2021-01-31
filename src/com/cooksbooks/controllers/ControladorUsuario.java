package com.cooksbooks.controllers;


import com.cooksbooks.database.RepositorioUsuariosList;
import com.cooksbooks.database.interfaces.IRepositorioUsuario;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;

public class ControladorUsuario {

  private final IRepositorioUsuario repositorioUsuarios;
  private static ControladorUsuario instancia;

  /**
   * Construtor do controlador do Usuario
   *
   * Define a instância única do repositório de usuários como atributo
   */
  private ControladorUsuario (){
    this.repositorioUsuarios = RepositorioUsuariosList.getInstancia();
  }

  /**
   * Método responsável por retornar a instância única do controlador
   * do usuário (Singleton)
   *
   * Caso ela ainda não exista, uma nova instância será criada e retornada
   *
   * @return instancia do controlador do usuario
   */
  public static ControladorUsuario getInstancia() {
    if (instancia == null) {
      instancia = new ControladorUsuario();
    }
    return instancia;
  }

  /**
   * Cadastra um usuário no sistema, caso ele ainda não exista
   *
   * @param usuario usuario a ser cadastrado
   */
  public void cadastrarUsuario(Usuario usuario) {
    if (!this.repositorioUsuarios.existeUsuario(usuario.getLogin())) {
      this.repositorioUsuarios.cadastrarUsuario(usuario);
      this.repositorioUsuarios.salvarArquivo();
    }
  }

  /**
   * Remove um usuário do repositório, caso ele exista
   *
   * @param nomeUsuario usuario a ser removido
   */
  public void removerUsuario(String nomeUsuario) {
    if (this.repositorioUsuarios.existeUsuario(nomeUsuario)) {
      this.repositorioUsuarios.removerUsuario(nomeUsuario);
      this.repositorioUsuarios.salvarArquivo();
    }
  }



  /**
   * Busca por um usuario
   *
   * @param login login do usuario a ser buscado
   * @return um usuario
   */
  public Usuario buscarUsuario(String login) {
    return this.repositorioUsuarios.buscarUsuario(login);
  }

  // TODO alterarNomePerfil
  /**
   *
   */
  public void alterarNomePerfil(String login, String nomePerfil) {
    this.repositorioUsuarios.alterarNomePerfil(login, nomePerfil);
    this.repositorioUsuarios.salvarArquivo();
  }

  // TODO alterarBiografia
  /**
   *
   */
  public void alterarBiografia(String login, String biografia) {
    this.repositorioUsuarios.alterarBiografia(login, biografia);
    this.repositorioUsuarios.salvarArquivo();
  }

  // TODO alterarExperienciaCulinaria
  /**
   *
   */
  public void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria) {
    this.repositorioUsuarios.alterarExperienciaCulinaria(login, experienciaCulinaria);
    this.repositorioUsuarios.salvarArquivo();
  }

  // TODO alterar Imagem
  /**
   *
   */
  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil) {

  }

}
