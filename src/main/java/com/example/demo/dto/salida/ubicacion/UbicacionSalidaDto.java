package com.example.demo.dto.salida.ubicacion;

import java.math.BigDecimal;

public class UbicacionSalidaDto {
    private Long id;
    private String pais;
    private String ciudad;
    private int codigoPostal;
    private String direccionExacta;
    private BigDecimal coordenadaGps;

    public UbicacionSalidaDto() {
    }


    public UbicacionSalidaDto(String pais, String ciudad, int codigoPostal, String direccionExacta, BigDecimal coordenadaGps, Long id) {
        this.id = id;
        this.pais = pais;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.direccionExacta = direccionExacta;
        this.coordenadaGps = coordenadaGps;
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
        return "UbicacionSalidaDto{" +
                "pais='" + pais + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", direccionExacta='" + direccionExacta + '\'' +
                ", coordenadaGps=" + coordenadaGps +
                '}';
    }
}
