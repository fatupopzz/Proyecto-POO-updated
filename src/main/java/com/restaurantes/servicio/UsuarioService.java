
package com.restaurantes.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantes.Repositorio.UsuarioRepository;
import com.restaurantes.modelo.Usuario;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public Optional<Usuario> crearUsuario(Usuario usuario) {
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
    
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}