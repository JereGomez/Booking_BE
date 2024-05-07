package com.example.demo.dto.entrada.producto;


import jakarta.validation.constraints.NotNull;

import java.awt.*;
import java.util.List;

public class ProductoEntradaDto {

    @NotNull(message = "El nombre del producto no puede ser nulo")
    private String nombre;
    @NotNull(message = "La descripcion del producto no puede ser nulo")
    private String descripcion;
    @NotNull(message = "La lista de imagenes del producto no puede ser nulo")
    private List<Image> listaDeImagenes;

    public ProductoEntradaDto() {
    }

    public ProductoEntradaDto(String nombre, String descripcion, List<Image> listaDeImagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaDeImagenes = listaDeImagenes;
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

    public List<Image> getListaDeImagenes() {
        return listaDeImagenes;
    }

    public void setListaDeImagenes(List<Image> listaDeImagenes) {
        this.listaDeImagenes = listaDeImagenes;
    }

    @Override
    public String toString() {
        return "ProductoEntradaDto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", listaDeImagenes=" + listaDeImagenes +
                '}';
    }
}
