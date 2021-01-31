package com.cooksbooks.entity.utils;

public enum Dificuldade {

    FACIL("Fácil"),
    MEDIO("Médio"),
    DIFICIL("Difícil");

    private final String extenso;

    Dificuldade(String extenso) {
        this.extenso = extenso;
    }

    @Override
    public String toString() {
        return String.format("%s", this.extenso);
    }
}
