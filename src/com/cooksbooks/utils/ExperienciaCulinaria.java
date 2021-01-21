package com.cooksbooks.utils;

import java.lang.annotation.Documented;

public enum ExperienciaCulinaria {

    INICIANTE("Iniciante"),
    NOVATO("Novato"),
    INTERMEDIARIO("Intermediário"),
    CASEIRO("Cozinheiro Caseiro"),
    PROFISSIONAL("Cozinheiro Profissional");

    private final String extenso;

    ExperienciaCulinaria(String extenso){
        this.extenso = extenso;
    }

    @Override

    public String toString(){
        return this.extenso;
    }
}
