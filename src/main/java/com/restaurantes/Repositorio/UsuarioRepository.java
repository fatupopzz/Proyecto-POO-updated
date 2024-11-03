package com.restaurantes.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurantes.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    void crearUsuarioConProcedimiento(String nombre, String email, String contrasena);
    Optional<Usuario> findByEmail(String email);

}
