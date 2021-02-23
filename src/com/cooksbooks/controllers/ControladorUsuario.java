package com.cooksbooks.controllers;


import com.cooksbooks.database.RepositorioUsuariosList;
import com.cooksbooks.database.interfaces.IRepositorioUsuario;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;
import java.time.LocalDateTime;

public class ControladorUsuario {

  private static ControladorUsuario instancia;

  private final IRepositorioUsuario repositorioUsuarios;

  /**
   * Construtor do controlador do Usuario
   * <p>
   * Define a instância única do repositório de usuários como atributo
   */
  private ControladorUsuario() {
    this.repositorioUsuarios = RepositorioUsuariosList.getInstancia();
  }

  /**
   * Método responsável por retornar a instância única do controlador do usuário (Singleton)
   * <p>
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
  public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, CampoInvalido {
    if (this.isUsuarioValido(usuario)) {
      if (!this.repositorioUsuarios.existeUsuario(usuario.getLogin())) {
        this.repositorioUsuarios.cadastrarUsuario(usuario);
        this.repositorioUsuarios.salvarArquivo();
      } else {
        throw new UsuarioJaCadastrado(usuario.getLogin());
      }
    }
  }

  /**
   * Remove um usuário do repositório, caso ele exista
   *
   * @param nomeUsuario usuario a ser removido
   */
  public void removerUsuario(String nomeUsuario) throws UsuarioInexistente {
    if (this.repositorioUsuarios.existeUsuario(nomeUsuario)) {
      this.repositorioUsuarios.removerUsuario(nomeUsuario);
      this.repositorioUsuarios.salvarArquivo();
    } else {
      throw new UsuarioInexistente(nomeUsuario);
    }
  }

  /**
   * Busca por um usuario
   *
   * @param login login do usuario a ser buscado
   * @return um usuario
   */
  public Usuario buscarUsuario(String login) throws UsuarioInexistente {
    return this.repositorioUsuarios.buscarUsuario(login);
  }

  public void alterarNomePerfil(String login, String nomePerfil)
      throws UsuarioInexistente, CampoInvalido {
    if (this.isNomePerfilValido(nomePerfil)) {
      if (this.repositorioUsuarios.existeUsuario(login)) {
        this.repositorioUsuarios.alterarNomePerfil(login, nomePerfil);
        this.repositorioUsuarios.salvarArquivo();
      } else {
        throw new UsuarioInexistente(login);
      }
    } else {
      throw new CampoInvalido("Nome de Perfil");
    }
  }

  public void alterarBiografia(String login, String biografia)
      throws UsuarioInexistente, CampoInvalido {
    if (this.isBiografiaValida(biografia)) {
      if (this.repositorioUsuarios.existeUsuario(login)) {
        this.repositorioUsuarios.alterarBiografia(login, biografia);
        this.repositorioUsuarios.salvarArquivo();
      } else {
        throw new UsuarioInexistente(login);
      }
    } else {
      throw new CampoInvalido("Biografia");
    }
  }

  public void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria)
      throws UsuarioInexistente, CampoInvalido {
    if (experienciaCulinaria != null) {
      if (this.repositorioUsuarios.existeUsuario(login)) {
        this.repositorioUsuarios.alterarExperienciaCulinaria(login, experienciaCulinaria);
        this.repositorioUsuarios.salvarArquivo();
      } else {
        throw new UsuarioInexistente(login);
      }
    } else {
      throw new CampoInvalido("Experiência Culinária");
    }
  }

  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil)
      throws UsuarioInexistente, CampoInvalido {
    if (this.isCaminhoImagemPerfilValido(caminhoImagemPerfil)) {
      if (this.repositorioUsuarios.existeUsuario(login)) {
        this.repositorioUsuarios.alterarCaminhoImagemPerfil(login, caminhoImagemPerfil);
        this.repositorioUsuarios.salvarArquivo();
      } else {
        throw new UsuarioInexistente(login);
      }
    } else {
      throw new CampoInvalido("Caminho Imagem Perfil");
    }
  }

  public void alterarUsuario(String login, Usuario novoUsuario)
      throws UsuarioInexistente, CampoInvalido {
    if (this.isUsuarioValido(novoUsuario)) {
      if (this.repositorioUsuarios.existeUsuario(login)) {
        this.repositorioUsuarios.alterarUsuario(login, novoUsuario);
        this.repositorioUsuarios.salvarArquivo();
      } else {
        throw new UsuarioInexistente(login);
      }
    }
  }

  public int getTotalUsuariosEntre(LocalDateTime inicio, LocalDateTime fim) {
    return this.repositorioUsuarios.totalUsuariosEntre(inicio, fim);
  }

  public int getTotalUsuarios() {
    return this.repositorioUsuarios.totalUsuarios();
  }

  private boolean isUsuarioValido(Usuario usuario) throws CampoInvalido {
    return true;
  }

  private boolean isNomePerfilValido(String nomePerfil) {
    return true;
  }

  private boolean isBiografiaValida(String biografia) {
    return true;
  }

  private boolean isCaminhoImagemPerfilValido(String caminhoImagemPerfil) {
    return true;
  }
}
