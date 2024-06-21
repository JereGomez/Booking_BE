package com.example.demo.service;

import com.example.demo.dto.entrada.favorito.FavoritoEntradaDto;
import com.example.demo.dto.entrada.imagen.ImagenEntradaDto;
import com.example.demo.dto.salida.favorito.FavoritoSalidaDto;
import com.example.demo.dto.salida.imagen.ImagenSalidaDto;
import com.example.demo.entity.Favorito;
import com.example.demo.entity.Imagen;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.FavoritoRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class FavoritoService implements IFavoritoService{
    private final Logger LOGGER = LoggerFactory.getLogger(FavoritoService.class);
    @Autowired
    private FavoritoRepository favoritoRepository;
    private ModelMapper modelMapper;
    private ImagenService imagenService;

    @Autowired
    public FavoritoService(FavoritoRepository favoritoRepository, ModelMapper modelMapper, ImagenService imagenService) {
        this.favoritoRepository = favoritoRepository;
        this.modelMapper = modelMapper;
        this.imagenService=imagenService;
        configureMapping();
    }

    @Override
    public FavoritoSalidaDto registrarFavorito(FavoritoEntradaDto favorito) throws BadRequestException {
        LOGGER.info("FavoritoEntradaDto: " + JsonPrinter.toString(favorito));
        Favorito favoritoEntidad = modelMapper.map(favorito, Favorito.class);
        boolean favoritoExiste = chequearExistencia(favoritoEntidad);
        if(favoritoExiste){
            LOGGER.error("Ya existe un favorito con ese nombre{}", favorito.getNombre());
            BadRequestException exception = new BadRequestException("Ya existe un favorito con ese nombre ${favorito.getNombre()}");
            throw exception;
        }
        else{
            //mandamos a persistir a la capa dao y obtenemos una entidad
            Favorito favoritoAPersistir = favoritoRepository.save(favoritoEntidad);
            List<ImagenSalidaDto> imagenesSalida = new ArrayList<ImagenSalidaDto>();
            //transformamos la entidad obtenida en salidaDto
            FavoritoSalidaDto favoritoSalidaDto = modelMapper.map(favoritoAPersistir, FavoritoSalidaDto.class);
            //productoSalidaDto.setImagenes(imagenesSalida);
            LOGGER.info("FavoritoSalidaDto: " + JsonPrinter.toString(favoritoSalidaDto));
            return favoritoSalidaDto;
        }
    }

    @Override
    public List<FavoritoSalidaDto> listarFavoritosByusuario(Long id) {

        List<FavoritoSalidaDto> favoritoSalidaDtos = favoritoRepository.findAll()
                .stream()
                .map(favorito -> modelMapper.map(favorito, FavoritoSalidaDto.class))
                .toList();
        for(FavoritoSalidaDto fav : favoritoSalidaDtos){
            if(!(fav.getUsuario().getId() == id)){
                favoritoSalidaDtos.remove(fav);
            }
        }
        LOGGER.info("Listado de favoritos: {}", JsonPrinter.toString(favoritoSalidaDtos));
        return favoritoSalidaDtos;
    }


    @Override
    public FavoritoSalidaDto buscarFavoritoPorId(Long id) {
        Favorito favoritoBuscado = favoritoRepository.findById(id).orElse(null);
        FavoritoSalidaDto favoritoEncontrado = null;

        LOGGER.debug("Favorito buscado con ID {}: {}", id, favoritoBuscado);
        if (favoritoBuscado != null) {
            favoritoEncontrado = modelMapper.map(favoritoBuscado, FavoritoSalidaDto.class);
            LOGGER.info("Favorito encontrado: {}", JsonPrinter.toString(favoritoEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return favoritoEncontrado;
    }

    @Override
    public void eliminarFavorito(Long id) throws ResourceNotFoundException {
        if (buscarFavoritoPorId(id) != null) {
            //imagenService.eliminarImagenesSegunProducto(id);
            favoritoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el favorito con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el favorito con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el favorito con id " + id);
        }

    }
    private boolean chequearExistencia(Favorito favoritoEntidad) {
        boolean flag = false;
        List<Favorito> favoritosPersistidos = favoritoRepository.findAll();
        for(Favorito fav : favoritosPersistidos){
            LOGGER.info(fav.getNombre() +favoritoEntidad.getNombre());
            if((fav.getNombre()).equals( favoritoEntidad.getNombre())) {flag=true;}
        }
        return flag;
    }
    private void configureMapping() {
        modelMapper.typeMap(FavoritoEntradaDto.class, Favorito.class)
                .addMappings(modelMapper -> modelMapper.map(FavoritoEntradaDto::getUsuarioSalidaDto, Favorito::setUsuario));
        modelMapper.typeMap(FavoritoEntradaDto.class, Favorito.class)
                .addMappings(modelMapper -> modelMapper.map(FavoritoEntradaDto::getProductoSalidaDto, Favorito::setProducto));
        modelMapper.typeMap(Favorito.class, FavoritoSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Favorito::getUsuario, FavoritoSalidaDto::setUsuario));
        modelMapper.typeMap(Favorito.class, FavoritoSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Favorito::getProducto, FavoritoSalidaDto::setProducto));

        modelMapper.typeMap(Imagen.class, ImagenEntradaDto.class);
    }
}
