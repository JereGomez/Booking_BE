package com.example.demo.controller;

import com.example.demo.dto.entrada.producto.ProductoEntradaDto;
import com.example.demo.dto.modificacion.producto.ProductoModificacionEntradaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.service.IProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {
    public IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @Operation(summary = "Listado de todos los productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de productos obtenido correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })


    @GetMapping("/listar")
    public ResponseEntity<List<ProductoSalidaDto>> listarProductos() {
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @Operation(summary = "Registro de un nuevo Producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto guardado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping("/registrar")
    public ResponseEntity<ProductoSalidaDto> guardar(@RequestBody @Valid ProductoEntradaDto producto) throws BadRequestException {
        return new ResponseEntity<>(productoService.registrarProducto(producto), HttpStatus.CREATED);
    }

    //buscar producto con PathVariable
    @Operation(summary = "Búsqueda de un producto por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto obtenido correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("{id}")
    public ResponseEntity<ProductoSalidaDto> obtenerProductoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.buscarProductoPorId(id), HttpStatus.OK);
    }

    @Operation(summary = "Actualización de un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "UServer error",
                    content = @Content)
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoSalidaDto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoModificacionEntradaDto producto) {
        return new ResponseEntity<>(productoService.actualizarProducto(producto), HttpStatus.OK);
    }

}
