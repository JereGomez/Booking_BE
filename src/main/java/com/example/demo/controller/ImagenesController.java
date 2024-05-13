package com.example.demo.controller;

import com.example.demo.dto.entrada.imagenes.ImagenesEntradaDto;
import com.example.demo.dto.salida.imagenes.ImagenesSalidaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.service.IImagenesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("admin/imagenes")
public class ImagenesController {


        public IImagenesService imagenesService;

        public ImagenesController(IImagenesService imagenesService) {
            this.imagenesService = imagenesService;
        }
        @Operation(summary = "Registro de una nueva imagen")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Imagen guardada correctamente",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProductoSalidaDto.class))}),
                @ApiResponse(responseCode = "400", description = "Bad Request",
                        content = @Content),
                @ApiResponse(responseCode = "500", description = "Server error",
                        content = @Content)
        })
        @PostMapping("/registrar")
        public ResponseEntity<ImagenesSalidaDto> guardar(@RequestBody @Valid ImagenesEntradaDto imagen){
            return new ResponseEntity<>(imagenesService.registrarImagenes(imagen), HttpStatus.CREATED);
        }
}
