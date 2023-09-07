package com.itsqmet.ProyectoFinalPOOII.controladores;

import com.itsqmet.ProyectoFinalPOOII.entidades.Usuarios;
import com.itsqmet.ProyectoFinalPOOII.repositorios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuariosController {

    @Autowired
    UsuariosRepository usuariosRepository;

    @GetMapping("/registro-login")
    public String registro_login(Model model){
        model.addAttribute("usuario", new Usuarios());
        return "registro-login";
    }

    @GetMapping ("/plataforma")
    public String plataforma(){
        return "plataforma";
    }

    @PostMapping("/registro-login")
    public String crear(Usuarios usuario){
        usuariosRepository.save(usuario);
        return "redirect:/registro-login";
    }


    //RUTA PARA VER LA LISTA DE USUARIOS
    @GetMapping("/lista")
    public String listaUsuarios(
            @RequestParam(value = "password", required = false) String password,
            Model model) {
        if ("admin".equals(password)) {
            List<Usuarios> usuarios = usuariosRepository.findAll();
            model.addAttribute("usuarios", usuarios);
            return "listaUsuarios";
        } else {
            model.addAttribute("mensaje", "Contraseña incorrecta");
            return "redirect:/registro-login";
        }
    }

    //EDITAR USUARIO
    @GetMapping ("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        model.addAttribute("usuario", usuario);
        return "registro-login";
    }

    //ELIMINAR USUARIO
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        usuariosRepository.deleteById(id);
        return "redirect:/lista";
    }
}
