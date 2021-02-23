package com.cooksbooks.database;

import com.cooksbooks.database.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.exceptions.UsuarioInexistente;
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
    this.receitasList = new ArrayList<>();
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
      if (r.getIdReceita().equals(idReceita)) {
        return r;
      }
    }
    return null;
  }

  @Override
  public void alterarTituloReceita(String idReceitaExistente, String novoTituloReceita) {
    Receita receita = this.buscarReceita(idReceitaExistente);
    receita.setTitulo(novoTituloReceita);
  }

  @Override
  public void alterarModoPreparoReceita(String idReceitaExistente, String novoModoPreparo) {
    Receita receita = this.buscarReceita(idReceitaExistente);
    receita.setModoPreparo(novoModoPreparo);
  }

  @Override
  public void alterarCusto(String idReceita, Custo custo) {
    Receita receita = this.buscarReceita(idReceita);
    receita.setCusto(custo);
  }

  @Override
  public void alterarRendimento(String idReceita, Rendimento rendimento) {
    Receita receita = this.buscarReceita(idReceita);
    receita.setRendimento(rendimento);
  }

  @Override
  public void alterarDificuldade(String idReceita, Dificuldade dificuldade) {
    Receita receita = this.buscarReceita(idReceita);
    receita.setDificuldade(dificuldade);
  }

  @Override
  public void adicionarCategoria(String idReceita, Categoria categoria) {
    Receita receita = this.buscarReceita(idReceita);
    receita.adicionarCategoria(categoria);
  }

  @Override
  public void removerCategoria(String idReceita, Categoria categoria) {
    Receita receita = this.buscarReceita(idReceita);
    receita.removerCategoria(categoria);
  }

  @Override
  public void adicionarIngrediente(String idReceita, Ingrediente ingrediente) {
    Receita receita = this.buscarReceita(idReceita);
    receita.adicionarIngrediente(ingrediente);
  }

  @Override
  public void removerIngrediente(String idReceita, Ingrediente ingrediente) {
    Receita receita = this.buscarReceita(idReceita);
    receita.removerIngrediente(ingrediente);
  }

  @Override
  public void alterarReceita(String idReceita, Receita novaReceita) {
    int index = getIndex(idReceita);
    this.receitasList.set(index, novaReceita);
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

  public long totalReceitas() {
    return receitasList.size();
  }

  private int getIndex(String idReceita) {
    for (int i = 0; i < this.receitasList.size(); i++) {
      if (this.receitasList.get(i).getIdReceita().equals(idReceita)) {
        return i;
      }
    }
    return -1;
  }
}
