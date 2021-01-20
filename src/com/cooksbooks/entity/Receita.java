package com.cooksbooks.entity;

import com.cooksbooks.utils.Ingrediente;
import com.cooksbooks.utils.Categoria;
import com.cooksbooks.utils.Custo;
import com.cooksbooks.utils.Rendimento;
import com.cooksbooks.utils.Dificuldade;
import com.cooksbooks.utils.Comentario;
import com.cooksbooks.utils.Imagem;

import java.util.ArrayList;
import java.util.List;

/**
 * A Classe Receita Ã© responsÃ¡vel por representar uma receita no sistema.
 *
 * Ela possui diversos campos que a caracterizam e mÃ©todos para acessar e atualizar esses campos.
 *
 * @version 1.0
 */
public class Receita {
    private String titulo;
    private String modoPreparo;
    // TODO: Adicionar private TempoPreparo tempoPreparo;
    private Custo custo;
    private Rendimento rendimento;
    private Dificuldade dificuldade;
    private final List<Categoria> categorias;
    private final List<Ingrediente> ingredientes;
    private final List<Comentario> comentarios;
    private final List<Imagem> imagens;

    // TODO: Adicionar getter/setter para tempoPreparo

    // Talvez adicionar outros construtores com algumas informaÃ§Ãµes parciais
    // Algum Receita(titulo, custo, rendimento, dificuldade)
    // Ou melhor, usando as ideias do JavaBeans poderÃ­amos ter um Ãºnico construtor
    // vazio Receita() e todos os campos seriam preenchidos por meio de getters/setters

    /**
     * Construtor nulo. Inicializa os campos com valores padrÃµes.
     * Valores padrÃ£o:
     * Custo.BARATO; Rendimento.UM; Dificuldade.FACIL;
     * Listas sÃ£o inicializadas sem elementos;
     * Strings sÃ£o inicializadas como "".
     */
    public Receita() {
        this.titulo = "";
        this.modoPreparo = "";
        this.custo = Custo.BARATO;
        this.rendimento = Rendimento.UM;
        this.dificuldade = Dificuldade.FACIL;
        this.categorias = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.imagens = new ArrayList<>();
        // TODO: Inicializar tempoPreparo com valores padrÃ£o
    }

    /**
     * Construtor que recebe um titulo.
     * Demais elementos sÃ£o inicializados com os valores padrÃµes.
     * @param titulo o tÃ­tulo da receita.
     */
    public Receita(String titulo) {
        this();
        this.titulo = titulo;
    }

    /**
     * Retorna o tÃ­tulo da receita.
     * @return String do tÃ­tulo da receita.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Define o tÃ­tulo da receita.
     * @param  titulo tÃ­tulo da receita.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna o modo de preparo da receita.
     * @return String do modo de preparo da receita.
     */
    public String getModoPreparo() {
        return this.modoPreparo;
    }

    /**
     * Define o modo de preparo da receita.
     * @param modoPreparo modo de preparo da receita.
     */
    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    /**
     * Retorna o custo da receita.
     * @return Custo da receita.
     */
    public Custo getCusto() {
        return this.custo;
    }

    /**
     * Define o custo da receita.
     * @param custo custo da receita.
     */
    public void setCusto(Custo custo) {
        this.custo = custo;
    }

    /**
     * Retorna o rendimento da receita.
     * @return Rendimento da receita.
     */
    public Rendimento getRendimento() {
        return this.rendimento;
    }

    /**
     * Define o rendimento da receita.
     * @param  rendimento Rendimento da receita.
     */
    public void setRendimento(Rendimento rendimento) {
        this.rendimento = rendimento;
    }

    /**
     * Retorna a dificuldade da receita.
     * @return Dificuldade da receita.
     */
    public Dificuldade getDificuldade() {
        return this.dificuldade;
    }

    /**
     * Define a dificuldade da receita.
     * @param  dificuldade Dificuldade da receita.
     */
    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    /**
     * Adiciona um novo comentÃ¡rio na lista de comentÃ¡rios.
     * @param comentario o comentÃ¡rio a ser adicionado.
     */
    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    /**
     * Remove um comentÃ¡rio da lista de comentÃ¡rios.
     * @param comentario o comentÃ¡rio para ser removido.
     * @return true se o comentÃ¡rio existia e foi removido, false caso contrÃ¡rio.
     */
    public boolean removerComentario(Comentario comentario) {
        return this.comentarios.remove(comentario);
    }

    /**
     * Retorna a lista dos comentarios presentes na Receita.
     * @return Lista com os comentÃ¡rios.
     */
    public List<Comentario> listarComentarios() {
        return comentarios;
    }

    /**
     * Adiciona uma nova categoria na lista de categorias.
     * @param categoria a categoria a ser adicionado.
     */
    public void adicionarCategoria(Categoria categoria) { this.categorias.add(categoria); }

    /**
     * Remove uma categoria da lista de categorias.
     * @param categoria a categoria para ser removido.
     * @return true se a categoria existia e foi removido, false caso contrÃ¡rio.
     */
    public boolean removerCategoria(Categoria categoria) { return this.categorias.remove(categoria);}

    /**
     * Retorna a lista das categorias da Receita.
     * @return Lista com as categorias.
     */
    public List<Categoria> listarCategorias() {
        return categorias;
    }

    /**
     * Adiciona um novo ingrediente na lista de ingredientes.
     * @param ingrediente o ingrediente a ser adicionado.
     */
    public void adicionarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    /**
     * Remove um ingrediente da lista de ingredientes.
     * @param ingrediente o ingrediente para ser removido.
     * @return true se o ingrediente existia e foi removida, false caso contrÃ¡rio.
     */
    public boolean removerIngrediente(Ingrediente ingrediente) { return this.ingredientes.remove(ingrediente); }

    /**
     * Retorna a lista dos ingredientes da receita.
     * @return Lista com os ingredientes.
     */
    public List<Ingrediente> listarIngredientes() {
        return ingredientes;
    }

    /**
     * Adiciona uma nova imagem na lista de imagens.
     * @param imagem a imagem a ser adicionado.
     */
    public void adicionarImagem(Imagem imagem) {
        this.imagens.add(imagem);
    }

    /**
     * Remove uma imagem da lista de imagens.
     * @param imagem a imagem para ser removido.
     * @return true se a imagem existia e foi removida, false caso contrÃ¡rio.
     */
    public boolean removerImagem(Imagem imagem) {
        return this.imagens.remove(imagem);
    }

    /**
     * Retorna a lista com as imagens presentes na receita.
     * @return Lista com as imagens.
     */
    public List<Imagem> listarImagens() {
        return imagens;
    }

    /* TODO: Implementar o mÃ©todo hashCode (depois revisar o "contrato" da API do Java)
    @Override
    public int hashCode() {
        return super.hashCode();
    }
     */

    /* TODO: Implementar o mÃ©todo equals (depois revisar o "contrato" da API do Java)
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
     */

    /**
     * Retorna os principais campos do objeto receito de forma organizada.
     * Principais campos: titulo, dificuldade, custo, rendimento, quantidades
     * @return Retorna a representaÃ§Ã£o do objeto receita em String
     */
    @Override
    public String toString() {
        return String.format("""
                        %s
                        Dificuldade: %s
                        Custo: %s
                        Rendimento: %s
                        Quantidade Ingredientes: %d
                        Quantidade Imagens: %d
                        Quantidade ComentÃ¡rios: %d""",
                this.titulo, this.dificuldade, this.custo, this.rendimento,
                this.ingredientes.size(), this.imagens.size(), this.comentarios.size());
    }

    /**
     * FunÃ§Ã£o para uso interno, sÃ³ deve ser utilizada para debug.
     * Realiza algumas operaÃ§Ãµes com a classe e imprime no console.
     * */
    public static void debug() {
        Receita receita = new Receita();
        System.out.println(receita);
    }
}
