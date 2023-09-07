package com.itsqmet.ProyectoFinalPOOII.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Peliculas {

    @Id //declara una clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //Genera un ID automaticamente
    private Integer id;
    private String nombre_pelicula;
    private String genero;
    private String nombre_director;
    private int anio_pelicula;

    @ManyToMany(mappedBy = "peliculas")
    private List<Usuarios> usuarios;

}
