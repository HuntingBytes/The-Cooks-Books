package com.cooksbooks.utils;

public enum Dificuldade {

    FACIL("Fácil", 1),
    MEDIO("Médio", 2),
    DIFICIL("Difícil", 3);

    private String extenso;
    private int peso;

    Dificuldade(String extenso, int peso) {
        this.extenso = extenso;
        this.peso = peso;
    }

    public String getExtenso() {
        return extenso;
    }

    public void setExtenso(String extenso) {
        this.extenso = extenso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("O nível de Dificuldade é %s", this.extenso);
    }
}
