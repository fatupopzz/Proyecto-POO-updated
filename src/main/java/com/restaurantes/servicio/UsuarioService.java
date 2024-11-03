// src/main/java/com/uvg/restaurantes/service/UsuarioService.java
package com.uvg.restaurantes.service;

import com.uvg.restaurantes.model.Usuario;
import com.uvg.restaurantes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        // Verificar si el email ya existe
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new RuntimeException("El email ya está registrado");
        }
        
        // Usar el procedimiento almacenado para crear el usuario
        usuarioRepository.crearUsuarioConProcedimiento(
            usuario.getNombre(),
            usuario.getEmail(),
            usuario.getContrasena()
        );
        
        // Retornar el usuario creado
        return usuarioRepository.findByEmail(usuario.getEmail());
    }
    
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}