package com.example.demo.controller;

import com.example.demo.dto.entrada.producto.ProductoEntradaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
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
    public ResponseEntity<List<ProductoSalidaDto>> listarProductos(){
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
    public ResponseEntity<ProductoSalidaDto> guardar(@RequestBody @Valid ProductoEntradaDto producto){
        return new ResponseEntity<>(productoService.registrarProducto(producto), HttpStatus.CREATED);
    }

}
