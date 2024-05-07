package com.example.demo.dto.salida.producto;

import java.util.List;

public class ProductoSalidaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<String> rutasImagenes;

    public ProductoSalidaDto() {
    }

    public ProductoSalidaDto(Long id, String nombre, String descripcion,List<String> rutasImagenes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutasImagenes= rutasImagenes;
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

    public List<String> getRutasImagenes() {
        return rutasImagenes;
    }

    public void setRutasImagenes(List<String> rutasImagenes) {
        this.rutasImagenes = rutasImagenes;
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
        return "ProductoSalidaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rutasImagenes=" + rutasImagenes +
                '}';
    }
}
