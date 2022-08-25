package com.example.carteleracine;

public class DatosVO {
    private Integer tituloPelicula;
    private Integer duracionPelicula;
    private Integer sinopsisPelicula;
    private Integer elencoPelicula;
    private Integer rottenPelicula;
    private Integer imgPelicula;
    private Integer precioPelicula;

    public DatosVO() {
    }

    public DatosVO(Integer tituloPelicula, Integer duracionPelicula, Integer imgPelicula) {
        this.tituloPelicula = tituloPelicula;
        this.duracionPelicula = duracionPelicula;
        this.imgPelicula = imgPelicula;
    }



    public DatosVO(Integer tituloPelicula, Integer duracionPelicula, Integer sinopsisPelicula,
                   Integer elencoPelicula, Integer rottenPelicula, Integer imgPelicula,
                   Integer precioPelicula) {
        this.tituloPelicula = tituloPelicula;
        this.duracionPelicula = duracionPelicula;
        this.sinopsisPelicula = sinopsisPelicula;
        this.elencoPelicula = elencoPelicula;
        this.rottenPelicula = rottenPelicula;
        this.imgPelicula = imgPelicula;
        this.precioPelicula = precioPelicula;
    }

    public Integer getPrecioPelicula() {
        return precioPelicula;
    }

    public void setPrecioPelicula(Integer precioPelicula) {
        this.precioPelicula = precioPelicula;
    }

    public Integer getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(Integer tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public Integer getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(Integer duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    public Integer getSinopsisPelicula() {
        return sinopsisPelicula;
    }

    public void setSinopsisPelicula(Integer sinopsisPelicula) {
        this.sinopsisPelicula = sinopsisPelicula;
    }

    public Integer getElencoPelicula() {
        return elencoPelicula;
    }

    public void setElencoPelicula(Integer elencoPelicula) {
        this.elencoPelicula = elencoPelicula;
    }

    public Integer getRottenPelicula() {
        return rottenPelicula;
    }

    public void setRottenPelicula(Integer rottenPelicula) {
        this.rottenPelicula = rottenPelicula;
    }

    public Integer getImgPelicula() {
        return imgPelicula;
    }

    public void setImgPelicula(Integer imgPelicula) {
        this.imgPelicula = imgPelicula;
    }
}
