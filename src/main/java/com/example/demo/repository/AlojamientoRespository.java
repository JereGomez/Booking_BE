package com.example.demo.repository;

import com.example.demo.entity.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AlojamientoRespository extends JpaRepository<Alojamiento,Long> {
    Optional<Alojamiento> findByNombre(String nombre);
}
