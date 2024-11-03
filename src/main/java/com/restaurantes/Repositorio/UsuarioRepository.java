package com.restaurantes.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantes.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
