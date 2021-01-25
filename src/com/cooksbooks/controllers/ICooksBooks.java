package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;

import com.cooksbooks.utils.ExperienciaCulinaria;
import java.util.List;

public interface ICooksBooks {

  void cadastrarUsuario(Usuario usuario);

  void removerUsuario(String login);

  void alterarNomePerfil(String login, String nomePerfil);

  void alterarBiografia(String login, String biografia);

  void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria);

  void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil);


  Usuario efetuarLogin(String login, String senha);


  void cadastrarReceita(Receita receita);

  void removerReceita(String idReceita);

  void alterarModoPreparo(String login, String modoPreparo);

  void alterarTitulo(String login, String titulo);

  Receita buscarReceita(String idReceita);

  List<Receita> listarReceitasDoCaderno(String idCaderno);


  void cadastrarCaderno(CadernoReceitas caderno);

  void removerCaderno(String idCaderno);

  void alterarNomeCaderno(String idCaderno, String nomeCaderno);

  void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno);

  CadernoReceitas buscarCaderno(String idCaderno);

  List<CadernoReceitas> listarCadernosDoUsuario(String nomeUsuario);
}
