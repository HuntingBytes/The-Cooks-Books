package com.cooksbooks.entity.utils;

import java.util.List;

public enum TempoPreparo {

    RAPIDO("Até 30 minutos"),
    MEDIO("Entre 30 minutos e 1 hora"),
    DEMORADO("Mais de 1 hora");

    private final String extenso;

    TempoPreparo(String extenso) {
        this.extenso = extenso;
    }
    
    @Override
    public String toString(){
        return this.extenso;
    }

    public static TempoPreparo tempoPreparoMedio(List<TempoPreparo> tempoPreparo) {
        return TempoPreparo.MEDIO;
    }

}
