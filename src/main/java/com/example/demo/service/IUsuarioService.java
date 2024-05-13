package com.example.demo.service;

import com.example.demo.dto.entrada.usuario.UsuarioEntradaDto;
import com.example.demo.dto.salida.usuario.UsuarioSalidaDto;

public interface IUsuarioService {
    UsuarioSalidaDto registrarUsuario(UsuarioEntradaDto usuario);
}
