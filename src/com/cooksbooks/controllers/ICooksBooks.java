package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;

import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import java.util.List;

public interface ICooksBooks {

  // throws UsuarioJaCadastrado, CampoInvalido
  void cadastrarUsuario(Usuario usuario);

  // throws UsuarioInexistente
  void removerUsuario(String login);

  // throws UsuarioInexistente, CampoInvalido
  void alterarNomePerfil(String login, String nomePerfil);

  // throws UsuarioInexistente, CampoInvalido
  void alterarBiografia(String login, String biografia);

  // throws UsuarioInexistente, CampoInvalido
  void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria);

  // throws UsuarioInexistente, CampoInvalido
  void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil);

  // vira void + throws UsuarioInexistente, UsuarioJaLogado, UsuarioSenhaIncorreta
  boolean efetuarLogin(String login, String senha);

  Usuario getUsuarioLogado();

  // throws UsuarioInexistente
  Usuario buscarUsuario(String login);

  // throws ReceitaComMesmoTituloJaExiste, CampoInvalido
  void cadastrarReceita(Receita receita, String idCadernoDono);

  // throws ReceitaInexistente
  void removerReceita(String idReceita);

  // throws ReceitaInexistente, CampoInvalido
  void alterarModoPreparo(String idReceita, String modoPreparo);

  // throws ReceitaInexistente, CampoInvalido
  void alterarTitulo(String idReceita, String titulo);

  // throws ReceitaInexistente
  Receita buscarReceita(String idReceita);

  // throws CadernoInexistente
  List<Receita> listarReceitasDoCaderno(String idCaderno);


  // throws CadernoComMesmoNomeJaExiste, CampoInvalido
  void cadastrarCaderno(CadernoReceitas caderno);

  // throws CadernoInexistente
  void removerCaderno(String idCaderno);

  // throws CadernoInexistente, CampoInvalido
  void alterarNomeCaderno(String idCaderno, String nomeCaderno);

  // throws CadernoInexistente, CampoInvalido
  void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno);

  // throws CadernoInexistente
  void alterarVisibilidadeCaderno(String idCaderno, boolean estaVisivel);

  // throws CadernoInexistente, CampoInvalido
  CadernoReceitas buscarCaderno(String idCaderno);

  // throws UsuarioInexistente
  List<CadernoReceitas> buscarTodosCadernosDoUsuario(String idUsuario);

  // Talvez remover!
  List<CadernoReceitas> buscarTodosCadernosDoUsuarioAtual();
}
