package com.example.demo.dto.entrada.ubicacion;

import java.math.BigDecimal;

public class UbicacionEntradaDto {
    private String pais;
    private String ciudad;
    private int codigoPostal;
    private String direccionExacta;
    private BigDecimal coordenadaGps;

    public UbicacionEntradaDto() {
    }

    public UbicacionEntradaDto(String pais, String ciudad, int codigoPostal, String direccionExacta, BigDecimal coordenadaGps) {
        this.pais = pais;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.direccionExacta = direccionExacta;
        this.coordenadaGps = coordenadaGps;
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }

    public BigDecimal getCoordenadaGps() {
        return coordenadaGps;
    }

    public void setCoordenadaGps(BigDecimal coordenadaGps) {
        this.coordenadaGps = coordenadaGps;
    }

    @Override
    public String toString() {
        return "ubicacionEntradaDto{" +
                "pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", direccionExacta='" + direccionExacta + '\'' +
                ", coordenadaGps=" + coordenadaGps +
                '}';
    }
}
