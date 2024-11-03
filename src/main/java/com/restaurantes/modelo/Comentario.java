package com.restaurantes.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion;

    @PreUpdate
    protected void onUpdate() {
        fechaModificacion = LocalDateTime.now();
    }

    //set fecha de creacion
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //set fecha de modificacion
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    //get id
    public Long getId() {
        return id;
    }

    //get contenido
    public String getContenido() {
        return contenido;
    }

    //set contenido
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    //get fecha de creacion
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    //get usuario
    public Usuario getUsuario() {
        return usuario;
    }
    //set usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //get restaurante
    public Restaurante getRestaurante() {
        return restaurante;
    }

    //set restaurante
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    //get fecha de modificacion
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }



}