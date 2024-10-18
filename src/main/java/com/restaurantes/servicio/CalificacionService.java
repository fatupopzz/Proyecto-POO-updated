package com.restaurantes.servicio;

import com.restaurantes.modelo.Calificacion;
import com.restaurantes.Repositorio.CalificacionRepository;
import com.restaurantes.Repositorio.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Calificacion crearCalificacion(Calificacion calificacion) {
        Calificacion nuevaCalificacion = calificacionRepository.save(calificacion);
        actualizarPromedioRestaurante(calificacion.getRestaurante().getId());
        return nuevaCalificacion;
    }

    public Optional<Calificacion> obtenerCalificacion(Long id) {
        return calificacionRepository.findById(id);
    }

    public List<Calificacion> obtenerCalificacionesPorRestaurante(Long restauranteId) {
        return calificacionRepository.findByRestauranteId(restauranteId);
    }

    public Optional<Calificacion> actualizarCalificacion(Long id, Calificacion calificacionActualizada) {
        return calificacionRepository.findById(id)
            .map(calificacion -> {
                calificacion.setPuntuacion(calificacionActualizada.getPuntuacion());
                calificacion.setComentario(calificacionActualizada.getComentario());
                Calificacion updated = calificacionRepository.save(calificacion);
                actualizarPromedioRestaurante(calificacion.getRestaurante().getId());
                return updated;
            });
    }

    public boolean eliminarCalificacion(Long id) {
        return calificacionRepository.findById(id)
            .map(calificacion -> {
                Long restauranteId = calificacion.getRestaurante().getId();
                calificacionRepository.deleteById(id);
                actualizarPromedioRestaurante(restauranteId);
                return true;
            })
            .orElse(false);
    }

    public double obtenerPromedioCalificacionesRestaurante(Long restauranteId) {
        return calificacionRepository.calcularPromedioCalificacionesPorRestaurante(restauranteId);
    }

    private void actualizarPromedioRestaurante(Long restauranteId) {
        restauranteRepository.findById(restauranteId).ifPresent(restaurante -> {
            double promedio = obtenerPromedioCalificacionesRestaurante(restauranteId);
            restaurante.setCalificacionPromedio(promedio);
            restauranteRepository.save(restaurante);
        });
    }
}
