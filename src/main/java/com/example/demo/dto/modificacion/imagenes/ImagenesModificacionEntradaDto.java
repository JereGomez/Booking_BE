package com.example.demo.dto.modificacion.imagenes;

import jakarta.validation.constraints.NotNull;

public class ImagenesModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id de la imagen que se desea modificar")
    private Long id;
    @NotNull(message = "Debe proveerse el nombre de la imagen que se desea modificar")
    private String nombre;
    @NotNull(message = "Debe proveerse el tipo de archivo de la imagen que se desea modificar")
    private String tipo_de_archivo;
    @NotNull(message = "Debe proveerse la ruta de la imagen que se desea modificar")
    private String ruta_de_la_imagen;

    public ImagenesModificacionEntradaDto() {
    }

    public ImagenesModificacionEntradaDto(String nombre, String tipo_de_archivo, String ruta_de_la_imagen) {
        this.nombre = nombre;
        this.tipo_de_archivo = tipo_de_archivo;
        this.ruta_de_la_imagen = ruta_de_la_imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_de_archivo() {
        return tipo_de_archivo;
    }

    public void setTipo_de_archivo(String tipo_de_archivo) {
        this.tipo_de_archivo = tipo_de_archivo;
    }

    public String getRuta_de_la_imagen() {
        return ruta_de_la_imagen;
    }

    public void setRuta_de_la_imagen(String ruta_de_la_imagen) {
        this.ruta_de_la_imagen = ruta_de_la_imagen;
    }

    @Override
    public String toString() {
        return "ImagenesEntradaDto{" +
                "nombre='" + nombre + '\'' +
                ", tipo_de_archivo='" + tipo_de_archivo + '\'' +
                ", ruta_de_la_imagen='" + ruta_de_la_imagen + '\'' +
                '}';
    }
}
