package com.example.demo.service;

import com.example.demo.dto.entrada.categoria.CategoriaEntradaDto;
import com.example.demo.dto.salida.categoria.CategoriaSalidaDto;
import com.example.demo.entity.Categoria;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {
    private final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
    private CategoriaRepository categoriaRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public CategoriaSalidaDto registrarCategoria(CategoriaEntradaDto categoria) {
        // Verificar si ya existe un alojamiento con el mismo nombre
        String nombreDelaCategoria = categoria.getNombre();
        if (categoriaRepository.findByNombre(nombreDelaCategoria).isPresent()) {
            throw new IllegalArgumentException("La categoria con nombre '" + nombreDelaCategoria + "' ya existe");
        }
        LOGGER.info("CategoriaEntradaDto: " + JsonPrinter.toString(categoria));
        Categoria categoriaEntidad = modelMapper.map(categoria, Categoria.class);

        //mandamos a persistir a la capa dao y obtenemos una entidad
        Categoria categoriaAPersistir = categoriaRepository.save(categoriaEntidad);
        //transformamos la entidad obtenida en salidaDto
        CategoriaSalidaDto categoriaSalidaDto = modelMapper.map(categoriaAPersistir, CategoriaSalidaDto.class);
        LOGGER.info("AlojamientoSalidaDto: " + JsonPrinter.toString(categoriaSalidaDto));
        return categoriaSalidaDto;

    }

    private void configureMapping() {
        modelMapper.typeMap(CategoriaEntradaDto.class, Categoria.class);

        modelMapper.typeMap(Categoria.class, CategoriaSalidaDto.class);

    }
}
