package com.example.demo.service;

import com.example.demo.dto.entrada.categoria.CategoriaEntradaDto;
import com.example.demo.dto.salida.categoria.CategoriaSalidaDto;

import java.util.List;

public interface ICategoriaService {
    CategoriaSalidaDto registrarCategoria(CategoriaEntradaDto categoria);

    Void eliminarCategoriaByID(Long id);

    List<CategoriaSalidaDto> listarCategorias();
}
