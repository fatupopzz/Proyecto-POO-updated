package com.restaurantes.uvg.controladores;

import com.restaurantes.uvg.controladores.modelo.Calificacion;
//import com.restaurantes.uvg.servicio.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion nuevaCalificacion = calificacionService.crearCalificacion(calificacion);
        return ResponseEntity.ok(nuevaCalificacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calificacion> obtenerCalificacion(@PathVariable Long id) {
        return calificacionService.obtenerCalificacion(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/restaurante/{restauranteId}")
    public List<Calificacion> obtenerCalificacionesPorRestaurante(@PathVariable Long restauranteId) {
        return calificacionService.obtenerCalificacionesPorRestaurante(restauranteId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion) {
        return calificacionService.actualizarCalificacion(id, calificacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable Long id) {
        if (calificacionService.eliminarCalificacion(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/promedio/restaurante/{restauranteId}")
    public ResponseEntity<Double> obtenerPromedioCalificacionesRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(calificacionService.obtenerPromedioCalificacionesRestaurante(restauranteId));
    }
}
