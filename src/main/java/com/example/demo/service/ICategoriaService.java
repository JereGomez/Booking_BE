package com.example.demo.service;

import com.example.demo.dto.entrada.categoria.CategoriaEntradaDto;
import com.example.demo.dto.salida.categoria.CategoriaSalidaDto;

public interface ICategoriaService {
    CategoriaSalidaDto registrarCategoria(CategoriaEntradaDto categoria);
}
