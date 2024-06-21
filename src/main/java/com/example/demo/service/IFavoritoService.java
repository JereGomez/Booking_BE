package com.example.demo.service;

import com.example.demo.dto.entrada.favorito.FavoritoEntradaDto;
import com.example.demo.dto.salida.favorito.FavoritoSalidaDto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IFavoritoService {
    FavoritoSalidaDto registrarFavorito(FavoritoEntradaDto favorito) throws BadRequestException;

    List<FavoritoSalidaDto> listarFavoritosByusuario(Long id);

    FavoritoSalidaDto buscarFavoritoPorId(Long id);

    void eliminarFavorito(Long id) throws ResourceNotFoundException;
}
