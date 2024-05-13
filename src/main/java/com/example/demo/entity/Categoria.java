package com.example.demo.entity;

import jakarta.persistence.*;
@Entity
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne
        @JoinColumn(name = "alojamiento_id")
        private Alojamiento alojamiento;
        @Column
        private String nombre;
        @Column
        private String descripcion;

        public Categoria() {
        }

        public Categoria(Long id,  String nombre, String descripcion) {
            this.id = id;
            //this.alojamiento = alojamiento;
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        //public Alojamiento getAlojamiento() {
        // return alojamiento;
        //}

        //public void setAlojamiento(Alojamiento alojamiento) {
        //this.alojamiento = alojamiento;
        //}

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return "Categoria{" +
                    "id=" + id +
                    //", alojamiento=" + alojamiento +
                    ", nombre='" + nombre + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    '}';
        }
}
