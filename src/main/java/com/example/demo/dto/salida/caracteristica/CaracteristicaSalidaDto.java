package com.example.demo.dto.salida.caracteristica;

public class CaracteristicaSalidaDto {
    private Long id;

    private String nombre;

    private Integer tipo;

    public CaracteristicaSalidaDto() {
    }

    public CaracteristicaSalidaDto(Long id, String nombre, Integer tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "CaracteristicaSalidaDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
