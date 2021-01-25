package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.CadernoReceitas;
import java.util.List;

public interface IRepositorioCaderno {

  void cadastrarCaderno(CadernoReceitas cadernoAdd);

  void removerCaderno(String idCadernoRemover);

  void alterarNomeCadernoExistente(String idCadernoSubstituido, String nomeCadernoNovo);

  void alterarinformacoesCadernoExistente(String idCadernoSubstituido, String informacoesCadernoNovo);

  void alterarVisibildadeCaderno(String idCadernoSubstituido, boolean visibilidade);

  boolean existeCaderno(String idCadernoExiste);

  CadernoReceitas buscarCaderno(String idCadernoQueRetorna);

  List<CadernoReceitas> buscarTodosCadernosDoUsuario(String nomeUsuario);

  void salvarArquivo();

  long quantidadeCadernosCadastrados();
}
