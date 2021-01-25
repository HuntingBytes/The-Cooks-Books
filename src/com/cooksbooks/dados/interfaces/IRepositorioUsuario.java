package com.cooksbooks.dados.interfaces;

import com.cooksbooks.entity.Usuario;


public interface IRepositorioUsuario {

    void salvarArquivo();

    boolean existeUsuario(String usuarioExiste);

    void cadastrarUsuario(String usuarioAdd);

    void removerUsuario(String usuarioRemove);

    Usuario buscarUsuario(String usuarioBuscar);

    void totalUsuario();

    void atualizarNomeUsuarioExistente(String idUsuarioExistente, String nomePerfilNovo);

    void atualizarBiografiaUsuarioExistente(String idUsuarioExistente, String biografiaPerfilNovo);

    void alterarNomePerfil(String login, String nomePerfil);

    void alterarBiografia(String login, String biografia);

    void alterarExperiencia(String login, ExperienciaCulinaria experienciaCulinaria);

    void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil);

}
