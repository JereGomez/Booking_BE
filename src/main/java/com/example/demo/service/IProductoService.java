package com.example.demo.service;



import com.example.demo.dto.entrada.producto.ProductoEntradaDto;
import com.example.demo.dto.modificacion.producto.ProductoModificacionEntradaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;

import java.util.List;

public interface IProductoService {
    ProductoSalidaDto registrarProducto(ProductoEntradaDto producto);
    List<ProductoSalidaDto> listarProductos();
    ProductoSalidaDto buscarProductoPorId(Long id);
    void eliminarProducto(Long id);
    ProductoSalidaDto actualizarProducto(ProductoModificacionEntradaDto paciente);
}
