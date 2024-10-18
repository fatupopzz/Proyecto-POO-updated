package com.restaurantes.Repositorio;

import com.restaurantes.modelo.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByRestauranteId(Long restauranteId);

    @Query("SELECT AVG(c.puntuacion) FROM Calificacion c WHERE c.restaurante.id = :restauranteId")
    double calcularPromedioCalificacionesPorRestaurante(@Param("restauranteId") Long restauranteId);
}
