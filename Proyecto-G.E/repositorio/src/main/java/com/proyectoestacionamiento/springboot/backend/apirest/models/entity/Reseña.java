package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "reseña")
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    private String contenido;

    @JsonIgnoreProperties(value = {"reseñas", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @ManyToOne()
    @JoinColumn(name = "id_estacionamiento", referencedColumnName = "id")
    private Estacionamiento estacionamiento;

    @JsonIgnoreProperties(value = {"reseñas", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToOne()
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    public Reseña(@NotEmpty String contenido, @NotEmpty Cliente cliente, @NotEmpty Estacionamiento estacionamiento) {
        this.cliente = cliente;
        this.estacionamiento = estacionamiento;
        this.contenido = contenido;
    }

    public Reseña() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }
}
