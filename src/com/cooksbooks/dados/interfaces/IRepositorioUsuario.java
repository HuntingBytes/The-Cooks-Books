package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Usuario;
import java.util.List;

public interface IRepositorioUsuario {

    void salvarArquivo();

    boolean existeUsuario(Usuario usuarioExiste);

    void cadastrarUsuario(Usuario usuarioAdd);

    void removerUsuario(Usuario usuarioRemove);

    Usuario buscarUsuario(Usuario usuarioBuscar);

}
