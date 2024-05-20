/*package com.example.demo.dto.entrada.alojamiento;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Imagenes;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.Ubicacion;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class AlojamientoEntradaDto {
    @NotNull
    private List<Reserva> reservas;

    @NotNull
    private List<Imagenes> imagenes;
    @NotNull
    private Categoria categoria;
    @NotNull
    private Ubicacion ubicacion;
    @NotNull
    private String nombre;
    @NotNull
    private String descripcion;
    @NotNull
    private  String tipo_de_alojamiento;
    @NotNull
    private Long capacidad;
    @NotNull
    private String direccion;
    @NotNull
    private double precio;

    public AlojamientoEntradaDto() {
    }

    public AlojamientoEntradaDto( List<Reserva> reservas, List<Imagenes> imagenes, Categoria categoria, Ubicacion ubicacion, String nombre, String descripcion, String tipo_de_alojamiento, Long capacidad, String direccion, double precio) {

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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Imagenes>  getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagenes> imagenes) {
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
        return "Alojamiento{" +

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
*/