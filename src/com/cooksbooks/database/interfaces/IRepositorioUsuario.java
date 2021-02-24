package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.UsuarioInexistente;
import java.time.LocalDateTime;
import java.util.List;

public interface IRepositorioUsuario {

  void cadastrarUsuario(Usuario usuarioAdd);

  void removerUsuario(String usuarioRemove) throws UsuarioInexistente;

  boolean existeUsuario(String usuarioExiste);

  Usuario buscarUsuario(String usuarioBuscar) throws UsuarioInexistente;

  List<Usuario> buscarUsuariosComNome(String nomePerfil);

  void alterarNomePerfil(String login, String nomePerfil) throws UsuarioInexistente;

  void alterarBiografia(String login, String biografia) throws UsuarioInexistente;

  void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil)
      throws UsuarioInexistente;

  void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria)
      throws UsuarioInexistente;

  void alterarUsuario(String login, Usuario novoUsuario) throws UsuarioInexistente;

  int totalUsuariosEntre(LocalDateTime inicio, LocalDateTime fim);

  int totalUsuarios();

  void salvarArquivo();
}
