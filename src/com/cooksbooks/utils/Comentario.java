package com.cooksbooks.utils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comentario {

    private String texto;
    private LocalDateTime data;
    private String nomeUsuario;
    private String nomePerfil;

    public Comentario(String texto, LocalDateTime data, String nomeUsuario, String nomePerfil) {
        this.texto = texto;
        this.data = data;
        this.nomeUsuario = nomeUsuario;
        this.nomePerfil = nomePerfil;
    }

    public void editarTexto (String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentário: " + texto + "\n" + "Data: " + data + "\n" + "Usuário: " + nomeUsuario + "\n" + "Perfil: " + nomePerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comentario)) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(texto, that.texto) && Objects.equals(data, that.data) && Objects.equals(nomeUsuario, that.nomeUsuario) && Objects.equals(nomePerfil, that.nomePerfil);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
}
