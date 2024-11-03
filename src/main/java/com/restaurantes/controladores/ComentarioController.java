package com.restaurantes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurantes.modelo.Comentario;
import com.restaurantes.servicio.ComentarioService;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Crear un nuevo comentario
    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        Comentario nuevoComentario = comentarioService.crearComentario(comentario);
        return ResponseEntity.ok(nuevoComentario);
    }

    // Obtener un comentario específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentario(@PathVariable Long id) {
        return comentarioService.obtenerComentario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Obtener todos los comentarios de un restaurante
    @GetMapping("/restaurante/{restauranteId}")
    public List<Comentario> obtenerComentariosPorRestaurante(@PathVariable Long restauranteId) {
        return comentarioService.obtenerComentariosPorRestaurante(restauranteId);
    }

    // Obtener todos los comentarios de un usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Comentario> obtenerComentariosPorUsuario(@PathVariable Long usuarioId) {
        return comentarioService.obtenerComentariosPorUsuario(usuarioId);
    }

    // Actualizar un comentario existente
    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(
            @PathVariable Long id, 
            @RequestBody Comentario comentario) {
        return comentarioService.actualizarComentario(id, comentario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un comentario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        if (comentarioService.eliminarComentario(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener comentarios recientes de un restaurante
    @GetMapping("/restaurante/{restauranteId}/recientes")
    public List<Comentario> obtenerComentariosRecientes(
            @PathVariable Long restauranteId,
            @RequestParam(defaultValue = "5") int limite) {
        return comentarioService.obtenerComentariosRecientes(restauranteId, limite);
    }

    // Obtener cantidad de comentarios por restaurante
    @GetMapping("/restaurante/{restauranteId}/contador")
    public ResponseEntity<Long> contarComentariosPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(comentarioService.contarComentariosPorRestaurante(restauranteId));
    }
}