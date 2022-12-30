package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "reseña")
public class Reseña {
    @Id
    private Long id;
    @NotEmpty
    private String contenidoReseña;
    @ManyToOne()
    @JoinColumn(name = "id_estacionamient", referencedColumnName = "id")
    private Estacionamiento estacionamiento;
    @OneToOne()
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    public Reseña(@NotEmpty String contenidoReseña, @NotEmpty Cliente cliente, @NotEmpty Estacionamiento estacionamiento) {
        this.cliente = cliente;
        this.estacionamiento = estacionamiento;
        this.contenidoReseña = contenidoReseña;
    }

    public Reseña() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getContenidoReseña() {
        return contenidoReseña;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Estacionamiento getEstacionamiento() {
        return estacionamiento;
    }
}
