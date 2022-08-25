package com.example.recyclerviewagenda;

public class DatosVO {
    private String contacto;
    private String detalles;
    private Integer imgcontacto;

    public DatosVO() {
    }

    public DatosVO(String contacto, String detalles, Integer imgcontacto) {
        this.contacto = contacto;
        this.detalles = detalles;
        this.imgcontacto = imgcontacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Integer getImgcontacto() {
        return imgcontacto;
    }

    public void setImgcontacto(Integer imgcontacto) {
        this.imgcontacto = imgcontacto;
    }
}
