package com.cooksbooks.entity;

import com.cooksbooks.utils.ExperienciaCulinaria;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Perfil {

    private String nomePerfil;
    private String biografia;
    private ExperienciaCulinaria experienciaCulinaria;
    private Image imagemPerfil;
    private List<CadernoReceitas> listaCadernoReceitas;

    // TODO private MinhasReceitas minhasReceitas;


    public Perfil () {
        this.listaCadernoReceitas = new ArrayList<>();
    }


    /**
     * Adiciona um caderno na lista de cadernos
     *
     * @param cadernoReceitas um caderno de receitas
     */
    public void adicionarCadernoReceitas (CadernoReceitas cadernoReceitas) {
        this.listaCadernoReceitas.add(cadernoReceitas);
    }

    /**
     * Remove um caderno na lista de cadernos
     *
     * @param cadernoReceitas um caderno de receitas
     */
    public void removerCadernoReceitas (CadernoReceitas cadernoReceitas) {
        this.listaCadernoReceitas.remove(cadernoReceitas);
    }


    /**
     * Remove a imagem do perfil
     *
     */
    public void removerImagem () {
        this.imagemPerfil = null;

    }

    /**
     * Retorna o nome do Perfil
     *
     * @return String nome do Perfil
     */
    public String getNomePerfil () {
        return nomePerfil;
    }

    /**
     * Define um nome para o perfil
     *
     * @param nomePerfil nome para o perfil
     */
    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    /**
     * Retorna a biografia do perfil
     *
     * @return String biografia do perfil
     */
    public String getBiografia () {
        return biografia;
    }

    /**
     * Define uma biografia para o perfil
     *
     * @param biografia do perfil
     */
    public void setBiografia (String biografia) {
        this.biografia = biografia;
    }

    /**
     * Retorna uma experienciaCulinaria para o perfil
     *
     * @return String experiencia culinaaria
     */
    public ExperienciaCulinaria getExperienciaCulinaria () {
        return experienciaCulinaria;
    }

    /**
     * Define uma experienciaCulinaria para o perfil
     *
     * @param experienciaCulinaria experiencia culinaria
     */
    public void setExperienciaCulinaria (ExperienciaCulinaria experienciaCulinaria) {
        this.experienciaCulinaria = experienciaCulinaria;
    }

    /**
     * Retorna a imagem do perfil
     *
     * @return imagemPerfil imagem do perfil
     */
    public Image getImagemPerfil () {
        return this.imagemPerfil;
    }

    /**
     * Define uma imagem para o perfil
     *
     * @param imagemPerfil imagem do perfil
     */
    public void setImagemPerfil (Image imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

}
