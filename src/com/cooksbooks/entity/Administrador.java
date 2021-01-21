package com.cooksbooks.entity;

import com.cooksbooks.utils.PermissaoEspecial;
import java.util.List;

public class Administrador extends Usuario {

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

  public boolean possuiPermissao(PermissaoEspecial permissao) {
      return permissoesAdministrador.contains(permissao);
  }

  public List<PermissaoEspecial> getPermissoes() {
    return this.permissoesAdministrador;
  }

  public void adicionarPermissao(PermissaoEspecial permissao) {
    if (!permissoesAdministrador.contains(permissao)) {
      this.permissoesAdministrador.add(permissao);
    }
  }

  public void removerPermissao(PermissaoEspecial permissao) {
    if (permissoesAdministrador.contains(permissao)) {
      this.permissoesAdministrador.remove(permissao);
    }
  }


}
