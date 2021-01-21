package com.cooksbooks.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class Nota {

    Map<String, Integer> votos = new HashMap<String, Integer>();

    nota () {
        
    }


    //Método aparentemente ok
    public boolean jaVotou(String nomeUsuario)
    {
        //if que compara o valor da Map com Null para determinar se Ja votou
        if(entry.getValue(nomeUsuario) != null){
            return true;
        }

        return false;
        
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

        for(Map.Entry<String, Integer> entry : votos.entrySet())
        {
            somaNotas = somaNotas + entry.getValue();
            i++;
        }

        mediaNotas = somaNotas/i;
        return mediaNotas;
    }

    //Não sei se necessariamente se acessa a Key corretamente
    @Override
    public String toString(String nomeKey) {
        return "Usuário " + entry.getKey(nomeKey) + "\tNota: " + entry.getValue(nomeKey);
    }

}