package com.restaurantes.modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @ElementCollection
    @CollectionTable(name = "restaurantes_favoritos", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "restaurante_id")
    private List<Long> restaurantesFavoritos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calificacion> calificaciones;

    public Usuario() {
        this.restaurantesFavoritos = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public Usuario(String nombre, String email, String contrasena) {
        this();
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Long> getRestaurantesFavoritos() {
        return restaurantesFavoritos;
    }

    public void setRestaurantesFavoritos(List<Long> restaurantesFavoritos) {
        this.restaurantesFavoritos = restaurantesFavoritos;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    // Métodos adicionales

    public void agregarRestauranteFavorito(Long restauranteId) {
        if (!this.restaurantesFavoritos.contains(restauranteId)) {
            this.restaurantesFavoritos.add(restauranteId);
        }
    }

    public void eliminarRestauranteFavorito(Long restauranteId) {
        this.restaurantesFavoritos.remove(restauranteId);
    }

    public void agregarCalificacion(Calificacion calificacion) {
        this.calificaciones.add(calificacion);
        calificacion.setUsuario(this);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", restaurantesFavoritos=" + restaurantesFavoritos +
                ", calificaciones=" + calificaciones +
                '}';
    }
}