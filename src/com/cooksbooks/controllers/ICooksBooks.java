package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;

import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;
import com.cooksbooks.exceptions.UsuarioJaLogado;
import com.cooksbooks.exceptions.UsuarioSenhaIncorreta;
import java.util.List;

public interface ICooksBooks {

  void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, CampoInvalido;

  void removerUsuario(String login) throws UsuarioInexistente;

  void alterarNomePerfil(String login, String nomePerfil) throws UsuarioInexistente, CampoInvalido;

  void alterarBiografia(String login, String biografia) throws UsuarioInexistente, CampoInvalido;

  void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria) throws UsuarioInexistente, CampoInvalido;

  void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil) throws UsuarioInexistente, CampoInvalido;

  void efetuarLogin(String login, String senha) throws UsuarioInexistente, UsuarioJaLogado, UsuarioSenhaIncorreta;

  Usuario getUsuarioLogado();

  Usuario buscarUsuario(String login) throws UsuarioInexistente;

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
