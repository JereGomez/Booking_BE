package com.example.demo.service;

import com.example.demo.dto.entrada.reserva.ReservaEntradaDto;
import com.example.demo.dto.salida.imagen.ImagenSalidaDto;
import com.example.demo.dto.salida.reserva.ReservaSalidaDto;
import com.example.demo.entity.Producto;
import com.example.demo.entity.Reserva;
import com.example.demo.entity.Usuario;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService implements IReservaService {
    private final Logger LOGGER = LoggerFactory.getLogger(ReservaService.class);

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ImagenService imagenService;

    public ReservaService(ReservaRepository reservaRepository, ModelMapper modelMapper, ImagenService imagenService) {
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
        this.imagenService = imagenService;
        configureMapping();
    }

    @Override
    public ReservaSalidaDto registrarReserva(ReservaEntradaDto reserva) throws BadRequestException {
        Usuario usuario = modelMapper.map(reserva.getUsuarioSalidaDto(), Usuario.class);
        usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Producto producto = modelMapper.map(reserva.getProductoSalidaDto(), Producto.class);
        productoRepository.findById(producto.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Verificar disponibilidad
        LocalDate disponibilidadDesde = convertToLocalDate(producto.getDisponibilidad_Desde());
        LocalDate disponibilidadHasta = convertToLocalDate(producto.getDisponibilidad_Hasta());

        if (reserva.getFechaInicio().isBefore(disponibilidadDesde) || reserva.getFechaFin().isAfter(disponibilidadHasta)) {
            throw new BadRequestException("Producto no disponible en las fechas seleccionadas");
        }

        // Verificar solapamiento de reservas existentes
        List<Reserva> reservas = reservaRepository.findByProductoIdAndFechaFinAfterAndFechaInicioBefore(
                producto.getId(), reserva.getFechaInicio(), reserva.getFechaFin());
        if (!reservas.isEmpty()) {
            throw new BadRequestException("El producto ya está reservado en las fechas seleccionadas");
        } else {
            double precioTotal = calcularPrecioTotal(reserva.getFechaInicio(), reserva.getFechaFin(), producto.getPrecioNoche());
            reserva.setPrecio_total(precioTotal);
            LOGGER.info("ReservaEntradaDto: " + JsonPrinter.toString(reserva));
            Reserva reservaEntidad = modelMapper.map(reserva, Reserva.class);

            // Mandamos a persistir a la capa dao y obtenemos una entidad
            Reserva reservaAPersistir = reservaRepository.save(reservaEntidad);
            List<ImagenSalidaDto> imagenesSalida = new ArrayList<>();
            /*for(Imagen img : productoAPersistir.getImagenes()){
                img.setProducto_id(productoAPersistir);
               ImagenEntradaDto imgagenAPersistir = modelMapper.map(img, ImagenEntradaDto.class);
                ImagenSalidaDto imagencreada = imagenService.registrarImagen(imgagenAPersistir);
                imagenesSalida.add(imagencreada);
             LOGGER.info("Imagen creada: "+imagencreada);
            }*/

            // Transformamos la entidad obtenida en salidaDto
            ReservaSalidaDto reservaSalidaDto = modelMapper.map(reservaAPersistir, ReservaSalidaDto.class);
            // productoSalidaDto.setImagenes(imagenesSalida);
            LOGGER.info("ReservaSalidaDto: " + JsonPrinter.toString(reservaSalidaDto));
            return reservaSalidaDto;
        }

    }
    @Override
    public List<ReservaSalidaDto> listarReservas() {

        List<ReservaSalidaDto> reservaSalidaDtos = reservaRepository.findAll()
                .stream()
                .map(reserva -> modelMapper.map(reserva, ReservaSalidaDto.class))
                .toList();
        //if (reservaSalidaDtos.isEmpty()) {
        //throw new ResourceNotFoundException("No se encontraron reservas.");
        //}
        LOGGER.info("Listado de reservas: {}", JsonPrinter.toString(reservaSalidaDtos));
        return reservaSalidaDtos;
    }
    @Override
    public List<ReservaSalidaDto> obtenerReservasPorUsuario(String emailUsuario) {
        List<Reserva> reservas = reservaRepository.findByUsuarioEmail(emailUsuario);
        return reservas.stream()
                .map(reserva -> modelMapper.map(reserva, ReservaSalidaDto.class))
                .collect(Collectors.toList());
    }

    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin, double precioNoche) {
        long dias = Duration.between(fechaInicio.atStartOfDay(), fechaFin.atStartOfDay()).toDays();
        return dias * precioNoche;
    }
    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private void configureMapping() {
        modelMapper.typeMap(ReservaEntradaDto.class, Reserva.class)
                .addMappings(mapper -> mapper.map(ReservaEntradaDto::getUsuarioSalidaDto, Reserva::setUsuario));
        modelMapper.typeMap(ReservaEntradaDto.class, Reserva.class)
                .addMappings(mapper -> mapper.map(ReservaEntradaDto::getProductoSalidaDto, Reserva::setProducto));
        modelMapper.typeMap(Reserva.class, ReservaSalidaDto.class)
                .addMappings(mapper -> mapper.map(Reserva::getUsuario, ReservaSalidaDto::setUsuarioSalidaDto));
        modelMapper.typeMap(Reserva.class, ReservaSalidaDto.class)
                .addMappings(mapper -> mapper.map(Reserva::getProducto, ReservaSalidaDto::setProductoSalidaDto));

        //modelMapper.typeMap(Imagen.class, ImagenEntradaDto.class);
    }
}
