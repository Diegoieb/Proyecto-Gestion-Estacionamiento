package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Reseña;
import com.proyectoestacionamiento.springboot.backend.apirest.models.rest.ReseñaRespuesta;

import java.util.List;

public interface IReseñaService {

	List<ReseñaRespuesta> obtenerTodasLasReseñas();

	ReseñaRespuesta crearReseña(Reseña reseña);

	ReseñaRespuesta encontrarReseñaPorId(Integer id);

	void borrarReseñaPorId(Integer id);
}
