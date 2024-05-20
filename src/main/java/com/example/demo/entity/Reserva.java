package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
    private double precio_total;


    public Reserva() {
    }

    public Reserva(Long id, Producto alojamiento, Usuario usuario, LocalDate fecha_inicio, LocalDate fecha_fin, String estado, double precio_total) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.precio_total = precio_total;
    }

    public Long getId() {
        return id;
    }

    public Producto geProducto() {
        return producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public double getPrecio() {
        return precio_total;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", alojamiento=" + producto +
                ", usuario=" + usuario +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", estado='" + estado + '\'' +
                ", precio=" + precio_total +
                '}';
    }
}
