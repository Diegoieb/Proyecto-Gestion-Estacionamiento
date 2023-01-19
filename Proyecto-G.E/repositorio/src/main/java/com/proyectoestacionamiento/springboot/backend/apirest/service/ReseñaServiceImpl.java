package com.proyectoestacionamiento.springboot.backend.apirest.service;

import com.proyectoestacionamiento.springboot.backend.apirest.models.entity.Reseña;
import com.proyectoestacionamiento.springboot.backend.apirest.models.rest.ReseñaRespuesta;
import com.proyectoestacionamiento.springboot.backend.apirest.repository.IReseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReseñaServiceImpl implements IReseñaService {

    @Autowired
    IReseñaRepository reseñaRepository;

    @Override
    public List<ReseñaRespuesta> obtenerTodasLasReseñas() {
        List<Reseña> reseñas = reseñaRepository.findAll();
        List<ReseñaRespuesta> respuesta = reseñas.stream().map(reseña -> getReseñaRespuesta(reseña)).collect(Collectors.toList());
        return respuesta;
    }

    @Override
    public ReseñaRespuesta crearReseña(Reseña reseña) {
        Reseña resultadoGuardado = reseñaRepository.save(reseña);
        ReseñaRespuesta respuesta = getReseñaRespuesta(resultadoGuardado);
        return respuesta;
    }

    @Override
    public ReseñaRespuesta encontrarReseñaPorId(Integer id) throws Exception {
        Reseña resultadoRepositorio = reseñaRepository.findById(id).orElseThrow(() -> new Exception(String.format("Reseña para el id: %s no encontrado.\n", id)));
        return getReseñaRespuesta(resultadoRepositorio);
    }

    @Override
    public void borrarReseñaPorId(Integer id) {
        reseñaRepository.deleteById(id);
    }


    private static ReseñaRespuesta getReseñaRespuesta(Reseña resultadoGuardado) {
        ReseñaRespuesta respuesta = new ReseñaRespuesta();
        respuesta.setId(resultadoGuardado.getId());
        respuesta.setContenido(resultadoGuardado.getContenido());
        respuesta.setNombreCliente(resultadoGuardado.getCliente().getNombre());
        respuesta.setIdEstacionamiento(resultadoGuardado.getEstacionamiento().getIdEstacionamiento());
        return respuesta;
    }
}
