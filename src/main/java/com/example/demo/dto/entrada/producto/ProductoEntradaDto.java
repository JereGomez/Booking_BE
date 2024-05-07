package com.example.demo.dto.entrada.producto;




import jakarta.validation.constraints.NotNull;
import java.util.List;

public class ProductoEntradaDto {

    @NotNull(message = "El nombre del producto no puede ser nulo")
    private String nombre;

    @NotNull(message = "La descripcion del producto no puede ser nulo")
    private String descripcion;

    @NotNull(message = "La lista de imagenes del producto no puede ser nula")
    private List<String> rutasImagenes;

    public ProductoEntradaDto() {
    }

    public ProductoEntradaDto(String nombre, String descripcion, List<String> rutasImagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutasImagenes = rutasImagenes;
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

    public void setRutasImagenes(List<String> rutasImagenes) {
        this.rutasImagenes = rutasImagenes;
    }

    @Override
    public String toString() {
        return "ProductoEntradaDto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rutasImagenes=" + rutasImagenes +
                '}';
    }
}
