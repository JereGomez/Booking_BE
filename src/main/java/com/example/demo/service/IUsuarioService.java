package com.example.demo.service;

import com.example.demo.dto.entrada.usuario.UsuarioEntradaDto;
import com.example.demo.dto.modificacion.usuario.UsuarioModificacionEntradaDto;
import com.example.demo.dto.salida.usuario.UsuarioSalidaDto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IUsuarioService {
    UsuarioSalidaDto registrarUsuario(UsuarioEntradaDto usuario)throws BadRequestException;
    List<UsuarioSalidaDto> listarUsuarios()throws ResourceNotFoundException;

    UsuarioSalidaDto buscarUsuarioPorId(Long id)throws ResourceNotFoundException;

    void eliminarUsuario(Long id) throws ResourceNotFoundException;

    UsuarioSalidaDto actualizarUsuario( UsuarioModificacionEntradaDto usuario)throws ResourceNotFoundException;
}
