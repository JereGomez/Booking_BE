package com.example.demo.entity;

import jakarta.persistence.*;

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
    @Column()
    private Integer capacidad;
    @Column()
    private Double precioNoche;
    @OneToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

   @OneToMany(cascade=CascadeType.ALL )
   @JoinColumn(name="producto_id",referencedColumnName="id")
    private List<Imagen> imagenes;

    @ManyToMany
    @JoinTable(
            name="categoria_has_producto",
            joinColumns = @JoinColumn(name="producto_id"),
            inverseJoinColumns = @JoinColumn(name="categoria_id")
    )
    private List<Categoria> categorias;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, Integer capacidad, Double precioNoche, Ubicacion ubicacion, List<Imagen> imagenes, List<Categoria> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
        this.ubicacion = ubicacion;
        this.imagenes = imagenes;
        this.categorias = categorias;
    }


    public Double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Double getPrecio_noche() {
        return precioNoche;
    }

    public void setPrecio_noche(Double precio_noche) {
        this.precioNoche = precio_noche;
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



    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", capacidad= " + capacidad +
                ", precio_noche= " + precioNoche +
                '}';
    }
}
