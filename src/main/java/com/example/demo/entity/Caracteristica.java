package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy="caracteristicas")
    private List<Producto> productos;
    @Column
    private String nombre;
    @Column
    private Integer tipo;

    public Caracteristica() {}

    public Caracteristica(Long id, List<Producto> productos, String nombre, Integer tipo) {
        this.id = id;
        this.productos = productos;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "id=" + id +
                ", productos=" + productos +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
