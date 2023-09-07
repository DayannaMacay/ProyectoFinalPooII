package com.itsqmet.ProyectoFinalPOOII.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Usuarios {

    @Id //declara una clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //Genera un ID automaticamente
    private Integer id;
    private String nombre_apellido;
    private String email;
    private String usuario;
    private String contrasenia;
    private String rol;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_peliculas",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_id")
    )
    private List<Peliculas> peliculas;

}

