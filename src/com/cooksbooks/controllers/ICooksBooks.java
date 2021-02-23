package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Relatorio;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.exceptions.CampoInvalido;
import com.cooksbooks.exceptions.UsuarioInexistente;
import com.cooksbooks.exceptions.UsuarioJaCadastrado;
import com.cooksbooks.exceptions.UsuarioJaLogado;
import com.cooksbooks.exceptions.UsuarioSenhaIncorreta;
import java.time.LocalDate;
import java.util.List;

public interface ICooksBooks {

  void efetuarLogin(String login, String senha)
      throws UsuarioInexistente, UsuarioJaLogado, UsuarioSenhaIncorreta;

  Usuario getUsuarioLogado();

  void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, CampoInvalido;

  void removerUsuario(String login) throws UsuarioInexistente;

  Usuario buscarUsuario(String login) throws UsuarioInexistente;

  void alterarNomePerfil(String login, String nomePerfil) throws UsuarioInexistente, CampoInvalido;

  void alterarBiografia(String login, String biografia) throws UsuarioInexistente, CampoInvalido;

  void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria)
      throws UsuarioInexistente, CampoInvalido;

  void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil)
      throws UsuarioInexistente, CampoInvalido;

  void alterarUsuario(String login, Usuario novoUsuario) throws UsuarioInexistente, CampoInvalido;

  // throws ReceitaComMesmoTituloJaExiste, CampoInvalido
  void cadastrarReceita(Receita receita, String idCadernoDono);

  // throws ReceitaInexistente
  void removerReceita(String idReceita);

  // throws ReceitaInexistente
  Receita buscarReceita(String idReceita);

  // throws ReceitaInexistente, CampoInvalido
  void alterarTitulo(String idReceita, String titulo);

  // throws ReceitaInexistente, CampoInvalido
  void alterarModoPreparo(String idReceita, String modoPreparo);

  // throws ReceitaInexistente, CampoInvalido
  void alterarCusto(String idReceita, Custo custo);

  // throws ReceitaInexistente, CampoInvalido
  void alterarRendimento(String idReceita, Rendimento rendimento);

  // throws ReceitaInexistente, CampoInvalido
  void alterarDificuldade(String idReceita, Dificuldade dificuldade);

  // throws ReceitaInexistente, CampoInvalido
  void adicionarCategoria(String idReceita, Categoria categoria);

  // throws ReceitaInexistente, CampoInvalido
  void removerCategoria(String idReceita, Categoria categoria);

  // throws ReceitaInexistente, CampoInvalido
  void adicionarIngrediente(String idReceita, Ingrediente ingrediente);

  // throws ReceitaInexistente, CampoInvalido
  void removerIngrediente(String idReceita, Ingrediente ingrediente);

  // throws ReceitaInexistente, CampoInvalido
  void alterarReceita(String idReceita, Receita novaReceita);

  // throws CadernoInexistente
  List<Receita> buscarReceitasDoCaderno(String idCaderno);

  // throws UsuarioInexistente
  List<Receita> buscarTodasReceitasDoUsuario(String loginUsuario);

  // throws CadernoComMesmoNomeJaExiste, CampoInvalido
  void cadastrarCaderno(CadernoReceitas caderno, String idDono);

  // throws CadernoInexistente
  void removerCaderno(String idCaderno);

  // throws CadernoInexistente, CampoInvalido
  CadernoReceitas buscarCaderno(String idCaderno);

  // throws CadernoInexistente, CampoInvalido
  void alterarNomeCaderno(String idCaderno, String nomeCaderno);

  // throws CadernoInexistente, CampoInvalido
  void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno);

  // throws CadernoInexistente
  void alterarVisibilidadeCaderno(String idCaderno, boolean estaVisivel);

  // throws CadernoInexistente, CampoInvalido
  void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno);

  // throws UsuarioInexistente
  List<CadernoReceitas> buscarTodosCadernosDoUsuario(String idUsuario);

  Relatorio gerarRelatorio(LocalDate dataInicial, LocalDate dataFinal);
}
