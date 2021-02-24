package com.cooksbooks.controllers;

import com.cooksbooks.database.RepositorioCadernoList;
import com.cooksbooks.database.interfaces.IRepositorioCaderno;
import com.cooksbooks.entity.CadernoReceitas;
import java.util.List;

public class ControladorCaderno {

  private static ControladorCaderno instancia;

  private final IRepositorioCaderno repositorioCadernos;

  /**
   * Construtor do controlador do caderno
   * <p>
   * Define a instância única do repositório de cadernos como atributo
   */
  private ControladorCaderno() {
    this.repositorioCadernos = RepositorioCadernoList.getInstancia();
  }

  /**
   * Método responsável por retornar a instância única do controlador do Caderno (Singleton)
   * <p>
   * Caso ela ainda não exista, uma nova instância será criada e retornada
   *
   * @return instancia do controlador do Caderno
   */
  public static ControladorCaderno getInstancia() {
    if (instancia == null) {
      instancia = new ControladorCaderno();
    }
    return instancia;
  }

  /**
   * Cadastra um caderno ao sistema, caso ele ainda não exista
   *
   * @param caderno caderno a ser cadastrado
   */
  void cadastrarCaderno(CadernoReceitas caderno) {
    caderno.setIdCaderno(String
        .format("%s-%d", caderno.getIdDono(), this.repositorioCadernos.totalCadernosCadastrados()));
    if (this.isCadernoValido(caderno) && !this.repositorioCadernos
        .existeCaderno(caderno.getIdCaderno())) {
      this.repositorioCadernos.cadastrarCaderno(caderno);
      this.repositorioCadernos.salvarArquivo();
    }
  }

  /**
   * Remove um caderno do repositório, caso ele exista
   *
   * @param idCaderno id do caderno a ser removido
   */
  void removerCaderno(String idCaderno) {
    if (this.repositorioCadernos.existeCaderno(idCaderno)) {
      this.repositorioCadernos.removerCaderno(idCaderno);
      this.repositorioCadernos.salvarArquivo();
    }
  }

  /**
   * Busca por um caderno no sistema
   *
   * @param idCaderno id do caderno a ser buscado
   * @return um caderno, caso ele exista
   */
  public CadernoReceitas buscarCaderno(String idCaderno) {
    return this.repositorioCadernos.buscarCaderno(idCaderno);
  }

  public List<CadernoReceitas> buscarCadernosComNome(String nomeCaderno) {
    nomeCaderno = nomeCaderno.trim();
    return this.repositorioCadernos.buscarCadernosComNome(nomeCaderno);
  }

  /**
   * Listar todos os cadernos do usuario no sistema
   *
   * @param nomeUsuario nome do usuario que vai ser listado todos os cadernos
   * @return uma lista de cadernos
   */
  public List<CadernoReceitas> listarCadernosDoUsuario(String nomeUsuario) {
    return this.repositorioCadernos.buscarTodosCadernosDoUsuario(nomeUsuario);
  }


  /**
   * Altera nome de um caderno ja existente
   *
   * @param idDoCaderno id do caderno que vai ser alterado o nome
   * @param nomeNovo    nome novo do caderno que o usuario digitou
   */
  public void alterarNomeCaderno(String idDoCaderno, String nomeNovo) {
    if (this.repositorioCadernos.existeCaderno(idDoCaderno)) {
      if (this.nomeCadernoValido(nomeNovo)) {
        this.repositorioCadernos.alterarNomeCaderno(idDoCaderno, nomeNovo);
        this.repositorioCadernos.salvarArquivo();
      }
    }
  }

  /**
   * Altera informaçoes de um caderno ja existente
   *
   * @param idDoCaderno      id do caderno que vai ser alterado as informaçoes
   * @param informacoesNovas informaçoes novas do caderno que o usuario digitou
   */
  public void alterarInformacoesCaderno(String idDoCaderno, String informacoesNovas) {
    if (this.repositorioCadernos.existeCaderno(idDoCaderno)) {
      if (this.informacoesCadernoValido(informacoesNovas)) {
        this.repositorioCadernos.alterarInformacoesCaderno(idDoCaderno, informacoesNovas);
        this.repositorioCadernos.salvarArquivo();
      }
    }
  }

  /**
   * Altera a visibilidade de um caderno ja existente
   *
   * @param idDoCaderno id do caderno que vai ser alterado a visibilidade
   */
  public void alterarCadernoPublico(String idDoCaderno, boolean visibilidade) {
    if (this.repositorioCadernos.existeCaderno(idDoCaderno)) {
      this.repositorioCadernos.alterarVisibildadeCaderno(idDoCaderno, visibilidade);
      this.repositorioCadernos.salvarArquivo();
    }
  }

  public void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno) {
    if (this.repositorioCadernos.existeCaderno(idCaderno)) {
      if (this.isCadernoValido(novoCaderno)) {
        this.repositorioCadernos.alterarCaderno(idCaderno, novoCaderno);
        this.repositorioCadernos.salvarArquivo();
      }
    }
  }

  /**
   * Faz a verificacao se o caderno é valido, de acordo com as regras do sistema
   *
   * @param caderno caderno a ser julgado valido
   * @return boolean que diz se é valido ou nao TODO: implementar as regras da validez de um caderno
   */
  private boolean isCadernoValido(CadernoReceitas caderno) {
    return true;
  }

  /**
   * Verifica se o nome de um caderno é valido de acordo com as regras do sistema
   *
   * @param nome nome a ser avaliado TODO: implementar as regras da validez de um nome
   */
  private boolean nomeCadernoValido(String nome) {
    return true;
  }

  /**
   * Verifica se as informaçoes de um caderno é valido de acordo com as regras do sistema
   *
   * @param informacoes informaçoes a ser avaliadas TODO: implementar as regras da validez de uma
   *                    informaçao
   */
  private boolean informacoesCadernoValido(String informacoes) {
    return true;
  }
}
