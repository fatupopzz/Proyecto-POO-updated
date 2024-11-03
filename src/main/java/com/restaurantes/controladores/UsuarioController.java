package com.restaurantes.controlador;

import com.restaurantes.modelo.Usuario;
import com.restaurantes.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("El correo ya está en uso.");
        }

        // Encriptar la contraseña antes de guardarla
        nuevoUsuario.setContrasena(passwordEncoder.encode(nuevoUsuario.getContrasena()));

        usuarioRepository.save(nuevoUsuario);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario detallesUsuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNombre(detallesUsuario.getNombre());
            usuario.setEmail(detallesUsuario.getEmail());
            usuario.setContrasena(passwordEncoder.encode(detallesUsuario.getContrasena()));

            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuario actualizado exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
