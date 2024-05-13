package com.example.demo.repository;

import com.example.demo.entity.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagenesRepository extends JpaRepository<Imagenes,Long> {
        Optional<Imagenes> findByNombre(String nombre);
}
