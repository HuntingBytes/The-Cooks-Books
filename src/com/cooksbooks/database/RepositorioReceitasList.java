package com.cooksbooks.database;

import com.cooksbooks.database.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.Receita;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioReceitasList implements IRepositorioReceita, Serializable {

  @Serial
  private static final long serialVersionUID = 3083784819719029704L;
  private static RepositorioReceitasList instancia;

  private final ArrayList<Receita> receitasList;

  private RepositorioReceitasList() {
    this.receitasList = new ArrayList<>(100);
  }

  public static RepositorioReceitasList getInstancia() {
    if (RepositorioReceitasList.instancia == null) {
      RepositorioReceitasList.instancia = RepositorioReceitasList.lerArquivo();
    }
    return RepositorioReceitasList.instancia;
  }

  private static RepositorioReceitasList lerArquivo() {
    RepositorioReceitasList instanciaLocal;

    File in = new File("receitas.dat");
    FileInputStream fis;
    ObjectInputStream ois = null;
    try {
      fis = new FileInputStream(in);
      ois = new ObjectInputStream(fis);
      Object o = ois.readObject();
      instanciaLocal = (RepositorioReceitasList) o;
    } catch (Exception e) {
      instanciaLocal = new RepositorioReceitasList();
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
    if (RepositorioReceitasList.instancia == null) {
      return;
    }
    File out = new File("receitas.dat");
    FileOutputStream fos;
    ObjectOutputStream oos = null;

    try {
      fos = new FileOutputStream(out);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(RepositorioReceitasList.instancia);
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

  //TODO: decidir assinatura do método(provavelmente recebe o ID da receita)
  @Override
  public boolean existeReceita(String idReceita) {
    for (Receita r : receitasList) {
      if (r.getIdReceita().equals(idReceita)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void cadastrarReceita(Receita receita) {
    this.receitasList.add(receita);
  }

  @Override
  public void removerReceita(String idReceita) {
    receitasList.removeIf(r -> r.getTitulo().equals(idReceita));
  }

  @Override
  public Receita buscarReceita(String idReceita) {
    for (Receita r : receitasList) {
      if (r.getTitulo().equals(idReceita)) {
        return r;
      }
    }
    return null;
  }

  public long totalReceitas() {
    return receitasList.size();
  }

  @Override
  public void alterarTituloReceita(String idReceitaExistente, String novoTituloReceita) {
    for (Receita r : receitasList) {
      if (r.getTitulo().equals(idReceitaExistente)) {
        r.setTitulo(novoTituloReceita);
        break;
      }
    }
  }

  @Override
  public void alterarModoPreparoReceita(String idReceitaExistente, String novoModoPreparo) {
    for (Receita r : receitasList) {
      if (r.getTitulo().equals(idReceitaExistente)) {
        r.setModoPreparo(novoModoPreparo);
        break;
      }
    }
  }

  @Override
  public List<Receita> listarReceitasCaderno(String idCaderno) {
    List<Receita> receitasCaderno = new ArrayList<>();
    for (Receita r : this.receitasList) {
      if (r.getIdCadernoDono().equals(idCaderno)) {
        receitasCaderno.add(r);
      }
    }
    return receitasCaderno;
  }
}
