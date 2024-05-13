package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alojamiento_id")
    private Alojamiento alojamiento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
    private double precio;


    public Reserva() {
    }

    public Reserva(Long id, Alojamiento alojamiento, Usuario usuario, LocalDate fecha_inicio, LocalDate fecha_fin, String estado, double precio) {
        this.id = id;
        this.alojamiento = alojamiento;
        this.usuario = usuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
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
        return precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", alojamiento=" + alojamiento +
                ", usuario=" + usuario +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                '}';
    }
}
