package com.restaurantes.uvg.servicio;

import com.restaurantes.uvg.controladores.modelo.Restaurante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    private List<Restaurante> restaurantes = new ArrayList<>();

    public Restaurante crearRestaurante(Restaurante restaurante) {
        restaurante.setId((long) (restaurantes.size() + 1));
        restaurantes.add(restaurante);
        return restaurante;
    }

    public Optional<Restaurante> obtenerRestaurante(Long id) {
        return restaurantes.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public List<Restaurante> listarRestaurantes() {
        return restaurantes;
    }

    public Optional<Restaurante> actualizarRestaurante(Long id, Restaurante restaurante) {
        Optional<Restaurante> restauranteExistente = obtenerRestaurante(id);
        if (restauranteExistente.isPresent()) {
            Restaurante r = restauranteExistente.get();
            r.setNombre(restaurante.getNombre());
            r.setDireccion(restaurante.getDireccion());
            r.setTipoComida(restaurante.getTipoComida());
            return Optional.of(r);
        }
        return Optional.empty();
    }

    public boolean eliminarRestaurante(Long id) {
        return restaurantes.removeIf(r -> r.getId().equals(id));
    }

    // Método para buscar restaurantes por nombre
    public List<Restaurante> buscarRestaurantesPorNombre(String nombre) {
        return restaurantes.stream()
                .filter(r -> r.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .toList();
    }
    // Método para obtener los restaurantes mejor calificados
    public List<Restaurante> obtenerRestaurantesMejorCalificados() {
        return restaurantes.stream()
                .sorted((r1, r2) -> Double.compare(r2.getCalificacionPromedio(), r1.getCalificacionPromedio()))
                .toList();
    }


}