package com.example.recyclerclickfragmenttraslado;

public class DatosVO {
    private Integer imgen;
    private Integer nombre;
    private Integer precio;
    private Integer detalle;
    private Integer especificaciones;

    public DatosVO() {
    }

    public DatosVO(Integer imgen, Integer nombre, Integer precio) {
        this.imgen = imgen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public DatosVO(Integer detalle, Integer especificaciones) {
        this.detalle = detalle;
        this.especificaciones = especificaciones;
    }

    public DatosVO(Integer imgen, Integer nombre, Integer precio, Integer detalle, Integer especificaciones) {
        this.imgen = imgen;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle = detalle;
        this.especificaciones = especificaciones;
    }

    public Integer getImgen() {
        return imgen;
    }

    public void setImgen(Integer imgen) {
        this.imgen = imgen;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getDetalle() {
        return detalle;
    }

    public void setDetalle(Integer detalle) {
        this.detalle = detalle;
    }

    public Integer getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(Integer especificaciones) {
        this.especificaciones = especificaciones;
    }
}
