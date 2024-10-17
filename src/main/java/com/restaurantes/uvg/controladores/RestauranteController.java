package com.restaurantes.uvg.controladores;

import com.restaurantes.uvg.controladores.modelo.Restaurante;
import com.restaurantes.uvg.servicio.RestauranteService;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> crearRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante nuevoRestaurante = restauranteService.crearRestaurante(restaurante);
        return ResponseEntity.ok(nuevoRestaurante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> obtenerRestaurante(@PathVariable Long id) {
        return restauranteService.obtenerRestaurante(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Restaurante> listarRestaurantes() {
        return restauranteService.listarRestaurantes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> actualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        return restauranteService.actualizarRestaurante(id, restaurante)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRestaurante(@PathVariable Long id) {
        if (restauranteService.eliminarRestaurante(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public List<Restaurante> buscarRestaurantes(@RequestParam String nombre) {
        return restauranteService.buscarRestaurantesPorNombre(nombre);
    }

    @GetMapping("/top-rated")
    public List<Restaurante> obtenerRestaurantesMejorCalificados() {
        return restauranteService.obtenerRestaurantesMejorCalificados();
    }
}