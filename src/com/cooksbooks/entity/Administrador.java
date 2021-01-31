package com.cooksbooks.entity;

import com.cooksbooks.entity.utils.PermissaoEspecial;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Administrador extends Usuario implements Serializable {

  @Serial
  private static final long serialVersionUID = -5388433820291172195L;
  /**
   * A Classe Administrador representa um administrador do sistema, um usuário
   * com permissões especiais, como REMOVER COMENTARIO e GERAR RELATORIO
   */
  private final List<PermissaoEspecial> permissoesAdministrador;

  public Administrador(String login, String senha) {
    super(login, senha);
    this.permissoesAdministrador = PermissaoEspecial.gerarPermissoesPadrao();
  }

  public Administrador(String login, String senha, List<PermissaoEspecial> permissoes) {
    super(login, senha);
    this.permissoesAdministrador = PermissaoEspecial.gerarPermissoesPadrao();
    this.permissoesAdministrador.addAll(permissoes);
  }


  /**
   * Verifica se o Adm possui uma permissão especial específica
   *
   * @param permissao permissão a ser verificada
   *
   * @return boolean true: possui; false: não possui
   */
  public boolean possuiPermissao(PermissaoEspecial permissao) {
      return permissoesAdministrador.contains(permissao);
  }


  /**
   * Retorna a lista de permissões de um Administrador
   *
   * @return List<PermissaoEspecial> lista de permissões
   * */
  public List<PermissaoEspecial> getPermissoes() {
    return this.permissoesAdministrador;
  }


  /**
   * Adiciona uma permissão na lista de permissões do Administrador
   *
   * @param permissao permissão a ser adicionada
   */
  public void adicionarPermissao(PermissaoEspecial permissao) {
      this.permissoesAdministrador.add(permissao);
  }


  /**
   * Remove uma permissão na lista de permissões do Administrador
   *
   * @param permissao permissão a ser adicionada
   */
  public void removerPermissao(PermissaoEspecial permissao) {
      this.permissoesAdministrador.remove(permissao);
  }
}
