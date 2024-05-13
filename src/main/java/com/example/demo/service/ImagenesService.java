package com.example.demo.service;

import com.example.demo.dto.entrada.imagenes.ImagenesEntradaDto;
import com.example.demo.dto.salida.imagenes.ImagenesSalidaDto;
import com.example.demo.entity.Imagenes;
import com.example.demo.repository.ImagenesRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenesService implements IImagenesService {
    private final Logger LOGGER = LoggerFactory.getLogger(ImagenesService.class);
    private ImagenesRepository imagenesRepository;
    private ModelMapper modelMapper;
    @Autowired
    public ImagenesService(ImagenesRepository imagenesRepository, ModelMapper modelMapper) {
        this.imagenesRepository = imagenesRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }
    @Override
    public ImagenesSalidaDto registrarImagenes(ImagenesEntradaDto imagen) {
        // Verificar si ya existe un alojamiento con el mismo nombre
        String nombreDelaImagen = imagen.getNombre();
        if (imagenesRepository.findByNombre(nombreDelaImagen).isPresent()) {
            throw new IllegalArgumentException("La categoria con nombre '" + nombreDelaImagen + "' ya existe");
        }
        LOGGER.info("imagenEntradaDto: " + JsonPrinter.toString(imagen));
        Imagenes imagenEntidad = modelMapper.map(imagen, Imagenes.class);

        //mandamos a persistir a la capa dao y obtenemos una entidad
        Imagenes imagenesAPersistir = imagenesRepository.save(imagenEntidad);
        //transformamos la entidad obtenida en salidaDto
        ImagenesSalidaDto imagenSalidaDto = modelMapper.map(imagenesAPersistir, ImagenesSalidaDto.class);
        LOGGER.info("ImagenesSalidaDto: " + JsonPrinter.toString(imagenSalidaDto));
        return imagenSalidaDto ;

    }
    private void configureMapping(){
        modelMapper.typeMap(ImagenesEntradaDto.class, Imagenes.class);

        modelMapper.typeMap(Imagenes.class, ImagenesSalidaDto.class);

    }
}
