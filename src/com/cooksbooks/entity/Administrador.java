package com.cooksbooks.entity;

import com.cooksbooks.utils.PermissaoEspecial;

import java.util.List;

public class Administrador extends Perfil{

    public Administrador(String login, String senha){

    }
    public Administrador(String login, String senha, List<PermissaoEspecial> permissoes){

    }

    public boolean possuiPermissao(PermissaoEspecial permissao){
        return false;
    }

    public List<PermissaoEspecial> getPermissoes(){
        return null;
    }

    public void adicionarPermissao(PermissaoEspecial permissao){

    }
    public void removerPermissao(PermissaoEspecial permissao){

    }

}
