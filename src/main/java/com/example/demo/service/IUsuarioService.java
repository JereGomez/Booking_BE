package com.example.demo.service;

import com.example.demo.dto.entrada.usuario.UsuarioEntradaDto;
import com.example.demo.dto.modificacion.usuario.UsuarioModificacionEntradaDto;
import com.example.demo.dto.salida.usuario.UsuarioSalidaDto;
import com.example.demo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IUsuarioService {
    UsuarioSalidaDto registrarUsuario(UsuarioEntradaDto usuario);
    List<UsuarioSalidaDto> listarUsuarios();

    UsuarioSalidaDto buscarUsuarioPorId(Long id);

    void eliminarUsuario(Long id) throws ResourceNotFoundException;

    UsuarioSalidaDto actualizarUsuario( UsuarioModificacionEntradaDto usuario,Long id);
}
