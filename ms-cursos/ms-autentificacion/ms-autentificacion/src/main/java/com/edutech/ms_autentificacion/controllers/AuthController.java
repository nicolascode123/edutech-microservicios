package com.edutech.ms_autentificacion.controllers;

import com.edutech.ms_autentificacion.models.Usuario;
import com.edutech.ms_autentificacion.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody Usuario credenciales) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(credenciales.getUsername());

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (usuario.getPassword().equals(credenciales.getPassword())) {
                return "Autenticación exitosa";
            }
        }

        return "Usuario o contraseña incorrectos";
    }

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario nuevoUsuario) {
        return usuarioRepository.save(nuevoUsuario);
    }
}
