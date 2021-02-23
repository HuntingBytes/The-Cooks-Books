package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Relatorio;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Comentario;
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
import java.util.ArrayList;
import java.util.List;

public class CooksBooksFachada implements ICooksBooks {

  private static CooksBooksFachada instancia;

  private final ControladorUsuario controladorUsuario;
  private final ControladorCaderno controladorCaderno;
  private final ControladorReceita controladorReceita;
  private Usuario usuarioLogado;

  private CooksBooksFachada() {
    this.controladorUsuario = ControladorUsuario.getInstancia();
    this.controladorCaderno = ControladorCaderno.getInstancia();
    this.controladorReceita = ControladorReceita.getInstancia();
  }

  public static CooksBooksFachada getInstancia() {
    if (instancia == null) {
      instancia = new CooksBooksFachada();
    }
    return instancia;
  }

  /**
   * Efetua o login do usuário
   *
   * @param login login do usuário
   * @param senha senha do usuário
   */
  public void efetuarLogin(String login, String senha)
      throws UsuarioInexistente, UsuarioJaLogado, UsuarioSenhaIncorreta {
    if (this.usuarioLogado != null) {
      throw new UsuarioJaLogado(this.getUsuarioLogado().getLogin());
    }

    Usuario usuarioASerLogado = this.controladorUsuario.buscarUsuario(login);

    if (usuarioASerLogado.getSenha().equals(senha)) {
      this.usuarioLogado = usuarioASerLogado;
    } else {
      throw new UsuarioSenhaIncorreta(usuarioASerLogado.getLogin());
    }
  }

  @Override
  public void cadastrarUsuario(Usuario usuario) throws UsuarioJaCadastrado, CampoInvalido {
    this.controladorUsuario.cadastrarUsuario(usuario);
  }

  @Override
  public void removerUsuario(String login) throws UsuarioInexistente {
    this.controladorUsuario.removerUsuario(login);
    for (CadernoReceitas cadernoReceitas : this.buscarTodosCadernosDoUsuario(login)) {
      for (Receita receita : this.buscarReceitasDoCaderno(cadernoReceitas.getIdCaderno())) {
        this.controladorReceita.removerReceita(receita.getIdReceita());
      }
      this.controladorCaderno.removerCaderno(cadernoReceitas.getIdCaderno());
    }
  }

  @Override
  public Usuario buscarUsuario(String login) throws UsuarioInexistente {
    return this.controladorUsuario.buscarUsuario(login);
  }

  @Override
  public void alterarBiografia(String login, String biografia)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarBiografia(login, biografia);
  }

  @Override
  public void alterarNomePerfil(String login, String nomePerfil)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarNomePerfil(login, nomePerfil);
  }

  @Override
  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarCaminhoImagemPerfil(login, caminhoImagemPerfil);
  }

  @Override
  public void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria)
      throws UsuarioInexistente, CampoInvalido {
    this.controladorUsuario.alterarExperienciaCulinaria(login, experienciaCulinaria);
  }

  @Override
  public void alterarUsuario(String login, Usuario novoUsuario)
      throws CampoInvalido, UsuarioInexistente {
    this.controladorUsuario.alterarUsuario(login, novoUsuario);
  }

  @Override
  public Usuario getUsuarioLogado() {
    return this.usuarioLogado;
  }

  // Receita
  @Override
  public void cadastrarReceita(Receita receita, String idCadernoDono) {
    receita.setIdCadernoDono(idCadernoDono);
    this.controladorReceita.cadastrarReceita(receita);
  }

  @Override
  public void removerReceita(String idReceita) {
    this.controladorReceita.removerReceita(idReceita);
  }

  @Override
  public void alterarModoPreparo(String idReceita, String modoPreparo) {
    this.controladorReceita.alterarModoPreparoReceita(idReceita, modoPreparo);
  }

  @Override
  public void alterarTitulo(String idReceita, String titulo) {
    this.controladorReceita.alterarTituloReceita(idReceita, titulo);
  }

  @Override
  public void alterarCusto(String idReceita, Custo custo) {
    this.controladorReceita.alterarCusto(idReceita, custo);
  }

  @Override
  public void alterarRendimento(String idReceita, Rendimento rendimento) {
    this.controladorReceita.alterarRendimento(idReceita, rendimento);
  }

  @Override
  public void alterarDificuldade(String idReceita, Dificuldade dificuldade) {
    this.controladorReceita.alterarDificuldade(idReceita, dificuldade);
  }

  @Override
  public void adicionarCategoria(String idReceita, Categoria categoria) {
    this.controladorReceita.adicionarCategoria(idReceita, categoria);
  }

  @Override
  public void removerCategoria(String idReceita, Categoria categoria) {
    this.controladorReceita.removerCategoria(idReceita, categoria);
  }

  @Override
  public void adicionarIngrediente(String idReceita, Ingrediente ingrediente) {
    this.controladorReceita.adicionarIngrediente(idReceita, ingrediente);
  }

  @Override
  public void removerIngrediente(String idReceita, Ingrediente ingrediente) {
    this.controladorReceita.removerIngrediente(idReceita, ingrediente);
  }

  @Override
  public void alterarReceita(String idReceita, Receita novaReceita) {
    this.controladorReceita.alterarReceita(idReceita, novaReceita);
  }

  @Override
  public Receita buscarReceita(String idReceita) {
    return this.controladorReceita.buscarReceita(idReceita);
  }

  @Override
  public List<Receita> buscarReceitasDoCaderno(String idCaderno) {
    return this.controladorReceita.listarReceitas(idCaderno);
  }

  @Override
  public List<Receita> buscarTodasReceitasDoUsuario(String loginUsuario) {
    return null;
  }

  // Caderno
  @Override
  public void cadastrarCaderno(CadernoReceitas caderno, String idDono) {
    caderno.setIdDono(idDono);
    this.controladorCaderno.cadastrarCaderno(caderno);
  }

  @Override
  public void removerCaderno(String idCaderno) {
    this.controladorCaderno.removerCaderno(idCaderno);
  }

  @Override
  public void alterarNomeCaderno(String idCaderno, String nomeCaderno) {
    this.controladorCaderno.alterarNomeCaderno(idCaderno, nomeCaderno);
  }

  @Override
  public void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno) {

  }

  @Override
  public void alterarVisibilidadeCaderno(String idCaderno, boolean estaVisivel) {
    this.controladorCaderno.alterarCadernoPublico(idCaderno, estaVisivel);
  }

  @Override
  public void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno) {
    this.controladorCaderno.alterarCaderno(idCaderno, novoCaderno);
  }

  @Override
  public CadernoReceitas buscarCaderno(String idCaderno) {
    return this.controladorCaderno.procurarCaderno(idCaderno);
  }

  /**
   * Retorna uma lista de cadernos de receita
   *
   * @param nomeUsuario
   * @return
   */
  @Override
  public List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario) {
    return this.controladorCaderno.listarCadernosDoUsuario(nomeUsuario);
  }

  @Override
  public Relatorio gerarRelatorio(LocalDate dataInicial, LocalDate dataFinal) {
    Relatorio relatorio = new Relatorio();
    relatorio.setDataIncial(dataInicial);
    relatorio.setDataFinal(dataFinal);
    relatorio.setQtdUsuariosCadastrados(this.controladorUsuario.getTotalUsuarios());
    relatorio.setQtdNovosUsuarios(this.controladorUsuario.getTotalUsuariosEntre(
        dataInicial.atStartOfDay(), dataFinal.atStartOfDay()));
    relatorio.setQtdUsuariosAtivos(relatorio.getQtdNovosUsuarios());
    relatorio.setComentarios(new ArrayList<>()); // Falta adicionar o repositório de sugestões!
    return relatorio;
  }
}
