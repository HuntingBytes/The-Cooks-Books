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
  public ControladorCaderno() {
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
    if (cadernoValido(caderno) && !repositorioCadernos.existeCaderno(caderno.getIdCaderno())) {
      repositorioCadernos.cadastrarCaderno(caderno);
      repositorioCadernos.salvarArquivo();
    }
  }

  /**
   * Remove um caderno do repositório, caso ele exista
   *
   * @param idCaderno id do caderno a ser removido
   */
  void removerCaderno(String idCaderno) {
    if (repositorioCadernos.existeCaderno(idCaderno)) {
      repositorioCadernos.removerCaderno(idCaderno);
      repositorioCadernos.salvarArquivo();
    }
  }

  /**
   * Busca por um caderno no sistema
   *
   * @param idCaderno id do caderno a ser buscado
   * @return um caderno, caso ele exista
   */
  public CadernoReceitas procurarCaderno(String idCaderno) {
    return repositorioCadernos.buscarCaderno(idCaderno);
  }

  public void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno) {

  }

  /**
   * Listar todos os cadernos do usuario no sistema
   *
   * @param nomeUsuario nome do usuario que vai ser listado todos os cadernos
   * @return uma lista de cadernos
   */
  public List<CadernoReceitas> listarCadernosDoUsuario(String nomeUsuario) {
    return repositorioCadernos.buscarTodosCadernosDoUsuario(nomeUsuario);
  }

  /**
   * Faz a verificacao se o caderno é valido, de acordo com as regras do sistema
   *
   * @param caderno caderno a ser julgado valido
   * @return boolean que diz se é valido ou nao TODO: implementar as regras da validez de um caderno
   */
  private boolean cadernoValido(CadernoReceitas caderno) {
    return true;
  }

  /**
   * Altera nome de um caderno ja existente
   *
   * @param idDoCaderno id do caderno que vai ser alterado o nome
   * @param nomeNovo    nome novo do caderno que o usuario digitou
   */
  public void alterarNomeCaderno(String idDoCaderno, String nomeNovo) {
    if (nomeCadernoValido(nomeNovo)) {
      repositorioCadernos.alterarNomeCaderno(idDoCaderno, nomeNovo);
      repositorioCadernos.salvarArquivo();
    }
  }

  /**
   * Altera informaçoes de um caderno ja existente
   *
   * @param idDoCaderno      id do caderno que vai ser alterado as informaçoes
   * @param informacoesNovas informaçoes novas do caderno que o usuario digitou
   */
  public void alterarInformacoesCaderno(String idDoCaderno, String informacoesNovas) {
    if (informacoesCadernoValido(informacoesNovas)) {
      repositorioCadernos.alterarInformacoesCaderno(idDoCaderno, informacoesNovas);
      repositorioCadernos.salvarArquivo();
    }
  }

  /**
   * Altera a visibilidade de um caderno ja existente
   *
   * @param idDoCaderno id do caderno que vai ser alterado a visibilidade
   */
  public void alterarCadernoPublico(String idDoCaderno, boolean visibilidade) {
    repositorioCadernos.alterarVisibildadeCaderno(idDoCaderno, visibilidade);
    repositorioCadernos.salvarArquivo();
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
