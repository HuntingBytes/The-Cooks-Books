package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.CadernoReceitas;
import java.util.List;

public interface IRepositorioCaderno {

  void cadastrarCaderno(CadernoReceitas cadernoAdd);

  // throws CadernoInexistente
  void removerCaderno(String idCadernoRemover);

  // throws CadernoInexistente
  CadernoReceitas buscarCaderno(String idCadernoQueRetorna);

  boolean existeCaderno(String idCadernoExiste);

  // throws CadernoInexistente
  void alterarNomeCaderno(String idCaderno, String nomeCaderno);

  // throws CadernoInexistente
  void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno);

  // throws CadernoInexistente
  void alterarVisibildadeCaderno(String idCadernoSubstituido, boolean visibilidade);

  // throws CadernoInexistente
  void alterarCaderno(String idCaderno, CadernoReceitas novoCaderno);

  List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario);

  long quantidadeCadernosCadastrados();

  void salvarArquivo();
}
