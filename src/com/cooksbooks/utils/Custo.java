package com.cooksbooks.utils;

public enum Custo {

    BARATO("$", 0.0, 20.0),
    MODERADO("$$", 20.0, 50),
    CARO("$$$", 500, Double.POSITIVE_INFINITY);

    private final String extenso;
    private final double valorMin;
    private final double valorMax;

    Custo(String extenso, double valorMin, double valorMax) {
        this.extenso = extenso;
        this.valorMin = valorMin;
        this.valorMax = valorMax;
    }


    /**
     * Retorna uma String com os intervalos dos preços
     *
     * */
    public String imprimeIntervaloDePreco() {
        return String.format("%.2f - %.2f", valorMin, valorMax);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.extenso, this.imprimeIntervaloDePreco());
    }

}
