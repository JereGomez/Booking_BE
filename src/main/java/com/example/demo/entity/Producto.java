package com.example.demo.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.List;
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;
    @Column(length = 200)
    private String descripcion;

    @Column(length = 200)
    private List<String> rutasImagenes;

    public Producto() {
    }

    public Producto(Long id,String nombre, String descripcion, List<String> rutasImagenes) {
        this.id= id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutasImagenes = rutasImagenes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getRutasImagenes() {
        return rutasImagenes;
    }

    public void setRutasImagenes(List<String> rutasImagenes) {
        this.rutasImagenes = rutasImagenes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rutasImagenes=" + rutasImagenes +
                '}';
    }
}
