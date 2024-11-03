package com.restaurantes.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantes.Repositorio.ComentarioRepository;
import com.restaurantes.modelo.Comentario;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario crearComentario(Comentario comentario) {
        comentario.setFechaCreacion(LocalDateTime.now());
        return comentarioRepository.save(comentario);
    }

    public Optional<Comentario> obtenerComentario(Long id) {
        return comentarioRepository.findById(id);
    }

    public List<Comentario> obtenerComentariosPorRestaurante(Long restauranteId) {
        return comentarioRepository.findByRestauranteIdOrderByFechaCreacionDesc(restauranteId);
    }

    public List<Comentario> obtenerComentariosPorUsuario(Long usuarioId) {
        return comentarioRepository.findByUsuarioIdOrderByFechaCreacionDesc(usuarioId);
    }

    public Optional<Comentario> actualizarComentario(Long id, Comentario comentarioActualizado) {
        return comentarioRepository.findById(id)
            .map(comentarioExistente -> {
                comentarioExistente.setContenido(comentarioActualizado.getContenido());
                comentarioExistente.setFechaModificacion(LocalDateTime.now());
                return comentarioRepository.save(comentarioExistente);
            });
    }

    public boolean eliminarComentario(Long id) {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Comentario> obtenerComentariosRecientes(Long restauranteId, int limite) {
        return comentarioRepository.findTopByRestauranteIdOrderByFechaCreacionDesc(restauranteId, limite);
    }

    public long contarComentariosPorRestaurante(Long restauranteId) {
        return comentarioRepository.countByRestauranteId(restauranteId);
    }
}