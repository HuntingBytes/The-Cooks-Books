package com.cooksbooks.utils;

public enum TempoPreparo {

    RAPIDO("Até 30 minutos", 1),
    MEDIO("Entre 30 minutos e 1 hora", 2),
    DEMORADO("Mais de 1 hora", 3),

    private final String extenso;
    private final int peso;

    TempoPreparo(String extenso, int peso) {
        this.extenso = extenso;
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
    
    @Override
    public String toString(){
        return "Categoria " + this.extenso + "\tPeso " + this.peso + tempoPreparoMedio ;
    }

    public TempoPreparo tempoPreparoMedio(List<tempoPreparo> tempoPreparo)
    {    
        for(int i = 0; i < tempoPreparo.size(); i++)
        {
            TempoPreparo tempoTotal = tempoTotal + tempoPreparo.get(i);
        }

        return tempoTotal/tempoPreparo.size();
    }

}
