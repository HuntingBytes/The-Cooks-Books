package com.cooksbooks.entity;

import com.cooksbooks.utils.Comentario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * A Classe Relatorio é responsável
 * por abstrair a noção de um relatório de sistema.
 *
 * Ela possui métodos para calcular
 * informações pertinentes sobre o sistema.
 *
 * Usuários Administradores podem solicitar
 * ao sistema um relátorio, que será retornado
 * como uma instância dessa classe.
 *
 * @version 1.1
 */
public class Relatorio {
    private long qtdUsuariosCadastrados;
    private long qtdNovosUsuarios;
    private long qtdUsuariosAtivos;
    private LocalDate dataIncial;
    private LocalDate dataFinal;
    private List<Comentario> comentarios;

    /**
     * Construtor nulo. Inicializa os campos com valores padrões.
     * Valores padrão:
     * 0 para tipos númericos primitivos.
     * null para tipos de referência.
     */
    public Relatorio() {
        this.qtdUsuariosCadastrados = 0L;
        this.qtdNovosUsuarios = 0L;
        this.qtdUsuariosAtivos = 0L;
        this.dataIncial = null;
        this.dataFinal = null;
        this.comentarios = null;
    }

    /**
     * Construtor completo da classe.
     */
    public Relatorio(long qtdUsuariosCadastrados, long qtdNovosUsuarios, long qtdUsuariosAtivos,
                     LocalDate dataIncial, LocalDate dataFinal, List<Comentario> comentarios) {
        this.qtdNovosUsuarios = qtdNovosUsuarios;
        this.qtdUsuariosCadastrados = qtdUsuariosCadastrados;
        this.qtdUsuariosAtivos = qtdUsuariosAtivos;
        this.dataIncial = dataIncial;
        this.dataFinal = dataFinal;
        this.comentarios = comentarios;
    }

    /**
     * Retorna a quantiade de usuários cadastrados até a data final.
     * @return Long com a quantidade de usuários cadastrados.
     */
    public long getQtdUsuariosCadastrados() {
        return this.qtdUsuariosCadastrados;
    }

    /**
     * Atualiza a quantiade de usuários cadastrados até a data final.
     */
    public void setQtdUsuariosCadastrados(long qtdUsuariosCadastrados) {
        this.qtdUsuariosCadastrados = qtdUsuariosCadastrados;
    }

    /**
     * Retorna a quantiade de novos usuários entre a data inicial e final.
     * @return Long com a quantidade de novos usuários.
     */
    public long getQtdNovosUsuarios() {
        return this.qtdNovosUsuarios;
    }

    /**
     * Atualiza a quantiade de novos usuários entre a data inicial e final.
     */
    public void setQtdNovosUsuarios(long qtdNovosUsuarios) {
        this.qtdNovosUsuarios = qtdNovosUsuarios;
    }

    /**
     * Retorna a quantiade de usuários ativos entre a data inicial e final.
     * @return Long com a quantidade de usuários ativos.
     */
    public long getQtdUsuariosAtivos() {
        return this.qtdUsuariosAtivos;
    }

    /**
     * Atualiza a quantiade de usuários ativos entre a data inicial e final.
     */
    public void setQtdUsuariosAtivos(long qtdUsuariosAtivos) {
        this.qtdUsuariosAtivos = qtdUsuariosAtivos;
    }

    /**
     * Retorna a data inicial do relatório.
     * @return LocalDate com a data inicial do relatório,
     */
    public LocalDate getDataIncial() {
        return this.dataIncial;
    }

    /**
     * Define a data inicial do relatório.
     */
    public void setDataIncial(LocalDate dataIncial) {
        this.dataIncial = dataIncial;
    }

    /**
     * Retorna a data final do relatório.
     * @return LocalDate com a data final do relatório,
     */
    public LocalDate getDataFinal() {
        return this.dataFinal;
    }

    /**
     * Define a data final do relatório.
     */
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * Retorna uma lista com os comentários contidos no relatório.
     * @return {@code List<Comentario>} com os comentários contidos no relatório.
     */
    public List<Comentario> listarComentarios() {
        return this.comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Calcula e retorna o percentual de usuários ativos.
     * @return Double que representa o percentual de usuários ativos.
     */
    public double percentualUsuariosAtivos() {
        return 100.0 * ((double) this.qtdUsuariosAtivos / (double) this.qtdUsuariosCadastrados);
    }

    /**
     * Calcula e retorna o percentual do aumento de usuários.
     * @return Double que representa o percentual do aumento de usuários.
     */
    public double percentualAumentoUsuarios() {
        double qtdInicialUsuariosCadastrados = (this.qtdUsuariosCadastrados - this.qtdNovosUsuarios);
        return 100.0 * ((double) this.qtdNovosUsuarios / qtdInicialUsuariosCadastrados);
    }

    /**
     * Método para uso interno, imprime o relatório formatado no console.
     * Deve ser utilizado apenas para fins de depuração.
     */
    public void printRelatorio() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%s\n","Relatório do Sistema");
        System.out.printf("Período: %s - %s\n", dateFormatter.format(this.dataIncial),
                dateFormatter.format(this.dataFinal));
        System.out.printf("Quantidade de usuários cadastrados: %d\n", this.qtdUsuariosCadastrados);
        System.out.printf("Quantidade de usuários ativos: %d\n", this.qtdUsuariosAtivos);
        System.out.printf("Quantidade de novos usuários: %d\n", this.qtdNovosUsuarios);
        System.out.printf("Percentual usuários ativos: %.2f%%\n", this.percentualUsuariosAtivos());
        System.out.printf("Percentual novos usuários: %.2f%%\n", this.percentualAumentoUsuarios());
        // TODO: Implementar impressão dos comentários aqui
        /*
        System.out.printf("Feedbacks recebidos:\n", this.percentualAumentoUsuarios());
        for(Comentario comentario : this.comentarios) {
            System.out.printf("%s em %s\n\t%s\n", comentario.getAutor(),
                              dateFormatter.format(comentario.getData()),
                              comentario.getTexto());
        }
        */
    }

    /**
     * Retorna uma String que descreve o objeto (Data incial e data final)
     * @return String no formato "Relatório de {dataInicial} até {dataFinal}"
     */
    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Relatório de %s até %s", dateFormatter.format(this.dataIncial),
                             dateFormatter.format(this.dataFinal));
    }

    /**
     * Função para uso interno, só deve ser utilizada para debug.
     * Realiza algumas operações com a classe e imprime no console.
     * */
    public static void debug() {
        Relatorio relatorio = new Relatorio();

        relatorio.setDataIncial(LocalDate.of(2021, 1, 1));
        relatorio.setDataFinal(LocalDate.of(2021, 1, 18));

        relatorio.setQtdUsuariosCadastrados(110L);
        relatorio.setQtdNovosUsuarios(10L);
        relatorio.setQtdUsuariosAtivos(90L);

        relatorio.setComentarios(null);

        relatorio.printRelatorio();
    }
}
