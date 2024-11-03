package com.restaurantes.repositorio;

import com.restaurantes.modelo.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Métodos adicionales personalizados si es necesario
}