package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;

import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import java.util.List;

public interface ICooksBooks {

  void cadastrarUsuario(Usuario usuario);

  void removerUsuario(String login);

  void alterarNomePerfil(String login, String nomePerfil);

  void alterarBiografia(String login, String biografia);

  void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria);

  void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil);


  boolean efetuarLogin(String login, String senha);

  Usuario getUsuarioLogado();

  void cadastrarReceita(Receita receita, String idCadernoDono);

  void removerReceita(String idReceita);

  void alterarModoPreparo(String idReceita, String modoPreparo);

  void alterarTitulo(String idReceita, String titulo);

  Receita buscarReceita(String idReceita);

  List<Receita> listarReceitasDoCaderno(String idCaderno);


  void cadastrarCaderno(CadernoReceitas caderno);

  void removerCaderno(String idCaderno);

  void alterarNomeCaderno(String idCaderno, String nomeCaderno);

  void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno);

  void alterarVisibilidadeCaderno(String idCaderno, boolean estaVisivel);

  CadernoReceitas buscarCaderno(String idCaderno);

  List<CadernoReceitas> buscarTodosCadernosDoUsuario(String idUsuario);

  List<CadernoReceitas> buscarTodosCadernosDoUsuarioAtual();
}
