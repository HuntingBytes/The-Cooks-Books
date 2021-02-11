package com.cooksbooks.controllers;


import com.cooksbooks.database.RepositorioUsuariosList;
import com.cooksbooks.database.interfaces.IRepositorioUsuario;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;

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
  public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, CampoInvalido  {
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

  // TODO alterarNomePerfil
  /**
   *
   */
  public void alterarNomePerfil(String login, String nomePerfil) throws UsuarioInexistente, CampoInvalido {
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

  // TODO alterarBiografia
  /**
   *
   */
  public void alterarBiografia(String login, String biografia) throws UsuarioInexistente, CampoInvalido {
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

  // TODO alterarExperienciaCulinaria
  /**
   *
   */
  public void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria) throws UsuarioInexistente, CampoInvalido {
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

  // TODO alterar Imagem
  /**
   *
   */
  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil) throws UsuarioInexistente, CampoInvalido {
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
