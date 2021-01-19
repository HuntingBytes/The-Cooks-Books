package com.cooksbooks.utils;

public enum Categoria {

    NENHUMA("Sem Categoria"),
    REGIONAL("Regional"),
    ITALIANA("Italiana"),
    PIZZA("Pizza"),
    HAMBURGUER("Hambúrguer"),
    DOCE("Doce"),
    FRUTO_MAR("Frutos do Mar"),
    MASSAS("Massas"),
    VEGETARIANA("Vegetariana"),
    BOLO("Bolo"),
    TORTA("Torta"),
    SOPA("Sopa"),
    PAO("Pão"),
    OMELETE("Omelete"),
    TAPIOCA("Tapioca"),
    CREPE("Crepe"),
    CARNE_BOVINA("Carne Bovina"),
    PORCO("Porco"),
    SALADA("Salada"),
    FRANGO("Frango"),
    LASANHA("Lasanha"),
    MILKSHAKE("Milkshake"),
    MOUSSE("Mousse"),
    SANDUICHE("Sanduiche"),
    BISCOITO("Biscoito"),
    SORVETE("Sorvete"),
    BEBIDAS("Bebidas"),
    SUCO("Suco"),
    FESTA("Receitas de Festa"),
    CHINESA("Chinesa"),
    JAPONESA("Japonesa"),
    FRANCESA("Francesa");

    private final String extenso;

    Categoria(String extenso){
        this.extenso = extenso;
    }

    @Override

    public String toString(){
        return this.extenso;
    }
}
