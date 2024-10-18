package com.restaurantes.servicio;

import com.restaurantes.modelo.Usuario;
import com.restaurantes.Repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
            .map(usuario -> {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setEmail(usuarioActualizado.getEmail());
                // No actualizamos la contraseña aquí por seguridad
                return usuarioRepository.save(usuario);
            });
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean cambiarContrasena(Long id, String nuevaContrasena) {
        return usuarioRepository.findById(id)
            .map(usuario -> {
                usuario.setContrasena(nuevaContrasena); // Asegúrate de encriptar la contraseña antes de guardarla
                usuarioRepository.save(usuario);
                return true;
            })
            .orElse(false);
    }
}