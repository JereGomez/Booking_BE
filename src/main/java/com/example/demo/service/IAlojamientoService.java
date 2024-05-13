package com.example.demo.service;

import com.example.demo.dto.entrada.alojamiento.AlojamientoEntradaDto;
import com.example.demo.dto.modificacion.alojamiento.AlojamientoModificacionEntradaDto;
import com.example.demo.dto.salida.alojamiento.AlojamientoSalidaDto;
import com.example.demo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IAlojamientoService {
    AlojamientoSalidaDto registrarAlojamiento(AlojamientoEntradaDto alojamiento);
    List<AlojamientoSalidaDto> listarAlojamientos();
    AlojamientoSalidaDto buscarAlojamientoPorId(Long id);
    void eliminarAlojamiento(Long id) throws ResourceNotFoundException;
    AlojamientoSalidaDto actualizarAlojamiento(AlojamientoModificacionEntradaDto alojamiento);
}
