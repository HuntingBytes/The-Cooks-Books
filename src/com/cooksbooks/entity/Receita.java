package com.cooksbooks.entity;

import com.cooksbooks.entity.utils.Categoria;
import com.cooksbooks.entity.utils.Comentario;
import com.cooksbooks.entity.utils.Custo;
import com.cooksbooks.entity.utils.Dificuldade;
import com.cooksbooks.entity.utils.Ingrediente;
import com.cooksbooks.entity.utils.Rendimento;
import com.cooksbooks.entity.utils.TempoPreparo;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A Classe Receita é responsável por representar uma receita no sistema.
 * <p>
 * Ela possui diversos campos que a caracterizam e métodos para acessar e atualizar esses campos.
 * </p>
 *
 * @version 1.0
 */
public class Receita implements Serializable {

  @Serial
  private static final long serialVersionUID = 2272177332565838189L;

  private String titulo;
  private String modoPreparo;
  private String idReceita;
  private String idCadernoDono;
  private TempoPreparo tempoPreparo;
  private Custo custo;
  private Rendimento rendimento;
  private Dificuldade dificuldade;
  private List<Categoria> categorias;
  private List<Ingrediente> ingredientes;
  private List<Comentario> comentarios;
  private List<String> caminhosImagens;

  /**
   * Construtor nulo. Inicializa os campos com valores padrões.
   * <p>
   * Valores padrão:
   * </p>
   * <ul>
   * <li>
   * Custo.BARATO; Rendimento.UM; Dificuldade.FACIL; TempoPreparo.RAPIDO;
   * </li>
   * <li>
   * Listas são inicializadas sem elementos;
   * </li>
   * <li>
   * Strings são inicializadas como "".
   * </li>
   * </ul>
   */
  public Receita() {
    this.titulo = "";
    this.modoPreparo = "";
    this.idReceita = "";
    this.idCadernoDono = "";
    this.custo = Custo.BARATO;
    this.rendimento = Rendimento.UM;
    this.dificuldade = Dificuldade.FACIL;
    this.tempoPreparo = TempoPreparo.RAPIDO;
    this.categorias = new ArrayList<>();
    this.ingredientes = new ArrayList<>();
    this.comentarios = new ArrayList<>();
    this.caminhosImagens = new ArrayList<>();
  }

  /**
   * Construtor que recebe um titulo. Demais elementos são inicializados com os valores padrões.
   *
   * @param titulo o título da receita.
   */
  public Receita(String titulo) {
    this();
    this.titulo = titulo;
  }

  /**
   * Função para uso interno, só deve ser utilizada para debug. Realiza algumas operações com a
   * classe e imprime no console.
   */
  public static void debug() {
    Receita receita = new Receita();
    System.out.println(receita);
  }

  /**
   * Retorna o título da receita.
   *
   * @return String do título da receita.
   */
  public String getTitulo() {
    return this.titulo;
  }

  /**
   * Define o título da receita.
   *
   * @param titulo título da receita.
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * Retorna o id da receita.
   *
   * @return id da receita.
   */
  public String getIdReceita() {
    return this.idReceita;
  }

  /**
   * Define o id da receita.
   *
   * @param idReceita id da receita.
   */
  public void setIdReceita(String idReceita) {
    this.idReceita = idReceita;
  }

  public String getIdCadernoDono() {
    return this.idCadernoDono;
  }

  /**
   * Define o id do caderno que possui a receita.
   *
   * @param idCadernoDono id do caderno que possui a receita.
   */
  public void setIdCadernoDono(String idCadernoDono) {
    this.idCadernoDono = idCadernoDono;
  }

  /**
   * Retorna o modo de preparo da receita.
   *
   * @return String do modo de preparo da receita.
   */
  public String getModoPreparo() {
    return this.modoPreparo;
  }

  /**
   * Define o modo de preparo da receita.
   *
   * @param modoPreparo modo de preparo da receita.
   */
  public void setModoPreparo(String modoPreparo) {
    this.modoPreparo = modoPreparo;
  }

  /**
   * Retorna o custo da receita.
   *
   * @return Custo da receita.
   */
  public Custo getCusto() {
    return this.custo;
  }

  /**
   * Define o custo da receita.
   *
   * @param custo custo da receita.
   */
  public void setCusto(Custo custo) {
    this.custo = custo;
  }

  /**
   * Retorna o rendimento da receita.
   *
   * @return Rendimento da receita.
   */
  public Rendimento getRendimento() {
    return this.rendimento;
  }

  /**
   * Define o rendimento da receita.
   *
   * @param rendimento Rendimento da receita.
   */
  public void setRendimento(Rendimento rendimento) {
    this.rendimento = rendimento;
  }

  /**
   * Retorna a dificuldade da receita.
   *
   * @return Dificuldade da receita.
   */
  public Dificuldade getDificuldade() {
    return this.dificuldade;
  }

  /**
   * Define a dificuldade da receita.
   *
   * @param dificuldade Dificuldade da receita.
   */
  public void setDificuldade(Dificuldade dificuldade) {
    this.dificuldade = dificuldade;
  }

  /**
   * Retorna o tempo de preparo da receita.
   */
  public TempoPreparo getTempoPreparo() {
    return tempoPreparo;
  }

  /**
   * Define o tempo de preparo da receita.
   *
   * @param tempoPreparo Tempo de preparo da receita.
   */
  public void setTempoPreparo(TempoPreparo tempoPreparo) {
    this.tempoPreparo = tempoPreparo;
  }

  /**
   * Adiciona um novo comentário na lista de comentários.
   *
   * @param comentario o comentário a ser adicionado.
   */
  public void adicionarComentario(Comentario comentario) {
    this.comentarios.add(comentario);
  }

  /**
   * Remove um comentário da lista de comentários.
   *
   * @param comentario o comentário para ser removido.
   * @return true se o comentário existia e foi removido, false caso contrário.
   */
  public boolean removerComentario(Comentario comentario) {
    return this.comentarios.remove(comentario);
  }

  /**
   * Retorna a lista dos comentarios presentes na Receita.
   *
   * @return Lista com os comentários.
   */
  public List<Comentario> listarComentarios() {
    return comentarios;
  }

  /**
   * Altera a referência da lista de comentários.
   *
   * @param comentarios referência para lista de comentários.
   */
  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }

  /**
   * Adiciona uma nova categoria na lista de categorias.
   *
   * @param categoria a categoria a ser adicionado.
   */
  public void adicionarCategoria(Categoria categoria) {
    this.categorias.add(categoria);
  }

  /**
   * Remove uma categoria da lista de categorias.
   *
   * @param categoria a categoria para ser removido.
   * @return true se a categoria existia e foi removido, false caso contrário.
   */
  public boolean removerCategoria(Categoria categoria) {
    return this.categorias.remove(categoria);
  }

  /**
   * Retorna a lista das categorias da Receita.
   *
   * @return Lista com as categorias.
   */
  public List<Categoria> listarCategorias() {
    return categorias;
  }

  /**
   * Altera a referência da lista de categorias.
   *
   * @param categorias referência para lista de categorias.
   */
  public void setCategorias(List<Categoria> categorias) {
    this.categorias = categorias;
  }

  /**
   * Adiciona um novo ingrediente na lista de ingredientes.
   *
   * @param ingrediente o ingrediente a ser adicionado.
   */
  public void adicionarIngrediente(Ingrediente ingrediente) {
    this.ingredientes.add(ingrediente);
  }

  /**
   * Remove um ingrediente da lista de ingredientes.
   *
   * @param ingrediente o ingrediente para ser removido.
   * @return true se o ingrediente existia e foi removida, false caso contrário.
   */
  public boolean removerIngrediente(Ingrediente ingrediente) {
    return this.ingredientes.remove(ingrediente);
  }

  /**
   * Retorna a lista dos ingredientes da receita.
   *
   * @return Lista com os ingredientes.
   */
  public List<Ingrediente> listarIngredientes() {
    return ingredientes;
  }

  /**
   * Altera a referência da lista de ingredientes.
   *
   * @param ingredientes referência para lista de ingredientes.
   */
  public void setIngredientes(List<Ingrediente> ingredientes) {
    this.ingredientes = ingredientes;
  }

  /**
   * Adiciona uma nova imagem na lista de imagens.
   *
   * @param caminhoImagem a imagem a ser adicionado.
   */
  public void adicionarImagem(String caminhoImagem) {
    this.caminhosImagens.add(caminhoImagem);
  }

  /**
   * Remove uma imagem da lista de imagens.
   *
   * @param caminhoImagem a imagem para ser removido.
   * @return true se a imagem existia e foi removida, false caso contrário.
   */
  public boolean removerImagem(String caminhoImagem) {
    return this.caminhosImagens.remove(caminhoImagem);
  }

  /**
   * Retorna a lista com as imagens presentes na receita.
   *
   * @return Lista com as imagens.
   */
  public List<String> listarImagens() {
    return this.caminhosImagens;
  }

  /* TODO: Implementar o método hashCode (depois revisar o "contrato" da API do Java)
   @Override
   public int hashCode() {
       return super.hashCode();
   }
   */

  /* TODO: Implementar o método equals (depois revisar o "contrato" da API do Java)
   @Override
   public boolean equals(Object obj) {
       return super.equals(obj);
   }
   */

  /**
   * Altera a referência da lista de imagens.
   *
   * @param caminhosImagens referência para lista de imagens.
   */
  public void setImagens(List<String> caminhosImagens) {
    this.caminhosImagens = caminhosImagens;
  }

  /**
   * Retorna os principais campos do objeto receito de forma organizada. Principais campos: titulo,
   * dificuldade, custo, rendimento, quantidades
   *
   * @return Retorna a representação do objeto receita em String
   */
  @Override
  public String toString() {
    return String.format("%s\n" +
            "Dificuldade: %s\n" +
            "Tempo Preparo: %s\n" +
            "Custo: %s\n" +
            "Rendimento: %s\n" +
            "Quantidade Ingredientes: %d\n" +
            "Quantidade Imagens: %d\n" +
            "Quantidade Comentários: %d\n" +
            "Modo preparo: %s\n",
        this.titulo, this.dificuldade, this.tempoPreparo, this.custo, this.rendimento,
        this.ingredientes.size(), this.caminhosImagens.size(), this.comentarios.size(),
        this.modoPreparo);
  }
}
