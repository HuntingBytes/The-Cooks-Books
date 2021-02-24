package com.cooksbooks.controllers;

import com.cooksbooks.database.RepositorioReceitasList;
import com.cooksbooks.database.interfaces.IRepositorioReceita;
import com.cooksbooks.entity.Receita;
import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.entity.utils.Rendimento;
import java.util.List;

public class ControladorReceita {

  private static ControladorReceita instancia;

  private final IRepositorioReceita repositorioReceitas;

  /**
   * Construtor de ControladorReceita
   * <p>
   * Receberá a instância para o repositório de Receitas.
   */
  public ControladorReceita() {
    this.repositorioReceitas = RepositorioReceitasList.getInstancia();
  }

  /**
   * Copiei esse método de Gabriel e sinto que essa foi a minha maior vigarice.
   *
   * @return a instancia criada
   */
  public static ControladorReceita getInstancia() {
    if (instancia == null) {
      instancia = new ControladorReceita();
    }
    return instancia;
  }

  /**
   * Crud - Create
   *
   * @param receita Receita.
   */
  public void cadastrarReceita(Receita receita) {
    receita.setIdReceita(String
        .format("%s-%d", receita.getIdCadernoDono(), this.repositorioReceitas.totalReceitas()));
    if (!this.repositorioReceitas.existeReceita(receita.getIdReceita())) {
      if (this.isReceitaValida(receita)) {
        this.repositorioReceitas.cadastrarReceita(receita);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  /**
   * Crud - Delete
   *
   * @param idReceita id da Receita.
   */
  public void removerReceita(String idReceita) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      this.repositorioReceitas.removerReceita(idReceita);
      this.repositorioReceitas.salvarArquivo();
    }
  }

  /**
   * Crud - Read
   *
   * @param idReceita
   * @return Receita buscada pelo usuário
   */
  public Receita buscarReceita(String idReceita) {
    return this.repositorioReceitas.buscarReceita(idReceita);
  }

  public List<Receita> buscarReceitasComTitulo(String titulo) {
    titulo = titulo.trim();
    return this.repositorioReceitas.buscarReceitasComTitulo(titulo);
  }

  /**
   * Crud - Update (Título da Receita)
   *
   * @param idReceitaExistente
   * @param novoTituloReceita
   */
  public void alterarTituloReceita(String idReceitaExistente, String novoTituloReceita) {
    if (this.repositorioReceitas.existeReceita(idReceitaExistente)) {
      if (this.isTituloValido(novoTituloReceita)) {
        this.repositorioReceitas.alterarTituloReceita(idReceitaExistente, novoTituloReceita);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  /**
   * Crud - Update (Modo de Preparo)
   *
   * @param idReceitaExistente
   * @param novoModoPreparo
   */
  public void alterarModoPreparoReceita(String idReceitaExistente, String novoModoPreparo) {
    if (this.repositorioReceitas.existeReceita(idReceitaExistente)) {
      if (this.isModoPreparoValido()) {
        this.repositorioReceitas.alterarModoPreparoReceita(idReceitaExistente, novoModoPreparo);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  void alterarCusto(String idReceita, Custo custo) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (custo != null) {
        this.repositorioReceitas.alterarCusto(idReceita, custo);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  void alterarRendimento(String idReceita, Rendimento rendimento) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (rendimento != null) {
        this.repositorioReceitas.alterarRendimento(idReceita, rendimento);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  void alterarDificuldade(String idReceita, Dificuldade dificuldade) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (dificuldade != null) {
        this.repositorioReceitas.alterarDificuldade(idReceita, dificuldade);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  void adicionarCategoria(String idReceita, Categoria categoria) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (categoria != null && !this.buscarReceita(idReceita).listarCategorias()
          .contains(categoria)) {
        this.repositorioReceitas.adicionarCategoria(idReceita, categoria);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  void removerCategoria(String idReceita, Categoria categoria) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (categoria != null && this.buscarReceita(idReceita).listarCategorias()
          .contains(categoria)) {
        this.repositorioReceitas.removerCategoria(idReceita, categoria);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  public void adicionarIngrediente(String idReceita, Ingrediente ingrediente) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (isIngredienteValido() && !this.buscarReceita(idReceita).listarIngredientes()
          .contains(ingrediente)) {
        // Rever o método equals() de ingrediente!
        this.repositorioReceitas.adicionarIngrediente(idReceita, ingrediente);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  public void removerIngrediente(String idReceita, Ingrediente ingrediente) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (isIngredienteValido() && this.buscarReceita(idReceita).listarIngredientes()
          .contains(ingrediente)) {
        // Rever o método equals() de ingrediente!
        this.repositorioReceitas.removerIngrediente(idReceita, ingrediente);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  void alterarReceita(String idReceita, Receita novaReceita) {
    if (this.repositorioReceitas.existeReceita(idReceita)) {
      if (isReceitaValida(novaReceita)) {
        this.repositorioReceitas.alterarReceita(idReceita, novaReceita);
        this.repositorioReceitas.salvarArquivo();
      }
    }
  }

  public List<Receita> listarReceitas(String idCaderno) {
    return repositorioReceitas.listarReceitasCaderno(idCaderno);
  }

  private boolean isReceitaValida(Receita receita) {
    return true;
  }

  private boolean isTituloValido(String titulo) {
    return true;
  }

  private boolean isModoPreparoValido() {
    return true;
  }

  private boolean isIngredienteValido() {
    return true;
  }
}
