package com.cooksbooks.utils;

public enum Custo {

    BARATO("$", 0.0, 20.0, 1),
    MODERADO("$$", 20.0, 50, 2),
    CARO("$$$", 500, Double.POSITIVE_INFINITY, 3);

    private String extenso;
    private double valorMin;
    private double valorMax;
    private int peso;

    Custo(String extenso, double valorMin, double valorMax, int peso) {
        this.extenso = extenso;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }


    public String getIntervaloDePreco() {
        return String.format("%.2f - %.2f", valorMin, valorMax);
    }
}
