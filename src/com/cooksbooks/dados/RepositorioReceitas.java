package com.cooksbooks.dados;

import com.cooksbooks.dados.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.Receita;

import java.io.*;
import java.util.ArrayList;

public class RepositorioReceitas implements IRepositorioReceita {

    private static RepositorioReceitas instancia;
    private ArrayList<Receita> receitasList;

    private RepositorioReceitas(){
        this.receitasList = new ArrayList<>(100);
    }

    public static RepositorioReceitas getInstancia(){
        if(RepositorioReceitas.instancia == null){
            RepositorioReceitas.instancia = RepositorioReceitas.lerArquivo();
        }
        return RepositorioReceitas.instancia;
    }

    private static RepositorioReceitas lerArquivo() {
        RepositorioReceitas instanciaLocal;

        File in = new File("usuarios.dat");
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioReceitas) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioReceitas();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }

        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (RepositorioReceitas.instancia == null) {
            return;
        }
        File out = new File("usuarios.dat");
        FileOutputStream fos;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(RepositorioReceitas.instancia);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    /* Silent */}
            }
        }
    }

    //TODO: decidir assinatura do método(provavelmente recebe o ID da receita)
    @Override
    public boolean existeReceita(Receita receitaAlvo){
        for(Receita r : receitasList){
            if(r.getTitulo().equals(receitaAlvo.getTitulo())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void cadastrarReceita(Receita receita){
        this.receitasList.add(receita);
    }

    @Override
    public void removerReceita(Receita receitaAlvo){
        this.receitasList.remove(receitaAlvo);
    }

    @Override
    public Receita buscarReceita(Receita receitaAlvo){
        for(Receita r : receitasList){
            if(r.getTitulo().equals(receitaAlvo.getTitulo())){
                return r;
            }
        }
        return null;
    }

    private long totalReceitas(){
        return receitasList.size();
    }
}
