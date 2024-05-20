/*package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
//@Table(name = "alojamiento")
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alojamiento_id;
    @OneToMany(mappedBy = "alojamiento")
    private List<Reserva> reservas;

    @OneToMany
    private List<Imagenes> imagenes;
    @OneToMany
    private List<Categoria> categoria;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Ubicacion ubicacion;
    @Column(length = 50)
    private String nombre;
    @Column(length = 200)
    private String descripcion;
    @Column(length = 50)
    private  String tipo_de_alojamiento;
    @Column(length = 50)
    private Long capacidad;
    @Column(length = 50)
    private String direccion;
    @Column(length = 50)
    private double precio;

    public Alojamiento() {
    }

    public Alojamiento(Long alojamiento_id, List<Reserva> reservas, List<Imagenes> imagenes, List<Categoria> categoria, Ubicacion ubicacion, String nombre, String descripcion, String tipo_de_alojamiento, Long capacidad, String direccion, double precio) {
        this.alojamiento_id = alojamiento_id;
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
        return alojamiento_id;
    }

    public void setId(Long id) {
        this.alojamiento_id = id;
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

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
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
                "alojamiento_id=" + alojamiento_id +
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