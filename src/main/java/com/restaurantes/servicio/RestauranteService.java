package com.restaurantes.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantes.Repositorio.RestauranteRepository;
import com.restaurantes.modelo.Restaurante;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante crearRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Optional<Restaurante> obtenerRestaurante(Long id) {
        return restauranteRepository.findById(id);
    }

    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> actualizarRestaurante(Long id, Restaurante detallesRestaurante) {
        return restauranteRepository.findById(id).map(restaurante -> {
            restaurante.setNombre(detallesRestaurante.getNombre());
            restaurante.setDireccion(detallesRestaurante.getDireccion());
            restaurante.setTipoComida(detallesRestaurante.getTipoComida());
            return restauranteRepository.save(restaurante);
        });
    }

    public boolean eliminarRestaurante(Long id) {
        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Restaurante> buscarRestaurantesPorNombre(String nombre) {
        return restauranteRepository.findByNombreContaining(nombre);
    }

    public List<Restaurante> obtenerRestaurantesMejorCalificados() {
        return restauranteRepository.findByCalificacionPromedioGreaterThan(4.0);
    }
}
