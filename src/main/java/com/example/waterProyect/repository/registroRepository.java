package com.example.waterProyect.repository;

import com.example.waterProyect.model.registro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface registroRepository extends JpaRepository<registro, Long> {
    Optional<registro> findTopByEstadoOrderByIdDesc(String estado);
}
