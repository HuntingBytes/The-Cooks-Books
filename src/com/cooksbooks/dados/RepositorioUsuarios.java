package com.cooksbooks.dados;

import com.cooksbooks.dados.interfaces.IRepositorioUsuario;
import com.cooksbooks.entity.Usuario;

import java.io.*;
import java.util.ArrayList;

public class RepositorioUsuarios implements IRepositorioUsuario {

    private static RepositorioUsuarios instancia;
    private final ArrayList<Usuario> usuariosList;
    //TODO: estudar SERIALIZABLE kkkkkkkkkkk a bronca

    /**
     * Construtor do repositório que inicializa o ArrayList de usuários
     */
    private RepositorioUsuarios(){
        this.usuariosList = new ArrayList<>(100);
    }

    /**
     *
     * @return  instancia do RepositorioUsuario
     */
    public static RepositorioUsuarios getInstancia(){
        if(RepositorioUsuarios.instancia == null){
            RepositorioUsuarios.instancia = RepositorioUsuarios.lerArquivo();
        }

        return RepositorioUsuarios.instancia;
    }

    /**
     * Copiei na cara dura mesmo. kkkkkkkk
     * TODO: estudar como esse método funciona
     * @return
     */
    private static RepositorioUsuarios lerArquivo() {
        RepositorioUsuarios instanciaLocal;

        File in = new File("usuarios.dat");
        FileInputStream fis;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioUsuarios) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioUsuarios();
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

    /**
     * Outra cópia na cara dura.
     * TODO: estudar isso também (apesar de ser a mesma coisa que o método anterior)
     */
    @Override
    public void salvarArquivo() {
        if (RepositorioUsuarios.instancia == null) {
            return;
        }
        File out = new File("usuarios.dat");
        FileOutputStream fos;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(RepositorioUsuarios.instancia);
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


    @Override
    public boolean existeUsuario(Usuario usuario){
        for(Usuario u : usuariosList){
            if (u.getLogin().equals(usuario.getLogin())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void cadastrarUsuario(Usuario usuario){
        this.usuariosList.add(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario){
        for(Usuario u : usuariosList){
            if(u.getLogin().equals(usuario.getLogin())){
                this.usuariosList.remove(u);
                break;
            }
        }
    }

    @Override
    public Usuario buscarUsuario (Usuario usuarioAlvo){
        for(Usuario u : usuariosList){
            if(u.getLogin().equals(usuarioAlvo.getLogin())){
                return u;
            }
        }
        return null;
    }

    @Override
    public int totalUsuarios(){
        return usuariosList.size();
    }

}
