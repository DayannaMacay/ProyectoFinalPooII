package com.itsqmet.ProyectoFinalPOOII.controladores;

import com.itsqmet.ProyectoFinalPOOII.entidades.Peliculas;
import com.itsqmet.ProyectoFinalPOOII.repositorios.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PeliculaController {

    @Autowired
    PeliculaRepository peliculaRepository;

    //MAPEO DE RUTA
    @GetMapping("/peliculas")
    public String listarPersona(Model model){
        List<Peliculas> peliculas = peliculaRepository.findAll();
        model.addAttribute("peliculas", peliculas);
        return "listaPeliculas";
    }

    @GetMapping("/registro-pelicula")
    public String registro_pelicula(Model model){
        model.addAttribute("pelicula", new Peliculas());
        return "registro-pelicula";
    }

    //CREAR PELICULAS
    @PostMapping("/registro-pelicula")
    public String crearpelicula(Peliculas peliculas){
        peliculaRepository.save(peliculas);
        return "redirect:/peliculas";
    }

    //EDITAR PELICULAS
    @GetMapping ("/editar/pelicula/{id}")
    public String editarpelicula(@PathVariable int id, Model model){
        Optional<Peliculas> pelicula = peliculaRepository.findById(id);
        model.addAttribute("pelicula", pelicula);
        return "registro-pelicula";
    }

    //ELIMINAR PELICULAS
    @GetMapping("/eliminar/pelicula/{id}")
    public String eliminarpelicula(@PathVariable int id){
        peliculaRepository.deleteById(id);
        return "redirect:/peliculas";
    }
}
