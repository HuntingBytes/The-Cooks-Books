package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;


public interface IRepositorioUsuario {

    void salvarArquivo();

    boolean existeUsuario(String usuarioExiste);

    void cadastrarUsuario(Usuario usuarioAdd);

    void removerUsuario(String usuarioRemove);

    Usuario buscarUsuario(String usuarioBuscar);

    int totalUsuarios();

    void atualizarNomeUsuarioExistente(String idUsuarioExistente, String nomePerfilNovo);

    void atualizarBiografiaUsuarioExistente(String idUsuarioExistente, String biografiaPerfilNovo);

    void alterarNomePerfil(String login, String nomePerfil);

    void alterarBiografia(String login, String biografia);

    void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil);

    void alterarExperienciaCulinaria(String login, ExperienciaCulinaria experienciaCulinaria);
}
