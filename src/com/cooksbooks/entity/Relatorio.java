package com.cooksbooks.entity;

import com.cooksbooks.entity.utils.Comentario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * A Classe Relatorio é responsável por abstrair a noção de um relatório de sistema.
 * <p>
 * Ela possui métodos para calcular informações pertinentes sobre o sistema.
 * <p>
 * Usuários Administradores podem solicitar ao sistema um relátorio, que será retornado como uma
 * instância dessa classe.
 *
 * @version 1.1
 */
public class Relatorio {

  private long qtdUsuariosCadastrados;
  private long qtdNovosUsuarios;
  private long qtdUsuariosAtivos;
  private LocalDate dataIncial;
  private LocalDate dataFinal;
  private List<Feedback> feedbacks;

  /**
   * Construtor nulo. Inicializa os campos com valores padrões. Valores padrão: 0 para tipos
   * númericos primitivos. null para tipos de referência.
   */
  public Relatorio() {
    this.qtdUsuariosCadastrados = 0L;
    this.qtdNovosUsuarios = 0L;
    this.qtdUsuariosAtivos = 0L;
    this.dataIncial = null;
    this.dataFinal = null;
    this.feedbacks = null;
  }

  /**
   * Construtor completo da classe.
   *
   * @param qtdUsuariosCadastrados quantidade de usuários cadastrados no sistema até a data final.
   * @param qtdNovosUsuarios       quantidade de usuários cadastrados entre as datas inicial e
   *                               final.
   * @param qtdUsuariosAtivos      quantidade de usuários ativos na plataforma até a data final.
   * @param dataIncial             data inicial do relatório.
   * @param dataFinal              data final do relatório.
   * @param feedbacks            lista com os feedbacks enviados entre as datas
   *                               inicial e final.
   */
  public Relatorio(long qtdUsuariosCadastrados, long qtdNovosUsuarios, long qtdUsuariosAtivos,
      LocalDate dataIncial, LocalDate dataFinal, List<Feedback> feedbacks) {
    this.qtdNovosUsuarios = qtdNovosUsuarios;
    this.qtdUsuariosCadastrados = qtdUsuariosCadastrados;
    this.qtdUsuariosAtivos = qtdUsuariosAtivos;
    this.dataIncial = dataIncial;
    this.dataFinal = dataFinal;
    this.feedbacks = feedbacks;
  }

  /**
   * Função para uso interno, só deve ser utilizada para debug. Realiza algumas operações com a
   * classe e imprime no console.
   */
  public static void debug() {
    Relatorio relatorio = new Relatorio();

    relatorio.setDataIncial(LocalDate.of(2021, 1, 1));
    relatorio.setDataFinal(LocalDate.of(2021, 1, 18));

    relatorio.setQtdUsuariosCadastrados(110L);
    relatorio.setQtdNovosUsuarios(10L);
    relatorio.setQtdUsuariosAtivos(90L);

    List<Feedback> feedbacks = new ArrayList<>();
    feedbacks.add(new Feedback("Simplesmente incrível, recomendei para toda minha família!",
        LocalDate.now().atStartOfDay(), "moesiof", "Moésio Filho", "0"));
    feedbacks.add(new Feedback("Muito bom! Nota 10!", LocalDate.now().atStartOfDay(),
        "joao22", "João Pedro", "1"));

    relatorio.setFeedbacks(feedbacks);

    relatorio.printRelatorio();
  }

  /**
   * Retorna a quantiade de usuários cadastrados até a data final.
   *
   * @return Long com a quantidade de usuários cadastrados.
   */
  public long getQtdUsuariosCadastrados() {
    return this.qtdUsuariosCadastrados;
  }

  /**
   * Atualiza a quantiade de usuários cadastrados até a data final.
   *
   * @param qtdUsuariosCadastrados quantidade de usuários cadastrados no sistema até a data final.
   */
  public void setQtdUsuariosCadastrados(long qtdUsuariosCadastrados) {
    this.qtdUsuariosCadastrados = qtdUsuariosCadastrados;
  }

  /**
   * Retorna a quantiade de novos usuários entre a data inicial e final.
   *
   * @return Long com a quantidade de novos usuários.
   */
  public long getQtdNovosUsuarios() {
    return this.qtdNovosUsuarios;
  }

  /**
   * Atualiza a quantiade de novos usuários entre a data inicial e final.
   *
   * @param qtdNovosUsuarios quantidade de usuários cadastrados entre as datas inicial e final
   */
  public void setQtdNovosUsuarios(long qtdNovosUsuarios) {
    this.qtdNovosUsuarios = qtdNovosUsuarios;
  }

  /**
   * Retorna a quantiade de usuários ativos entre a data inicial e final.
   *
   * @return Long com a quantidade de usuários ativos.
   */
  public long getQtdUsuariosAtivos() {
    return this.qtdUsuariosAtivos;
  }

  /**
   * Atualiza a quantiade de usuários ativos entre a data inicial e final.
   *
   * @param qtdUsuariosAtivos quantidade de usuários ativos na plataforma até a data final
   */
  public void setQtdUsuariosAtivos(long qtdUsuariosAtivos) {
    this.qtdUsuariosAtivos = qtdUsuariosAtivos;
  }

  /**
   * Retorna a data inicial do relatório.
   *
   * @return LocalDate com a data inicial do relatório,
   */
  public LocalDate getDataIncial() {
    return this.dataIncial;
  }

  /**
   * Define a data inicial do relatório.
   *
   * @param dataIncial data inicial do relatório.
   */
  public void setDataIncial(LocalDate dataIncial) {
    this.dataIncial = dataIncial;
  }

  /**
   * Retorna a data final do relatório.
   *
   * @return LocalDate com a data final do relatório.
   */
  public LocalDate getDataFinal() {
    return this.dataFinal;
  }

  /**
   * Define a data final do relatório.
   *
   * @param dataFinal data final do relatório
   */
  public void setDataFinal(LocalDate dataFinal) {
    this.dataFinal = dataFinal;
  }

  /**
   * Retorna uma lista com os feedbacks contidos no relatório.
   *
   * @return Lista com os feedback contidos no relatório.
   */
  public List<Feedback> listarFeedbacks() {
    return this.feedbacks;
  }

  /**
   * Define a lista dos comentários do sistema.
   *
   * @param feedbacks lista com os feedbacks enviados entre as datas inicial e final.
   */
  public void setFeedbacks(List<Feedback> feedbacks) {
    this.feedbacks = feedbacks;
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
    if (qtdInicialUsuariosCadastrados < 0.0001) return 100.0;
    return 100.0 * ((double) this.qtdNovosUsuarios / qtdInicialUsuariosCadastrados);
  }

  /**
   * Método para uso interno, imprime o relatório formatado no console. Deve ser utilizado apenas
   * para fins de depuração.
   */
  public void printRelatorio() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.printf("%s\n", "Relatório do Sistema");
    System.out.printf("Período: %s - %s\n", dateFormatter.format(this.dataIncial),
        dateFormatter.format(this.dataFinal));
    System.out.printf("Quantidade de usuários cadastrados: %d\n", this.qtdUsuariosCadastrados);
    System.out.printf("Quantidade de usuários ativos: %d\n", this.qtdUsuariosAtivos);
    System.out.printf("Quantidade de novos usuários: %d\n", this.qtdNovosUsuarios);
    System.out.printf("Percentual usuários ativos: %.2f%%\n", this.percentualUsuariosAtivos());
    System.out.printf("Percentual novos usuários: %.2f%%\n", this.percentualAumentoUsuarios());
    System.out.printf("%s\n", "Feedbacks recebidos:");
    for (Comentario comentario : this.feedbacks) {
      System.out.printf("Usuário: %s Data: %s\n\t%s\n", comentario.getNomeUsuario(),
          dateFormatter.format(comentario.getData()),
          comentario.getTexto());
    }
  }

  /**
   * Retorna uma String que descreve o objeto (Data incial e data final)
   *
   * @return String no formato "Relatório de {dataInicial} até {dataFinal}"
   */
  @Override
  public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return String.format("Relatório de %s até %s", dateFormatter.format(this.dataIncial),
        dateFormatter.format(this.dataFinal));
  }
}
