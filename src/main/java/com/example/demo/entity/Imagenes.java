package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Imagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nombre;
    @Column(length = 20)
    private String tipo_de_archivo;
    @Column(length = 150)
    private String ruta_de_la_imagen;

    public Imagenes() {
    }

    public Imagenes(Long id, String nombre, String tipo_imagen, String ruta) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_de_archivo= tipo_imagen;
        this.ruta_de_la_imagen = ruta;

    }



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

    public String getTipo_de_archivo() {
        return tipo_de_archivo;
    }

    public void setTipo_de_archivo(String tipo_imagen) {
        this.tipo_de_archivo = tipo_imagen;
    }

    public String getRuta_de_la_imagen() {
        return ruta_de_la_imagen;
    }

    public void setRuta(String ruta_de_la_imagen) {
        this.ruta_de_la_imagen = ruta_de_la_imagen;
    }



    @Override
    public String toString() {
        return "Imagenes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo_de_archivo='" + tipo_de_archivo + '\'' +
                ", ruta_de_la_imagen='" + ruta_de_la_imagen + '\'' +

                '}';
    }
}
