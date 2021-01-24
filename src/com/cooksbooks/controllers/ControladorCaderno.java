package com.cooksbooks.controllers;

import com.cooksbooks.dados.RepositorioCadernoList;
import com.cooksbooks.dados.interfaces.IRepositorioCaderno;
import com.cooksbooks.entity.CadernoReceitas;
import java.util.List;

public class ControladorCaderno {

  private static ControladorCaderno instancia;
  private final IRepositorioCaderno repositorioCadernos;

  public ControladorCaderno() {
    this.repositorioCadernos = RepositorioCadernoList.getInstancia();
  }

  public static ControladorCaderno getInstancia() {
    if (instancia == null) {
      instancia = new ControladorCaderno();
    }
    return instancia;
  }

  void cadastrarCaderno(CadernoReceitas caderno) {
    if (cadernoValido(caderno)) {
      caderno.setIdCaderno(String.format("%s-%d", caderno.getIdDono(),
          repositorioCadernos.quantidadeCadernosCadastrados()));
      repositorioCadernos.cadastrarCaderno(caderno);
      repositorioCadernos.salvarArquivo();
    }
  }

  void removerCaderno(String idCaderno) {
    repositorioCadernos.removerCaderno(idCaderno);
  }

  public CadernoReceitas procurarCaderno(String idCaderno) {
    return repositorioCadernos.buscarCaderno(idCaderno);
  }

  public List<CadernoReceitas> listarCadernosDoUsuario(String nomeUsuario) {
    return repositorioCadernos.buscarTodosCadernosDoUsuario(nomeUsuario);
  }

  private boolean cadernoValido(CadernoReceitas caderno) {
    return true;
  }

  public void alterarNomeCaderno(String idDoCaderno, String nomeNovo) {
    if (nomeCadernoValido(nomeNovo)) {
      repositorioCadernos.alterarNomeCadernoExistente(idDoCaderno, nomeNovo);
    }
  }

  public void alterarInformacoesCaderno(String idDoCaderno, String informacoesNovas) {
    if (informaçoesCadernoValido(informacoesNovas)) {
      repositorioCadernos.alterarinformacoesCadernoExistente(idDoCaderno, informacoesNovas);
    }
  }

  public void alterarCadernoPublico(String idDoCaderno) {
    repositorioCadernos.alterarCadernoPublicoExistente(idDoCaderno);
  }

  private boolean nomeCadernoValido(String nome) {
    return true;
  }

  private boolean informaçoesCadernoValido(String informacoes) {
    return true;
  }
}
