package com.proyectoestacionamiento.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE ) 
@Entity
@Table(name="punto_de_atencion")
public class PuntoAtencion {
	
	 @Embeddable
	    public static class Id implements Serializable {
	 
	        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			@Column(name = "id_cliente2")
	        private int clienteId;
	 
	        @Column(name = "id_estacionamiento")
	        private int estacionamientoId;
	 
	        public Id() {}
	        
	        public Id(int clienteId, int estacionamientoId) {
	            this.clienteId = clienteId;
	            this.estacionamientoId = estacionamientoId;
	        }

	    }
	 
		@EmbeddedId
		private Id id = new Id();
		
		@Column(name = "hora_de_ingreso")
	    @NotEmpty
	    private Date ingreso;
		
		@Column(name = "hora_de_salida")
	    @NotEmpty
	    private Date salida;
	    
	    @NotNull
	    private int capacidad;
	    
	    @NotNull
	    private int pago;
	    
	    @Column(name = "tipo_de_pago")
	    @NotEmpty
	    private String tipoPago;
	    
	    private String resenia;
	    
	    
	 
	    @ManyToOne
	    @JoinColumn(name="id_cliente2",insertable = false,
	            updatable = false)
	    private Cliente cliente;
	 
	    @ManyToOne
	    @JoinColumn(name="id_estacionamiento",insertable = false,
	            updatable = false)
	    private Estacionamiento estacionamiento;

		public Id getId() {
			return id;
		}

		public void setId(Id id) {
			this.id = id;
		}

		public Date getIngreso() {
			return ingreso;
		}

		public void setIngreso(Date ingreso) {
			this.ingreso = ingreso;
		}

		public Date getSalida() {
			return salida;
		}

		public void setSalida(Date salida) {
			this.salida = salida;
		}

		public int getCapacidad() {
			return capacidad;
		}

		public void setCapacidad(int capacidad) {
			this.capacidad = capacidad;
		}

		public int getPago() {
			return pago;
		}

		public void setPago(int pago) {
			this.pago = pago;
		}

		public String getTipoPago() {
			return tipoPago;
		}

		public void setTipoPago(String tipoPago) {
			this.tipoPago = tipoPago;
		}

		public String getResenia() {
			return resenia;
		}

		public void setResenia(String resenia) {
			this.resenia = resenia;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Estacionamiento getEstacionamiento() {
			return estacionamiento;
		}

		public void setEstacionamiento(Estacionamiento estacionamiento) {
			this.estacionamiento = estacionamiento;
		}

		public PuntoAtencion(Id id, @NotEmpty Date ingreso, @NotEmpty Date salida, @NotNull int capacidad,
				@NotNull int pago, @NotEmpty String tipoPago, String resenia, Cliente cliente,
				Estacionamiento estacionamiento) {
			super();
			this.id = id;
			this.ingreso = ingreso;
			this.salida = salida;
			this.capacidad = capacidad;
			this.pago = pago;
			this.tipoPago = tipoPago;
			this.resenia = resenia;
			this.cliente = cliente;
			this.estacionamiento = estacionamiento;
		}

		public PuntoAtencion() {

			// TODO Auto-generated constructor stub
		}
		
		
	 

}
