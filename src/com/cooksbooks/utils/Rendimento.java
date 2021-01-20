package com.cooksbooks.utils;

public enum Rendimento {

    UM("1 pessoa"),
    DOIS("2 pessoas"),
    QUATRO("4 pessoas"),
    SEIS("6 pessoas"),
    OITO("8 pessoas"),
    MUITAS("Mais de 10 pessoas");

    private String extenso;

    Rendimento(String extenso) {
        this.extenso=extenso;
    }

    public String getExtenso() {
        return extenso;
    }

    public void setExtenso(String extenso) {
        this.extenso = extenso;
    }

    @Override
    public String toString() {
        return this.extenso;
    }
}
