package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.utils.MinhasReceitas; // Remover esse import, talvez?
// Podemos rever se ainda faz sentido manter uma classe "MinhasReceitas"
import java.util.List;

public interface ICooksBooks {


  void cadastrarUsuario(Usuario usuario);
  void removerUsuario(String login);
  Usuario efetuarLogin(String login, String senha);

  void cadastrarReceita(Receita receita);
  void removerReceita(String idReceita);
  Receita buscarReceita(String idReceita);
  List<Receita> listarReceitasDoCaderno(String idCaderno);

  void cadastrarCaderno(CadernoReceitas caderno);
  void removerCaderno(String idCaderno);
  CadernoReceitas buscarCaderno(String idCaderno);
  List<CadernoReceitas> listarCadernosDoUsuario(String nomeUsuario);

}
