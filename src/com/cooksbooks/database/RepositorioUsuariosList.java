package com.cooksbooks.database;

import com.cooksbooks.database.interfaces.IRepositorioUsuario;
import com.cooksbooks.entity.Usuario;
import com.cooksbooks.entity.utils.ExperienciaCulinaria;
import com.cooksbooks.exceptions.UsuarioInexistente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuariosList implements IRepositorioUsuario, Serializable {

  @Serial
  private static final long serialVersionUID = 1765430802666531944L;
  private static RepositorioUsuariosList instancia;

  private final List<Usuario> usuariosList;

  /**
   * Construtor do repositório que inicializa o ArrayList de usuários
   */
  private RepositorioUsuariosList() {
    this.usuariosList = new ArrayList<>();
  }

  public static RepositorioUsuariosList getInstancia() {
    if (RepositorioUsuariosList.instancia == null) {
      RepositorioUsuariosList.instancia = RepositorioUsuariosList.lerArquivo();
    }

    return RepositorioUsuariosList.instancia;
  }

  private static RepositorioUsuariosList lerArquivo() {
    RepositorioUsuariosList instanciaLocal;

    File in = new File("usuarios.dat");
    FileInputStream fis;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(in);
      ois = new ObjectInputStream(fis);
      Object o = ois.readObject();
      instanciaLocal = (RepositorioUsuariosList) o;
    } catch (Exception e) {
      instanciaLocal = new RepositorioUsuariosList();
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
    if (RepositorioUsuariosList.instancia == null) {
      return;
    }
    File out = new File("usuarios.dat");
    FileOutputStream fos;
    ObjectOutputStream oos = null;

    try {
      fos = new FileOutputStream(out);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(RepositorioUsuariosList.instancia);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          /* Silent */
        }
      }
    }
  }

  @Override
  public boolean existeUsuario(String idUsuario) {
    for (Usuario u : usuariosList) {
      if (u.getLogin().equals(idUsuario)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void cadastrarUsuario(Usuario usuario) {
    this.usuariosList.add(usuario);
  }

  @Override
  public void removerUsuario(String idUsuario) throws UsuarioInexistente {
    if (!usuariosList.removeIf(u -> u.getLogin().equals(idUsuario))) {
      throw new UsuarioInexistente(idUsuario);
    }
  }

  @Override
  public Usuario buscarUsuario(String idUsuario) throws UsuarioInexistente {
    for (Usuario u : usuariosList) {
      if (u.getLogin().equals(idUsuario)) {
        return u;
      }
    }
    throw new UsuarioInexistente(idUsuario);
  }

  @Override
  public void alterarNomePerfil(String login, String nomePerfil) throws UsuarioInexistente {
    Usuario u = this.buscarUsuario(login);
    u.setNomePerfil(nomePerfil);
  }

  @Override
  public void alterarBiografia(String login, String biografia) throws UsuarioInexistente {
    Usuario u = this.buscarUsuario(login);
    u.setBiografia(biografia);
  }

  @Override
  public void alterarCaminhoImagemPerfil(String login, String caminhoImagemPerfil)
      throws UsuarioInexistente {
    Usuario u = this.buscarUsuario(login);
    u.setCaminhoImagemPerfil(caminhoImagemPerfil);
  }

  @Override
  public void alterarExperienciaCulinaria(String login,
      ExperienciaCulinaria experienciaCulinaria) throws UsuarioInexistente {
    Usuario u = this.buscarUsuario(login);
    u.setExperienciaCulinaria(experienciaCulinaria);
  }

  @Override
  public void alterarUsuario(String login, Usuario novoUsuario) throws UsuarioInexistente {
    int index = getIndex(login);
    this.usuariosList.set(index, novoUsuario);
  }

  @Override
  public int totalUsuariosEntre(LocalDateTime inicio, LocalDateTime fim) {
    int total = 0;
    for (Usuario u : this.usuariosList) {
      LocalDateTime dataCriacao = u.getDataCriacao();
      if (dataCriacao.isBefore(fim) && dataCriacao.isAfter(inicio)) {
        total++;
      }
    }
    return total;
  }

  @Override
  public int totalUsuarios() {
    return usuariosList.size();
  }

  private int getIndex(String login) throws UsuarioInexistente {
    for (int i = 0; i < this.usuariosList.size(); i++) {
      if (this.usuariosList.get(i).getLogin().equals(login)) {
        return i;
      }
    }
    throw new UsuarioInexistente(login);
  }
}
