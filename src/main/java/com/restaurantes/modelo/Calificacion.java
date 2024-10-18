package com.restaurantes.modelo;

import java.time.LocalDateTime;

public class Calificacion {
    private Long id;
    private Usuario usuario;
    private Restaurante restaurante;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fecha;

    public Calificacion() {
        this.fecha = LocalDateTime.now();
    }

    public Calificacion(Usuario usuario, Restaurante restaurante, int puntuacion, String comentario) {
        this();
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + id +
                ", usuario=" + usuario.getId() +
                ", restaurante=" + restaurante.getId() +
                ", puntuacion=" + puntuacion +
                ", comentario='" + comentario + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
