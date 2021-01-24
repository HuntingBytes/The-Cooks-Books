package com.cooksbooks.utils;

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
        return String.format("O nível de Dificuldade é %s", this.extenso);
    }
}
