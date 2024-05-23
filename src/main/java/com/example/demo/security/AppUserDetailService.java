package com.example.demo.security;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppUserDetailService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByNombre(username);
        if (usuario.isPresent()){
            var usuarioObj= usuario.get();
            return User.builder()
                    .username(usuarioObj.getNombre())
                    .password(usuarioObj.getContrasenia())
                    .username(usuarioObj.getApellido())
                    .username(usuarioObj.getEmail())
                    .build();
        }else{
            throw  new UsernameNotFoundException(username);
        }

    }
}
