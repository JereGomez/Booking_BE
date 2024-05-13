package com.example.demo.dto.modificacion.alojamiento;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Imagenes;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.Ubicacion;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class AlojamientoModificacionEntradaDto {
    @NotNull(message = "el campo id no puede estar nulo")
    private Long id;
    @NotNull(message = "el campo reservas no puede estar nulo")
    private List<Reserva> reservas;

    @NotNull(message = "el campo imagenes no puede estar nulo")
    private Imagenes imagenes;
    @NotNull(message = "el campo categoria no puede estar nulo")
    private Categoria categoria;
    @NotNull(message = "el campo ubicacion no puede estar nulo")
    private Ubicacion ubicacion;
    @NotNull(message = "el campo nombre no puede estar nulo")
    private String nombre;
    @NotNull(message = "el campo descripcion no puede estar nulo")
    private String descripcion;
    @NotNull(message = "el campo tipo de alojamiento no puede estar nulo")
    private  String tipo_de_alojamiento;
    @NotNull(message = "el campo capacidad no puede estar nulo")
    private Long capacidad;
    @NotNull(message = "el campo direccion no puede esta rnulo")
    private String direccion;
    @NotNull(message = "el campo precio no puede estar nulo")
    private double precio;

    public AlojamientoModificacionEntradaDto() {
    }

    public AlojamientoModificacionEntradaDto(Long id, List<Reserva> reservas, Imagenes imagenes, Categoria categoria, Ubicacion ubicacion, String nombre, String descripcion, String tipo_de_alojamiento, Long capacidad, String direccion, double precio) {
        this.id=id;
        this.reservas = reservas;
        this.imagenes = imagenes;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_de_alojamiento = tipo_de_alojamiento;
        this.capacidad = capacidad;
        this.direccion = direccion;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Imagenes getImagenes() {
        return imagenes;
    }

    public void setImagenes(Imagenes imagenes) {
        this.imagenes = imagenes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
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

    public String getTipo_de_alojamiento() {
        return tipo_de_alojamiento;
    }

    public void setTipo_de_alojamiento(String tipo_de_alojamiento) {
        this.tipo_de_alojamiento = tipo_de_alojamiento;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "AlojamientoModificacionEntradaDto{" +
                ", id=" + id +
                ", reservas=" + reservas +
                ", imagenes=" + imagenes +
                ", categoria=" + categoria +
                ", ubicacion=" + ubicacion +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo_de_alojamiento='" + tipo_de_alojamiento + '\'' +
                ", capacidad=" + capacidad +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
