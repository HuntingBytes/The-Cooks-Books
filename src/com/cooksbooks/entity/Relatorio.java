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
 * @version 1.0
 */
public class Relatorio {
    private final long qtdUsuariosCadastrados;
    private final long qtdNovosUsuarios;
    private final long qtdUsuariosAtivos;
    private final LocalDate dataIncial;
    private final LocalDate dataFinal;
    private final List<Comentario> comentarios;

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
     * Calcula e retorna o percentual de usuários ativos.
     *
     * @return Double que representa o percentual de usuários ativos.
     */
    public double percentualUsuariosAtivos() {
        return 100.0 * ((double) this.qtdUsuariosAtivos / (double) this.qtdUsuariosCadastrados);
    }

    /**
     * Calcula e retorna o percentual do aumento de usuários.
     *
     * @return Double que representa o percentual do aumento de usuários.
     */
    public double percentualAumentoUsuarios() {
        double qtdInicialUsuariosCadastrados = (this.qtdUsuariosCadastrados - this.qtdNovosUsuarios);
        return 100.0 * ((double) this.qtdNovosUsuarios / qtdInicialUsuariosCadastrados);
    }

    /**
     * Retorna uma lista com os comentários contidos no relatório.
     *
     * @return {@code List<Comentario>} com os comentários contidos no relatório.
     */
    public List<Comentario> listarComentarios() {
        return this.comentarios;
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
     * Função para uso interno, só deve ser utilizada para debug.
     * Realiza algumas operações com a classe e imprime no console.
     * */
    public static void debug() {
        LocalDate dataInicio = LocalDate.of(2021, 1, 1);
        LocalDate dataFinal = LocalDate.of(2021, 1, 18);
        Relatorio relatorio = new Relatorio(110L, 10L, 90L,
                                            dataInicio, dataFinal, null);
        relatorio.printRelatorio();
    }
}
