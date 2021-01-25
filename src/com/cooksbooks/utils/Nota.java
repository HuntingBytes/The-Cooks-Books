package com.cooksbooks.utils;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Nota implements Serializable {

    @Serial
    private static final long serialVersionUID = 6132471158911713844L;
    Map<String, Integer> votos;

    Nota () {
        this.votos = new HashMap<>();
    }


    //Método aparentemente ok
    public boolean jaVotou(String nomeUsuario) {
        return (this.votos.get(nomeUsuario) != null);
    }

    //Método aparentemente simples e ok
    public void adicionarNota(String nomeUsuario, Integer nota) {
        votos.put(nomeUsuario, nota);
    }

    //Tenho dúvidas do funcionamento desse método, preciso teste;
    public int notaMedia(){

        int somaNotas = 0;
        int mediaNotas = 0;
        int i = 0;

        for(Integer value : votos.values())
        {
            somaNotas += value;
            i++;
        }

        mediaNotas = somaNotas/i;
        return mediaNotas;
    }

    //Não sei se necessariamente se acessa a Key corretamente
    @Override
    public String toString() {
        return "";
    }

}