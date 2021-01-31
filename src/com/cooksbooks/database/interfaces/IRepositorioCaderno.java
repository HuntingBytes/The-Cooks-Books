package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.CadernoReceitas;
import java.util.List;

public interface IRepositorioCaderno {

  void cadastrarCaderno(CadernoReceitas cadernoAdd);

  void removerCaderno(String idCadernoRemover);

  void alterarNomeCaderno(String idCaderno, String nomeCaderno);

  void alterarInformacoesCaderno(String idCaderno, String informacoesCaderno);

  void alterarVisibildadeCaderno(String idCadernoSubstituido, boolean visibilidade);

  boolean existeCaderno(String idCadernoExiste);

  CadernoReceitas buscarCaderno(String idCadernoQueRetorna);

  List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario);

  void salvarArquivo();

  long quantidadeCadernosCadastrados();
}
