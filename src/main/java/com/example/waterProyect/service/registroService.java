package com.example.waterProyect.service;

import com.example.waterProyect.model.registro;

import java.time.LocalTime;
import java.util.List;

public interface registroService {
    List<registro> listarRegistros();
    registro nuevoRegistro(registro r);
    void actualizarRegistro(Long id, LocalTime fin);
    Long idUltimo();
}
