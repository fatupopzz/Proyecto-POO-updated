package com.restaurantes.uvg.controladores.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String contraseña;
    private List<Long> restaurantesFavoritos;
    private List<Calificacion> calificaciones;

    public Usuario() {
        this.restaurantesFavoritos = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public Usuario(String nombre, String email, String contraseña) {
        this();
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    // Getters y setters (omitidos para brevedad)

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
    }

    //tener id
    public Long getId() {
        return id;
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