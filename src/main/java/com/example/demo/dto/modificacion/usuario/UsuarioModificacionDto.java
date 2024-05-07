package com.example.demo.dto.modificacion.usuario;

import jakarta.validation.constraints.NotNull;

public class UsuarioModificacionDto {
    @NotNull(message = "Debe proveerse el id del usurio que se desea modificar")
    private Long id;
    @NotNull(message = "Debe proveerse el nombre del usuario que se desea modificar")
    private String nombre;
    @NotNull(message = "Debe proveerse el apellido del usuario que se desea modificar")
    private String apellido;

    public UsuarioModificacionDto() {
    }

    public UsuarioModificacionDto(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "UsuarioModificacionDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
