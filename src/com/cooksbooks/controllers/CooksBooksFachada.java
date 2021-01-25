package com.cooksbooks.controllers;

import com.cooksbooks.entity.CadernoReceitas;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.Usuario;
import java.util.List;

public class CooksBooksFachada implements ICooksBooks {

  // Talvez o Usuario não precise ser estático
  // Seguindo a mesma ideia dos controladores
  private static Usuario usuarioLogado;
  private static CooksBooksFachada instancia;

  private ControladorUsuario controladorUsuario;
  private ControladorCaderno controladorCaderno;
  private ControladorReceita controladorReceita;

  // Podemos adicionar um getInstancia, como o construtor é privado
  public CooksBooksFachada() {
    this.controladorUsuario = ControladorUsuario.getInstancia();
    this.controladorCaderno = ControladorCaderno.getInstancia();
    this.controladorReceita = ControladorReceita.getInstancia();
  }

  public static ControladorUsuario getInstancia() {
    if (instancia == null) {
      instancia = new ControladorUsuario();
    }
    return instancia;
  }

  // Usuário
  @Override
  public void cadastrarUsuario(Usuario usuario) {
    this.controladorUsuario.cadastrarUsuario(usuario);
  }

  @Override
  public void removerUsuario(String login) {
    this.controladorUsuario.deletarUsuario(login);
  }

  @Override
  public void alterarBiografia() {
    this.

  }

  @Override
  public Usuario efetuarLogin(String login, String senha) {
    return this.controladorUsuario.efetuarLogin(login, senha);
  }

  // Receita
  @Override
  public void cadastrarReceita(Receita receita) {
    this.controladorReceita.cadastrarReceita(receita);
  }

  @Override
  public void removerReceita(String idReceita) {
    this.controladorReceita.removerReceita(idReceita);
  }

  @Override
  public Receita buscarReceita(String idReceita) {
    return this.controladorReceita.buscarReceita(idReceita);
  }

  @Override
  public List<Receita> listarReceitasDoCaderno(String idCaderno) {
    return this.controladorCaderno.listarReceitasDoCaderno(idCaderno);
  }


  // Caderno
  @Override
  public void cadastrarCaderno(CadernoReceitas caderno) {
    this.controladorCaderno.cadastrarCaderno(caderno);
  }

  @Override
  public void removerCaderno(String idCaderno) {
    this.controladorCaderno.removerCaderno(idCaderno);
  }

  @Override
  public CadernoReceitas buscarCaderno(String idCaderno) {
    return this.controladorCaderno.buscarCaderno(idCaderno);
  }

  /**
   * ?? Talvez uma tarefa do controlador caderno??
   *
   * Retorna uma lista de cadernos de receita
   * @param nomeUsuario
   * @return
   */
  @Override
  // Pode ser uma função da camada de dados
  // O repositório busca por todos os cadernos que possuem o nome do usuário
  public List<CadernoReceitas> listarCadernosDoUsuario(String nomeUsuario) {
    return this.controladorUsuario.listarCadernosDoUsuario();
  }
}
