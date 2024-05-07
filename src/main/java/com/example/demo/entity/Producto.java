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
    private List<Image> listaDeImagenes;

    public Producto() {
    }

    public Producto(Long id,String nombre, String descripcion, List<Image> listaDeImagenes) {
        this.id= id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaDeImagenes = listaDeImagenes;
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

    public List<Image> getListaDeImagenes() {
        return listaDeImagenes;
    }

    public void setListaDeImagenes(List<Image> listaDeImagenes) {
        this.listaDeImagenes = listaDeImagenes;
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
                ", listaDeImagenes=" + listaDeImagenes +
                '}';
    }
}
