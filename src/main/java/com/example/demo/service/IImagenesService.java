package com.example.demo.service;

import com.example.demo.dto.entrada.imagenes.ImagenesEntradaDto;
import com.example.demo.dto.salida.imagenes.ImagenesSalidaDto;

public interface IImagenesService {
    ImagenesSalidaDto registrarImagenes(ImagenesEntradaDto imagen);
}
