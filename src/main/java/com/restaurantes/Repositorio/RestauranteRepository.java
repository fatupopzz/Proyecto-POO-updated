package com.restaurantes.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantes.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    List<Restaurante> findByNombreContaining(String nombre);
    List<Restaurante> findByCalificacionPromedioGreaterThan(double d);

}