package com.example.demo.service;

import com.example.demo.dto.entrada.alojamiento.AlojamientoEntradaDto;
import com.example.demo.dto.modificacion.alojamiento.AlojamientoModificacionEntradaDto;
import com.example.demo.dto.salida.alojamiento.AlojamientoSalidaDto;
import com.example.demo.entity.Alojamiento;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.AlojamientoRespository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlojamientoService implements IAlojamientoService{
    private final Logger LOGGER = LoggerFactory.getLogger(AlojamientoService.class);
    private AlojamientoRespository alojamientoRepository;
    private ModelMapper modelMapper;
    @Autowired
    public AlojamientoService(AlojamientoRespository alojamientoRepository, ModelMapper modelMapper) {
        this.alojamientoRepository = alojamientoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }


    @Override
    public AlojamientoSalidaDto registrarAlojamiento(AlojamientoEntradaDto alojamiento) {
        // Verificar si ya existe un alojamiento con el mismo nombre
        String nombreDelAlojamiento = alojamiento.getNombre();
        if (alojamientoRepository.findByNombre(nombreDelAlojamiento).isPresent()) {
            throw new IllegalArgumentException("El alojamiento con nombre '" + nombreDelAlojamiento + "' ya existe");
        }
        LOGGER.info("AlojamientoEntradaDto: " + JsonPrinter.toString(alojamiento));
        Alojamiento alojamientoEntidad = modelMapper.map(alojamiento, Alojamiento.class);

        //mandamos a persistir a la capa dao y obtenemos una entidad
        Alojamiento alojamientoAPersistir = alojamientoRepository.save(alojamientoEntidad);
        //transformamos la entidad obtenida en salidaDto
        AlojamientoSalidaDto alojamientoSalidaDto = modelMapper.map(alojamientoAPersistir, AlojamientoSalidaDto.class);
        LOGGER.info("AlojamientoSalidaDto: " + JsonPrinter.toString(alojamientoSalidaDto));
        return alojamientoSalidaDto;

    }

    @Override
    public List<AlojamientoSalidaDto> listarAlojamientos() {
        List<AlojamientoSalidaDto> alojamientoSalidaDtos = alojamientoRepository.findAll()
                .stream()
                .map(alojamiento -> modelMapper.map(alojamiento, AlojamientoSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los alojamientos: {}", JsonPrinter.toString(alojamientoSalidaDtos));
        return alojamientoSalidaDtos;
    }

    @Override
    public AlojamientoSalidaDto buscarAlojamientoPorId(Long id) {
        Alojamiento alojamientoBuscado = alojamientoRepository.findById(id).orElse(null);
        AlojamientoSalidaDto alojamientoEncontrado = null;

        LOGGER.debug("Alojamiento buscado con ID {}: {}", id, alojamientoBuscado);
        if(alojamientoBuscado != null){
            alojamientoEncontrado =  modelMapper.map(alojamientoBuscado, AlojamientoSalidaDto.class);
            LOGGER.info("Alojamiento encontrado: {}", JsonPrinter.toString(alojamientoEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return alojamientoEncontrado;
    }

    @Override
    public void eliminarAlojamiento(Long id)throws ResourceNotFoundException {
        if (buscarAlojamientoPorId(id) != null) {
            alojamientoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el alojamiento con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el alojamiento con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el alojamiento con id " + id);
        }
    }

    @Override
    public AlojamientoSalidaDto actualizarAlojamiento(AlojamientoModificacionEntradaDto alojamiento) {
        Alojamiento alojamientoRecibido = modelMapper.map(alojamiento, Alojamiento.class);
        Alojamiento alojamientoAActualizar = alojamientoRepository.findById(alojamientoRecibido.getId()).orElse(null);

        AlojamientoSalidaDto alojamientoSalidaDto = null;

        if (alojamientoAActualizar != null) {
            alojamientoAActualizar = alojamientoRecibido;
            alojamientoRepository.save(alojamientoAActualizar);

            alojamientoSalidaDto = modelMapper.map(alojamientoAActualizar, AlojamientoSalidaDto.class);
            LOGGER.warn("Alojamiento actualizado: {}", JsonPrinter.toString(alojamientoSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el alojamiento porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }


        return alojamientoSalidaDto;
    }
    private void configureMapping(){
        modelMapper.typeMap(AlojamientoEntradaDto.class, Alojamiento.class);

        modelMapper.typeMap(Alojamiento.class, AlojamientoSalidaDto.class);

    }
}
