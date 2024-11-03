package com.restaurantes.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantes.modelo.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByRestauranteIdOrderByFechaCreacionDesc(Long restauranteId);
    
    List<Comentario> findByUsuarioIdOrderByFechaCreacionDesc(Long usuarioId);
    
    @Query(value = "SELECT c FROM Comentario c WHERE c.restaurante.id = ?1 ORDER BY c.fechaCreacion DESC LIMIT ?2")
    List<Comentario> findTopByRestauranteIdOrderByFechaCreacionDesc(Long restauranteId, int limite);
    
    long countByRestauranteId(Long restauranteId);
}