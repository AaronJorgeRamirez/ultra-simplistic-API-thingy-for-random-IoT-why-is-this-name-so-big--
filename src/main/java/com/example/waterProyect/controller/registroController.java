package com.example.waterProyect.controller;

import com.example.waterProyect.model.registro;
import com.example.waterProyect.service.registroService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/registro")
public class registroController {

    private final registroService service;

    public registroController(registroService service) {
        this.service = service;
    }

    @GetMapping
    public List<registro> listarRegistro() {
        return service.listarRegistros();
    }

    @PatchMapping("/{id}")
    public void actualizarRegistro(
            @PathVariable Long id,
            @RequestBody LocalTime fin) {

        service.actualizarRegistro(id, fin);
    }

    @PostMapping
    public registro nuevoRegistro(@RequestBody registro r) {
        return service.nuevoRegistro(r);
    }

    @GetMapping
    public Long ultId(){
        return service.idUltimo();
    }
}