package com.example.waterProyect.controller;

import com.example.waterProyect.model.Dispositivo;
import com.example.waterProyect.repository.DispositivoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final DispositivoRepository repository;

    public TokenController(DispositivoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<String> recibirToken(
            @RequestBody Map<String, String> datos) {

        String token = datos.get("token");

        if (token == null || token.isBlank()) {
            return ResponseEntity.badRequest().body("Token inválido");
        }

        if (!repository.existsByToken(token)) {
            Dispositivo dispositivo = new Dispositivo();

            dispositivo.setToken(token);
            dispositivo.setFechaRegistro(LocalDateTime.now());

            repository.save(dispositivo);
        }

        return ResponseEntity.ok("Token recibido");
    }
}