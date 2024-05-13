package com.example.demo.dto.entrada.reserva;

import com.example.demo.dto.salida.alojamiento.AlojamientoSalidaDto;
import com.example.demo.dto.salida.usuario.UsuarioSalidaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;

public class ReservaEntradaDto {
    private AlojamientoSalidaDto alojamiento;
    private UsuarioSalidaDto usuario;
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate fecha_inicio;
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate fecha_fin;
    private String estado;
    private double precio;

    public ReservaEntradaDto() {
    }

    public ReservaEntradaDto(AlojamientoSalidaDto alojamiento, UsuarioSalidaDto usuario, LocalDate fecha_inicio, LocalDate fecha_fin, String estado, double precio) {
        this.alojamiento = alojamiento;
        this.usuario = usuario;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.precio = precio;
    }

    public AlojamientoSalidaDto getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(AlojamientoSalidaDto alojamiento) {
        this.alojamiento = alojamiento;
    }

    public UsuarioSalidaDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSalidaDto usuario) {
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
        return "ReservaEntradaDto{" +
                "alojamiento=" + alojamiento +
                ", usuario=" + usuario +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                '}';
    }
}
