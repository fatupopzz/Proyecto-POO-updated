package com.restaurantes.modelo;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    private String tipoComida;

    @Column(name = "calificacion_promedio")
    private Double calificacionPromedio = 0.0;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurante_id")
    private List<Calificacion> calificaciones;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(Calificacion calificacion) {
        this.calificaciones.add(calificacion);
        actualizarCalificacionPromedio();
    }

    private void actualizarCalificacionPromedio() {
        if (calificaciones.isEmpty()) {
            this.calificacionPromedio = 0.0;
        } else {
            double suma = calificaciones.stream()
                    .mapToDouble(Calificacion::getPuntuacion)
                    .sum();
            this.calificacionPromedio = suma / calificaciones.size();
        }
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipoComida='" + tipoComida + '\'' +
                ", calificacionPromedio=" + calificacionPromedio +
                '}';
    }
}