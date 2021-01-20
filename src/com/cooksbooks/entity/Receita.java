package com.cooksbooks.entity;

import com.cooksbooks.utils.*;
import com.cooksbooks.utils.Ingrediente;

import java.util.ArrayList;
import java.util.List;

/**
 * A Classe Receita é responsável por representar uma receita no sistema.
 *
 * Ela possui diversos campos que a caracterizam e métodos para acessar e atualizar esses campos.
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
    // TODO: Adicionar private List<Categoria> categoria;
    private List<Ingrediente> ingredientes;
    private List<Comentario> comentarios;
    private List<Imagem> imagens;

    // TODO: Adicionar getters/setters para os outros campos (titulo, tempoPreparo, custo, rendimento, dificuldade)

    // Talvez adicionar outros construtores com algumas inforamçoes parciais
    // Algum Receita(titulo, custo, rendimento, dificuldade)
    // Ou melhor, usando as ideias do JavaBeans poderíamos ter um único construtor
    // vazio Receita() e todos os campos seriam preenchidos por meio de getters/setters

    /**
     * Construtor nulo. Inicializa os campos com valores padrões.
     * Valores padrão:
     * Custo.BARATO, Rendimento.UM, Dificuldade.FACIL.
     * Listas são inicializadas sem elementos.
     * Strings são inicializadas como "".
     */
    public Receita() {
        this.titulo = "";
        this.modoPreparo = "";
        this.custo = Custo.BARATO;
        this.rendimento = Rendimento.UM;
        this.dificuldade = Dificuldade.FACIL;
        this.ingredientes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.imagens = new ArrayList<>();
        // TODO: Inicializar tempoPreparo e categoria com valores padrão
    }

    /**
     * Construtor que recebe um titulo.
     * Demais elementos são inicializados com os valores padrões.
     * @param titulo o título da receita.
     */
    public Receita(String titulo) {
        this();
        this.titulo = titulo;
    }

    /**
     * Adiciona um novo comentário na lista de comentários.
     * @param comentario o comentário a ser adicionado.
     */
    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    /**
     * Remove um comentário da lista de comentários.
     * @param comentario o comentário para ser removido.
     * @return true se o comentário existia e foi removido, false caso contrário.
     */
    public boolean removerComentario(Comentario comentario) {
        return this.comentarios.remove(comentario);
    }

    /* TODO: Implementar método para adicionar/remover uma Categoria
    public void adicionarCategoria(Categoria categoria) { this.categorias.add(categoria) }

    public boolean removerCategoria(Categoria categoria) { return this.categorias.remove(categoria);}
     */

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
     * @return true se o ingrediente existia e foi removida, false caso contrário.
     */
    public boolean removerIngrediente(Ingrediente ingrediente) { return this.ingredientes.remove(ingrediente); }

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
     * @return true se a imagem existia e foi removida, false caso contrário.
     */
    public boolean removerImagem(Imagem imagem) {
        return this.imagens.remove(imagem);
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
     * Retorna os principais campos do objeto receito de forma organizada.
     * Principais campos: titulo, dificuldade, custo, rendimento, quantidades
     * @return Retorna a representação do objeto receita em String
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
                        Quantidade Comentários: %d""",
                        this.titulo, this.dificuldade, this.custo, this.rendimento,
                        this.ingredientes.size(), this.imagens.size(), this.comentarios.size());
    }

    /**
     * Função para uso interno, só deve ser utilizada para debug.
     * Realiza algumas operações com a classe e imprime no console.
     * */
    public static void debug() {
        Receita receita = new Receita();
        System.out.println(receita);
    }
}
