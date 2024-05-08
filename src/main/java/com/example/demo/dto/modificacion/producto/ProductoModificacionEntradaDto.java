package com.example.demo.dto.modificacion.producto;

import jakarta.validation.constraints.NotNull;

import java.awt.*;
import java.util.List;

public class ProductoModificacionEntradaDto {

    @NotNull(message = "Debe proveerse el id del producto que se desea modificar")
    private Long id;
    @NotNull(message = "Debe proveerse el nombre del producto que se desea modificar")
    private String nombre;
    @NotNull(message = "Debe proveerse la descripcion del producto que se desea modificar")
    private String descripcion;
    @NotNull(message = "Debe proveerse las imagenes del producto que se desea modificar")
    private List<String> rutasImagenes;

    public ProductoModificacionEntradaDto() {
    }

    public ProductoModificacionEntradaDto(Long id, String nombre, String descripcion, List<String> rutasImagenes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutasImagenes = rutasImagenes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getRutasImagenes() {
        return rutasImagenes;
    }

    public void setListaDeImagenes(List<String> rutasImagenes) {
        this.rutasImagenes = rutasImagenes;
    }

    @Override
    public String toString() {
        return "ProductoModificacionDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rutasImagenes=" + rutasImagenes+
                '}';
    }
}
