package com.itsqmet.ProyectoFinalPOOII.repositorios;

import com.itsqmet.ProyectoFinalPOOII.entidades.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Peliculas, Integer> {
}
