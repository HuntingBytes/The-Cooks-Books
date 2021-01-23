package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Usuario;
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


  public void cadastrarUsuario(Usuario usuario) {
    if (!this.repositorioUsuarios.existeUsuario(usuario)) {
      this.repositorioUsuarios.cadastrarUsuario(usuario);
    }
  }


  public void removerUsuario(String nomeUsuario) {
    if (this.repositorioUsuarios.existeUsuario(usuario)) {
      this.repositorioUsuarios.removerUsuario(usuario);
    }
  }


  public Usuario efetuarLogin(String login, String senha) {
    for (Usuario usuario : this.repositorioUsuarios.usuarios) {
      if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
        return usuario;
      }
    }
    return null;
  }


  private Usuario buscarUsuario(String login) {
    for (Usuario usuario : this.repositorioUsuarios.usuarios) {
      if (login.equals(usuario)) {
        return usuario;
      }
    }
    return null;
  }



}
