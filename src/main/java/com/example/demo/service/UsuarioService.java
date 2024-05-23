package com.example.demo.service;

import com.example.demo.dto.entrada.usuario.UsuarioEntradaDto;
import com.example.demo.dto.modificacion.usuario.UsuarioModificacionEntradaDto;
import com.example.demo.dto.salida.usuario.UsuarioSalidaDto;
import com.example.demo.entity.Usuario;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    private UsuarioRepository usuarioRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public UsuarioSalidaDto registrarUsuario(UsuarioEntradaDto usuario) {

        LOGGER.info("UsuarioEntradaDto: " + JsonPrinter.toString(usuario));
        Usuario usuarioEntidad = modelMapper.map(usuario, Usuario.class);

        //mandamos a persistir a la capa dao y obtenemos una entidad
        Usuario usuarioAPersistir = usuarioRepository.save(usuarioEntidad);
        //transformamos la entidad obtenida en salidaDto
        UsuarioSalidaDto usuarioSalidaDto = modelMapper.map(usuarioAPersistir, UsuarioSalidaDto.class);
        LOGGER.info("UsuarioSalidaDto: " + JsonPrinter.toString(usuarioSalidaDto));
        return usuarioSalidaDto;

    }

    @Override
    public List<UsuarioSalidaDto> listarUsuarios() {
        List<UsuarioSalidaDto> usuarioSalidaDtos = usuarioRepository.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioSalidaDto.class))
                .toList();
        LOGGER.info("Listado de todos los usuarios: {}", JsonPrinter.toString(usuarioSalidaDtos));
        return usuarioSalidaDtos;
    }

    @Override
    public UsuarioSalidaDto buscarUsuarioPorId(Long id) {
        Usuario usuarioBuscado = usuarioRepository.findById(id).orElse(null);
        UsuarioSalidaDto usuarioEncontrado = null;

        LOGGER.debug("Usuario buscado con ID {}: {}", id, usuarioBuscado);
        if (usuarioBuscado != null) {
            usuarioEncontrado = modelMapper.map(usuarioBuscado, UsuarioSalidaDto.class);
            LOGGER.info("Usuario encontrado: {}", JsonPrinter.toString(usuarioEncontrado));
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return usuarioEncontrado;
    }


    @Override
    public void eliminarUsuario(Long id) throws ResourceNotFoundException {
        if (buscarUsuarioPorId(id) != null) {

            usuarioRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el usuario con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el usuario con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el usuario con id " + id);
        }
    }

    @Override
    public UsuarioSalidaDto actualizarUsuario( UsuarioModificacionEntradaDto usuario) {

        Usuario usuarioRecibido = modelMapper.map(usuario, Usuario.class);
        Usuario usuarioAActualizar = usuarioRepository.findById(usuarioRecibido.getId()).orElse(null);

        UsuarioSalidaDto usuarioSalidaDto = null;

        if (usuarioAActualizar != null) {
            usuarioAActualizar = usuarioRecibido;
            usuarioRepository.save(usuarioAActualizar);
           /* for(Imagen img : producto.getImagenes()){
                ImagenModificacionEntradaDto imagenModificacion = new ImagenModificacionEntradaDto(img.getImagen_id(), img.getNombre(), img.getRutaDeArchivo());
                ImagenSalidaDto imagenSalida = imagenService.actualizarImagen(imagenModificacion);
                LOGGER.info("Imagen actualizada: "+imagenSalida);
            }*/
            usuarioSalidaDto = modelMapper.map(usuarioAActualizar, UsuarioSalidaDto.class);
            LOGGER.warn("Usuario actualizado: {}", JsonPrinter.toString(usuarioSalidaDto));

        } else {
            LOGGER.error("No fue posible actualizar el usuario porque no se encuentra en nuestra base de datos");
            //lanzar excepcion correspondiente
        }


        return usuarioSalidaDto;
    }
    private boolean chequearExistencia(Usuario usuarioEntidad) {
        boolean flag = false;
        List<Usuario> usuariosPersistidos = usuarioRepository.findAll();
        for(Usuario usuario : usuariosPersistidos){
            LOGGER.info(usuario.getNombre() +usuarioEntidad.getNombre());
            if((usuario.getNombre()).equals( usuarioEntidad.getNombre())) {flag=true;}
        }
        return flag;
    }
    private void configureMapping() {
        modelMapper.typeMap(UsuarioEntradaDto.class, Usuario.class);

        modelMapper.typeMap(Usuario.class, UsuarioSalidaDto.class);

    }
}
