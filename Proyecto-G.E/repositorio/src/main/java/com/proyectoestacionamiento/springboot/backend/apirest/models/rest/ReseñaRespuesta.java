package com.proyectoestacionamiento.springboot.backend.apirest.models.rest;

public class ReseñaRespuesta {
    private Long id;
    private String contenidoReseña;
    private int idEstacionamiento;

    private String nombreCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenidoReseña() {
        return contenidoReseña;
    }

    public void setContenidoReseña(String contenidoReseña) {
        this.contenidoReseña = contenidoReseña;
    }

    public int getIdEstacionamiento() {
        return idEstacionamiento;
    }

    public void setIdEstacionamiento(int idEstacionamiento) {
        this.idEstacionamiento = idEstacionamiento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
