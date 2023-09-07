package com.itsqmet.ProyectoFinalPOOII.repositorios;

import com.itsqmet.ProyectoFinalPOOII.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findByUsuario(String usuario);
}
