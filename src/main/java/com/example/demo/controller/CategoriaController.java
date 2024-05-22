package com.example.demo.controller;

import com.example.demo.dto.entrada.categoria.CategoriaEntradaDto;
import com.example.demo.dto.salida.categoria.CategoriaSalidaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.service.ICategoriaService;
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
@RequestMapping("admin/categoria")
public class CategoriaController {


    public ICategoriaService categoriaService;

    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Operation(summary = "Registro de una nueva Categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoria guardado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<CategoriaSalidaDto> guardar(@RequestBody @Valid CategoriaEntradaDto categoria) {
        return new ResponseEntity<>(categoriaService.registrarCategoria(categoria), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> eliminar(@PathVariable Long  id) {
        categoriaService.eliminarCategoriaByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/")
    ResponseEntity<List<CategoriaSalidaDto>> listarCategorias() {
        return new ResponseEntity<>(categoriaService.listarCategorias(), HttpStatus.OK);
    }
}
