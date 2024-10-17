package com.restaurantes.uvg.servicio;

import com.restaurantes.uvg.controladores.modelo.Restaurante;
import com.restaurantes.uvg.repositorio.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Restaurante> actualizarRestaurante(Long id, Restaurante restauranteActualizado) {
        return restauranteRepository.findById(id)
            .map(restaurante -> {
                restaurante.setNombre(restauranteActualizado.getNombre());
                restaurante.setDireccion(restauranteActualizado.getDireccion());
                restaurante.setTipoComida(restauranteActualizado.getTipoComida());
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
        return restauranteRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Restaurante> obtenerRestaurantesMejorCalificados() {
        return restauranteRepository.findTop10ByOrderByCalificacionPromedioDesc();
    }
}