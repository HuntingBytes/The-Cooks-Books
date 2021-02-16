package com.cooksbooks.entity.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A Classe PermissaoEspecial é responsável por definir ações que um Administrador pode realizar no
 * sistema.
 * <p>
 * Ela é responsável por diferenciar um Administrador de um Usuario padrão.
 *
 * @version 1.0
 */
public enum PermissaoEspecial {
  REMOVER_COMENTARIO("Remover Comentário"),
  REMOVER_RECEITA("Remover Receita"),
  REMOVER_CADERNO("Remover Caderno"),
  REMOVER_IMAGEM("Remover Imagem"),
  GERAR_RELATORIO("Gerar Relatório"),
  BANIR_USUARIO("Banir Usuário");

  private final String extenso;

  PermissaoEspecial(String extenso) {
    this.extenso = extenso;
  }

  /**
   * Retorna uma lista com as permissões especiais padrão para qualquer {@code Administrador}.
   *
   * @return {@code List<PermissaoEspecial>} com GERAR_RELATORIO e REMOVER_COMENTARIO
   */
  public static List<PermissaoEspecial> gerarPermissoesPadrao() {
    List<PermissaoEspecial> permissoes = new ArrayList<>();
    permissoes.add(GERAR_RELATORIO);
    permissoes.add(REMOVER_COMENTARIO);
    return permissoes;
  }

  /**
   * Função para uso interno, só deve ser utilizada para debug. Realiza algumas operações com a
   * classe e imprime no console.
   */
  public static void debug() {
    PermissaoEspecial permissaoEspecial = PermissaoEspecial.BANIR_USUARIO;
    List<PermissaoEspecial> permissoes = PermissaoEspecial.gerarPermissoesPadrao();

    for (PermissaoEspecial p : permissoes) {
      System.out.printf("Possui a permissão: %s\n", p);
    }

    permissoes.add(permissaoEspecial);

    if (permissoes.contains(permissaoEspecial)) {
      System.out.printf("O administrador possui a permissão: %s\n", permissaoEspecial);
    } else {
      System.out.printf("O administrador não possui a permissão: %s\n", permissaoEspecial);
    }
  }

  /**
   * Retorna uma String com a representação textual da permissão.
   *
   * @return String que representa a instância
   */
  @Override
  public String toString() {
    return extenso;
  }
}
