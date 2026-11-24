package com.example.waterProyect.repository;

import com.example.waterProyect.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository
        extends JpaRepository<Dispositivo, Long> {

    boolean existsByToken(String token);
}