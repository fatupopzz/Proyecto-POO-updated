package com.restaurantes.Repositorio;

import com.restaurantes.modelo.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Restaurante> findByNombreContainingIgnoreCase(String nombre);
    List<Restaurante> findTop10ByOrderByCalificacionPromedioDesc();
}
