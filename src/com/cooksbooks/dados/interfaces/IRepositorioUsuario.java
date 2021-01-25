package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Usuario;
import java.util.List;

public interface IRepositorioUsuario {

    void salvarArquivo();

    boolean existeUsuario(String usuarioExiste);

    void cadastrarUsuario(String usuarioAdd);

    void removerUsuario(String usuarioRemove);

    Usuario buscarUsuario(String usuarioBuscar);

    void totalUsuario();

    void atualizarNomeUsuarioExistente(String idUsuarioExistente, String nomePerfilNovo);

    void atualizarBiografiaUsuarioExistente(String idUsuarioExistente, String biografiaPerfilNovo);

}
