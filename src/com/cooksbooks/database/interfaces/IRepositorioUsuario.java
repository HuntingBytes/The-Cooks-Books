package com.cooksbooks.database.interfaces;

import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;


public interface IRepositorioUsuario {

    void salvarArquivo();

    boolean existeUsuario(String usuarioExiste);

    void cadastrarUsuario(Usuario usuarioAdd);

    // throws UsuarioInexistente
    void removerUsuario(String usuarioRemove);

    // throws UsuarioInexistente
    Usuario buscarUsuario(String usuarioBuscar);

    int totalUsuarios();

    // throws UsuarioInexistente
    void atualizarNomeUsuarioExistente(String idUsuarioExistente, String nomePerfilNovo);

    // throws UsuarioInexistente
    void atualizarBiografiaUsuarioExistente(String idUsuarioExistente, String biografiaPerfilNovo);

    // throws UsuarioInexistente
    void alterarNomePerfil(String login, String nomePerfil);

    // throws UsuarioInexistente
    void alterarBiografia(String login, String biografia);

    // throws UsuarioInexistente
    void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil);

    // throws UsuarioInexistente
    void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria);
}
