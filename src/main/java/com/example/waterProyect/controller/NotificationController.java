package com.example.waterProyect.controller;

import com.example.waterProyect.service.NotificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificacion")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/prueba")
    public String probarNotificacion() {

        service.enviarNotificacion(
                "¡WaterControl! 💧",
                "Esta es una notificación de prueba."
        );

        return "Solicitud de notificación enviada";
    }
}
