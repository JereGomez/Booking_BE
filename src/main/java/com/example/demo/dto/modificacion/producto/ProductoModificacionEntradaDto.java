package com.example.demo.dto.modificacion.producto;

import com.example.demo.dto.modificacion.categoria.CategoriaModificacionEntradaDto;
import com.example.demo.dto.modificacion.imagen.ImagenModificacionEntradaDto;
import com.example.demo.entity.Categoria;
import com.example.demo.entity.Imagen;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ProductoModificacionEntradaDto {

    @NotNull(message = "Debe proveerse el id del producto que se desea modificar")
    private Long id;
    @NotNull(message = "Debe proveerse el nombre del producto que se desea modificar")
    private String nombre;
    @NotNull(message = "Debe proveerse la descripcion del producto que se desea modificar")
    private String descripcion;
    @NotNull
    private Integer capacidad;
    @NotNull
    private Double precioNoche;

    @NotNull(message = "Debe proveerse las imagenes del producto que se desea modificar")
    private List<ImagenModificacionEntradaDto> imagenes;
    @NotNull
    private List<CategoriaModificacionEntradaDto> categorias;

    public ProductoModificacionEntradaDto() {
    }

    public ProductoModificacionEntradaDto(Long id, String nombre, String descripcion, Integer capacidad, Double precioNoche, List<ImagenModificacionEntradaDto> imagenes, List<CategoriaModificacionEntradaDto> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
        this.imagenes = imagenes;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long producto_id) {
        this.id = producto_id;
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


    public List<ImagenModificacionEntradaDto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenModificacionEntradaDto> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "ProductoModificacionDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rutasImagenes=" + imagenes +
                '}';
    }
}
