package com.cooksbooks.entity.utils;

import java.io.Serial;
import java.io.Serializable;

public class Ingrediente implements Serializable {

  @Serial
  private static final long serialVersionUID = -8963710666822889681L;

  private String nome;
  private int quantidade;
  private double valorUnitario;

  public Ingrediente(String nome, int quantidade, double valorUnitario) {
    this.nome = nome;
    this.quantidade = quantidade;
    this.valorUnitario = valorUnitario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  @Override
  public String toString() {
    return String.format("%s - %d", this.nome, this.quantidade);
  }
}