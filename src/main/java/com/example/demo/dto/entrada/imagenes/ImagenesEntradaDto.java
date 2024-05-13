package com.example.demo.dto.entrada.imagenes;

public class ImagenesEntradaDto {
    private String nombre;
    private String tipo_de_archivo;
    private String ruta_de_la_imagen;

    public ImagenesEntradaDto() {
    }

    public ImagenesEntradaDto(String nombre, String tipo_de_archivo, String ruta_de_la_imagen) {
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
