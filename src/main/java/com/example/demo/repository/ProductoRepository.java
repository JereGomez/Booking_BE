package com.example.demo.repository;

import com.example.demo.dto.salida.producto.ProductoSalidaDto;
import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p JOIN p.categorias c WHERE c.id = :categoria_id")
    List<Producto> findByCategoryID(@Param("categoria_id") String categoria_id);
}
