package com.cooksbooks.entity;

import com.cooksbooks.utils.ExperienciaCulinaria;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * A Classe Usuario representa cada usuário cadastrado e é única para cada conta
 */
public class Usuario {

    private String login;
    private String senha;
    private String nomePerfil;
    private String biografia;
    private String caminhoImagemPerfil;
    private final LocalDateTime dataCriacao;
    private ExperienciaCulinaria experienciaCulinaria;

    /**
     * Construtor da classe Usuário que recebe login e senha como parâmetros.
     * A data de criação é instanciada apenas no momento que a classe é instanciada e não mais alterada.
     * @param login String do login da conta
     * @param senha String da senha da conta
     */
    public Usuario(String login, String senha){
        setLogin(login);
        setSenha(senha);
        this.dataCriacao = LocalDateTime.now();
    }

    /**
     * Retorna o login da conta.
     * @return String do login da conta
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Retorna a senha da conta.
     * @return String da senha da conta
     */
    public String getSenha(){
        return this.senha;
    }

    public String getNomePerfil() { return this.nomePerfil; }

    public String getBiografia() { return this.biografia; }

    public String getCaminhoImagemPerfil() { return this.caminhoImagemPerfil; }

    public ExperienciaCulinaria getExperienciaCulinaria() { return this.experienciaCulinaria; }

    /**
     * Retorna a data de criação da conta.
     * @return Data de criação da conta
     */
    public LocalDateTime getDataCriacao(){
        return this.dataCriacao;
    }

    /**
     * Define o login da conta.
     * @param login login da conta
     */
    public void setLogin(String login){
        if(!this.login.equals(login) && !login.trim().equals("")){
            this.login = login;
        }
    }

    /**
     * Define (ou muda) a senha.
     * @param senha senha da conta
     */
    public void setSenha(String senha){
        if(!this.senha.equals(senha) && !senha.trim().equals("")){
            this.senha = senha;
        }
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setCaminhoImagemPerfil(String caminhoImagemPerfil) {
        this.caminhoImagemPerfil = caminhoImagemPerfil;
    }

    public void setExperienciaCulinaria(ExperienciaCulinaria experienciaCulinaria) {
        this.experienciaCulinaria = experienciaCulinaria;
    }

    //Talvez mudar o tipo de retorno para int
    public long idadeConta(){
        LocalDate idade = LocalDate.of(dataCriacao.getYear(), dataCriacao.getMonthValue(), dataCriacao.getDayOfMonth());
        Period periodo = Period.between(idade, LocalDate.now());
        return periodo.getDays() + periodo.getMonths() * 30L + periodo.getYears() * 365L;
    }
}
