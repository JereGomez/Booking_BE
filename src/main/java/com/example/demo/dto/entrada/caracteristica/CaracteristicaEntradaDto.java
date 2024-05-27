package com.example.demo.dto.entrada.caracteristica;

public class CaracteristicaEntradaDto {
    private String nombre;
    private String tipo;

    public CaracteristicaEntradaDto() {
    }

    public CaracteristicaEntradaDto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CaracteristicaEntradaDto{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
