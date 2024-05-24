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
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(userEmail);
        if (usuario.isPresent()) {
            var usuarioObj = usuario.get();
            // Asumiendo que el rol está almacenado como una cadena en el campo `rol`
            String role = "ROLE_" + usuarioObj.getRol().toUpperCase(); // Por ejemplo, "ROLE_ADMIN" o "ROLE_USER"
            return User.builder()
                    .username(usuarioObj.getEmail())
                    .password(usuarioObj.getContrasenia())
                    .authorities(role)
                    .build();
        } else {
            throw new UsernameNotFoundException(userEmail);
        }
    }
}

