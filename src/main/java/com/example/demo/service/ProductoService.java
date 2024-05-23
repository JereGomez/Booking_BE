package com.example.demo.service;

import com.example.demo.dto.entrada.imagen.ImagenEntradaDto;
import com.example.demo.dto.entrada.producto.ProductoEntradaDto;
import com.example.demo.dto.modificacion.producto.ProductoModificacionEntradaDto;
import com.example.demo.dto.salida.imagen.ImagenSalidaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.entity.Imagen;
import com.example.demo.entity.Producto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductoService implements IProductoService{
    private final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);
    private ProductoRepository productoRepository;
    private ModelMapper modelMapper;

    private ImagenService imagenService;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, ModelMapper modelMapper, ImagenService imagenService) {
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
        this.imagenService = imagenService;
    }


    @Override
    public ProductoSalidaDto registrarProducto(ProductoEntradaDto producto) throws BadRequestException {
        LOGGER.info("ProductoEntradaDto: " + JsonPrinter.toString(producto));
        Producto productoEntidad = modelMapper.map(producto, Producto.class);
        boolean productoExiste = chequearExistencia(productoEntidad);
        if(productoExiste == true){
            LOGGER.error("Ya existe un producto con ese nombre{}", producto.getNombre());
            BadRequestException exception = new BadRequestException("Ya existe un producto con ese nombre ${producto.getNombre()}");
            throw exception;
        }
        else{
            //mandamos a persistir a la capa dao y obtenemos una entidad
            Producto productoAPersistir = productoRepository.save(productoEntidad);
            List<ImagenSalidaDto> imagenesSalida = new ArrayList<ImagenSalidaDto>();
           /*for(Imagen img : productoAPersistir.getImagenes()){
                img.setProducto_id(productoAPersistir);
               ImagenEntradaDto imgagenAPersistir = modelMapper.map(img, ImagenEntradaDto.class);
                ImagenSalidaDto imagencreada = imagenService.registrarImagen(imgagenAPersistir);
                imagenesSalida.add(imagencreada);
             LOGGER.info("Imagen creada: "+imagencreada);
            }*/

            //transformamos la entidad obtenida en salidaDto
            ProductoSalidaDto productoSalidaDto = modelMapper.map(productoAPersistir, ProductoSalidaDto.class);
            //productoSalidaDto.setImagenes(imagenesSalida);
            LOGGER.info("ProductoSalidaDto: " + JsonPrinter.toString(productoSalidaDto));
            return productoSalidaDto;
        }
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
        if (productoBuscado != null) {
            productoEncontrado = modelMapper.map(productoBuscado, ProductoSalidaDto.class);
            LOGGER.info("Producto encontrado: {}", JsonPrinter.toString(productoEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return productoEncontrado;
    }

    @Override
    public void eliminarProducto(Long id) throws ResourceNotFoundException {
        if (buscarProductoPorId(id) != null) {
            imagenService.eliminarImagenesSegunProducto(id);
            productoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el producto con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el producto con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + id);
        }
    }

    @Override
    public ProductoSalidaDto actualizarProducto(  ProductoModificacionEntradaDto producto) {


        Producto productoRecibido = modelMapper.map(producto, Producto.class);
        Producto productoAActualizar = productoRepository.findById(productoRecibido.getId()).orElse(null);

        ProductoSalidaDto productoSalidaDto = null;

        if (productoAActualizar != null) {
            productoAActualizar = productoRecibido;
            productoRepository.save(productoAActualizar);
           /* for(Imagen img : producto.getImagenes()){
                ImagenModificacionEntradaDto imagenModificacion = new ImagenModificacionEntradaDto(img.getImagen_id(), img.getNombre(), img.getRutaDeArchivo());
                ImagenSalidaDto imagenSalida = imagenService.actualizarImagen(imagenModificacion);
                LOGGER.info("Imagen actualizada: "+imagenSalida);
            }*/
            productoSalidaDto = modelMapper.map(productoAActualizar, ProductoSalidaDto.class);
            LOGGER.warn("Producto actualizado: {}", JsonPrinter.toString(productoSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el producto porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }


        return productoSalidaDto;
    }

    private void configureMapping() {
        modelMapper.typeMap(ProductoEntradaDto.class, Producto.class);

        modelMapper.typeMap(Producto.class, ProductoSalidaDto.class);

        modelMapper.typeMap(Imagen.class, ImagenEntradaDto.class);
    }

    private boolean chequearExistencia(Producto productoEntidad) {
        boolean flag = false;
        List<Producto> productosPersistidos = productoRepository.findAll();
        for(Producto prod : productosPersistidos){
            LOGGER.info(prod.getNombre() +productoEntidad.getNombre());
            if((prod.getNombre()).equals( productoEntidad.getNombre())) {flag=true;}
        }
        return flag;
    }
}
