package com.example.demo.service;

import com.example.demo.dto.entrada.producto.ProductoEntradaDto;
import com.example.demo.dto.modificacion.producto.ProductoModificacionEntradaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.entity.Producto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService implements IProductoService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private ProductoRepository productoRepository;
    private ModelMapper modelMapper;
    @Autowired
    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }


    @Override
    public ProductoSalidaDto registrarProducto(ProductoEntradaDto producto) {
        LOGGER.info("ProductoEntradaDto: " + JsonPrinter.toString(producto));
        Producto productoEntidad = modelMapper.map(producto, Producto.class);

        //mandamos a persistir a la capa dao y obtenemos una entidad
        Producto productoAPersistir = productoRepository.save(productoEntidad);
        //transformamos la entidad obtenida en salidaDto
        ProductoSalidaDto productoSalidaDto = modelMapper.map(productoAPersistir, ProductoSalidaDto.class);
        LOGGER.info("ProductoSalidaDto: " + JsonPrinter.toString(productoSalidaDto));
        return productoSalidaDto;

    }

    @Override
    public List<ProductoSalidaDto> listarProductos() {
        List<ProductoSalidaDto> productoSalidaDtos = productoRepository.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los productos: {}", JsonPrinter.toString(productoSalidaDtos));
        return productoSalidaDtos;
    }

    @Override
    public ProductoSalidaDto buscarProductoPorId(Long id) {
        Producto productoBuscado = productoRepository.findById(id).orElse(null);
        ProductoSalidaDto productoEncontrado = null;

        LOGGER.debug("Producto buscado con ID {}: {}", id, productoBuscado);
        if(productoBuscado != null){
            productoEncontrado =  modelMapper.map(productoBuscado, ProductoSalidaDto.class);
            LOGGER.info("Producto encontrado: {}", JsonPrinter.toString(productoEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return productoEncontrado;
    }

    @Override
    public void eliminarProducto(Long id)throws ResourceNotFoundException {
        if (buscarProductoPorId(id) != null) {
            productoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el producto con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el producto con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + id);
        }
    }

    @Override
    public ProductoSalidaDto actualizarProducto(ProductoModificacionEntradaDto producto) {
        Producto productoRecibido = modelMapper.map(producto, Producto.class);
        Producto productoAActualizar = productoRepository.findById(productoRecibido.getId()).orElse(null);

        ProductoSalidaDto productoSalidaDto = null;

        if (productoAActualizar != null) {
            productoAActualizar = productoRecibido;
            productoRepository.save(productoAActualizar);

            productoSalidaDto = modelMapper.map(productoAActualizar, ProductoSalidaDto.class);
            LOGGER.warn("Producto actualizado: {}", JsonPrinter.toString(productoSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el producto porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }


        return productoSalidaDto;
    }
    private void configureMapping(){
        modelMapper.typeMap(ProductoEntradaDto.class, Producto.class);

        modelMapper.typeMap(Producto.class, ProductoSalidaDto.class);

    }
}
