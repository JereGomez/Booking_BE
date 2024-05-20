package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pais;
    private String ciudad;
    private Long codigoPostal;
    private String direccion_exacta;
    private int coordenada_gps;

    public Ubicacion() {
    }

    public Ubicacion(Long id, String pais, String ciudad, Long codigoPostal, String direccion_exacta, int coordenada_gps) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.direccion_exacta = direccion_exacta;
        this.coordenada_gps = coordenada_gps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Long codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccion_exacta() {
        return direccion_exacta;
    }

    public void setDireccion_exacta(String direccion_exacta) {
        this.direccion_exacta = direccion_exacta;
    }

    public int getCoordenada_gps() {
        return coordenada_gps;
    }

    public void setCoordenada_gps(int coordenada_gps) {
        this.coordenada_gps = coordenada_gps;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "id=" + id +

                ", pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", direccion_exacta='" + direccion_exacta + '\'' +
                ", coordenada_gps=" + coordenada_gps +
                '}';
    }

}
