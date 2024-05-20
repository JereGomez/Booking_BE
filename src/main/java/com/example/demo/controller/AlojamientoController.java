/*package com.example.demo.controller;

import com.example.demo.dto.entrada.alojamiento.AlojamientoEntradaDto;
import com.example.demo.dto.modificacion.alojamiento.AlojamientoModificacionEntradaDto;
import com.example.demo.dto.salida.alojamiento.AlojamientoSalidaDto;
import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.IAlojamientoService;
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
@RequestMapping("admin/alojamiento")
public class AlojamientoController {


        public IAlojamientoService alojamientoService;

        public AlojamientoController(IAlojamientoService alojamientoService) {
            this.alojamientoService = alojamientoService;
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
        public ResponseEntity<List<AlojamientoSalidaDto>> listarAlojamientos(){
            return new ResponseEntity<>(alojamientoService.listarAlojamientos(), HttpStatus.OK);
        }
        @Operation(summary = "Registro de un nuevo alojamiento")
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
        public ResponseEntity<AlojamientoSalidaDto> guardar(@RequestBody @Valid AlojamientoEntradaDto alojamiento){
            return new ResponseEntity<>(alojamientoService.registrarAlojamiento(alojamiento), HttpStatus.CREATED);
        }
        @Operation(summary = "Eliminación de un alojamiento por Id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = String.class))}),
                @ApiResponse(responseCode = "400", description = "Id inválido",
                        content = @Content),
                @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                        content = @Content),
                @ApiResponse(responseCode = "500", description = "Server error",
                        content = @Content)
        })
        @DeleteMapping("/eliminar/{id}")
        public  ResponseEntity<Void> eliminarAlojamiento(@PathVariable Long id) throws ResourceNotFoundException {
            alojamientoService.eliminarAlojamiento(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }



        //buscar producto con PathVariable
        @Operation(summary = "Búsqueda de un alojamiento por Id")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Alojamiento obtenido correctamente",
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
        public ResponseEntity<AlojamientoSalidaDto> obtenerAlojamientoPorId(@PathVariable Long id){
            return new ResponseEntity<>(alojamientoService.buscarAlojamientoPorId(id), HttpStatus.OK);
        }
        @Operation(summary = "Actualización de un alojamiento")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Alojamiento actualizado correctamente",
                        content = {@Content(mediaType = "application/json",
                                schema = @Schema(implementation = ProductoSalidaDto.class))}),
                @ApiResponse(responseCode = "400", description = "Bad Request",
                        content = @Content),
                @ApiResponse(responseCode = "404", description = "Alojamiento no encontrado",
                        content = @Content),
                @ApiResponse(responseCode = "500", description = "UServer error",
                        content = @Content)
        })
        @PutMapping("/actualizar")
        public ResponseEntity<AlojamientoSalidaDto> actualizarAlojamiento(@RequestBody AlojamientoModificacionEntradaDto alojamiento){
            return new ResponseEntity<>(alojamientoService.actualizarAlojamiento(alojamiento),HttpStatus.OK);
        }
}
*/