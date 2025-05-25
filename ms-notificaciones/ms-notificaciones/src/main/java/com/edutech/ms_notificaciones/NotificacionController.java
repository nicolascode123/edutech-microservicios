package com.edutech.ms_notificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @PostMapping
    public Notificacion enviar(@RequestBody Notificacion notificacion) {
        // Simulamos envío y lo guardamos
        System.out.println("📨 Enviando notificación a: " + notificacion.getDestinatario());
        return notificacionRepository.save(notificacion);
    }

    @GetMapping
    public List<Notificacion> obtenerTodas() {
        return notificacionRepository.findAll();
    }
}

