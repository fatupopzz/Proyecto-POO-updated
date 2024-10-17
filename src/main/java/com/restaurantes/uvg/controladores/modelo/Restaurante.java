package com.restaurantes.uvg.controladores.modelo;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private Long id;
    private String nombre;
    private String direccion;
    private String tipoComida;
    private double calificacionPromedio;
    private List<Calificacion> calificaciones;

    public Restaurante() {
        this.calificaciones = new ArrayList<>();
    }

    public Restaurante(String nombre, String direccion, String tipoComida) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoComida = tipoComida;
        this.calificacionPromedio = 0.0;
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