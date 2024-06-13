package com.example.demo.service;

import com.example.demo.dto.entrada.reserva.ReservaEntradaDto;
import com.example.demo.dto.salida.reserva.ReservaSalidaDto;
import com.example.demo.exceptions.BadRequestException;

import java.util.List;

public interface IReservaService {
    ReservaSalidaDto registrarReserva(ReservaEntradaDto reserva) throws BadRequestException;
    List<ReservaSalidaDto> listarReservas();
}
