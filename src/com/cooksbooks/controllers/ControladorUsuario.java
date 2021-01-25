package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.utils.ExperienciaCulinaria;
import java.util.List;

public class ControladorUsuario {

  private IRepositorioUsuarios repositorioUsuarios;
  private static ControladorUsuario instancia;

  /**
   * Construtor do controlador do Usuario
   *
   * Define a instância única do repositório de usuários como atributo
   */
  public ControladorUsuario {
    this.repositorioUsuarios = RepositorioUsuarios.getInstancia();
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
    }
  }

  /**
   * Efetua o login do usuário
   *
   * @param login login do usuário
   * @param senha senha do usuário
   * @return um usuário (UsuarioLogado)
   */
  public Usuario efetuarLogin(String login, String senha) {
    for (Usuario usuario : this.repositorioUsuarios.getUsuariosList) {
      if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
        return usuario;
      }
    }
    return null;
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
  }

  // TODO alterarBiografia
  /**
   *
   */
  public void alterarBiografia(String login, String biografia) {
    this.repositorioUsuarios.alterarBiografia(login, biografia);
  }

  // TODO alterarExperienciaCulinaria
  /**
   *
   */
  public void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria) {
    this.repositorioUsuarios.alterarExperienciaCulinaria(login, experienciaCulinaria);
  }

  // TODO alterar Imagem
  /**
   *
   */
  public void alterarCaminhoImagemPerfil(String caminhoImagemPerfil) {

  }

}
