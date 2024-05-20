package com.example.demo.dto.salida.reserva;


import com.example.demo.entity.Producto;
import com.example.demo.entity.Usuario;

import java.time.LocalDate;

public class ReservaSalidaDto {
    private Producto alojamiento;
    private Usuario usuario;

    private LocalDate fecha_inicio;

    private LocalDate fecha_fin;
    private String estado;
    private double precio;

    public ReservaSalidaDto() {
    }

    public ReservaSalidaDto(Producto alojamiento, Usuario usuario, LocalDate fecha_inicio, LocalDate fecha_fin, String estado, double precio) {
        this.alojamiento = alojamiento;
        this.usuario = usuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.precio = precio;
    }

    public Producto getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Producto alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ReservaSalidaDto{" +
                "alojamiento=" + alojamiento +
                ", usuario=" + usuario +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                '}';
    }
}
