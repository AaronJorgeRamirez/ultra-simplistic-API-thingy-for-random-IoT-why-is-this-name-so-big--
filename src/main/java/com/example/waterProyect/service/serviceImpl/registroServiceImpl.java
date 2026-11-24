package com.example.waterProyect.service.serviceImpl;

import com.example.waterProyect.model.registro;
import com.example.waterProyect.repository.registroRepository;
import com.example.waterProyect.service.NotificationService;
import com.example.waterProyect.service.registroService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class registroServiceImpl implements registroService {

    private final registroRepository rr;
    private final NotificationService notificacionService;

    public registroServiceImpl(
            registroRepository rr,
            NotificationService notificacionService
    ) {
        this.rr = rr;
        this.notificacionService = notificacionService;
    }

    @Override
    public List<registro> listarRegistros() {
        return rr.findAll();
    }

    @Override
    public registro nuevoRegistro(registro r) {

        registro nuevo = rr.save(r);

        notificacionService.enviarNotificacion(
                "🚨 ¡Fuga detectada!",
                "WaterControl ha detectado una fuga de agua."
        );

        return nuevo;
    }

    @Override
    public void actualizarRegistro(Long id, LocalTime fin) {

        registro r = rr.findById(id).orElse(null);

        if (r != null) {
            r.setFin(fin);
            r.setEstado("Fuga Terminada");

            rr.save(r);

            notificacionService.enviarNotificacion(
                    "✅ Fuga finalizada",
                    "La fuga de agua ha sido controlada."
            );
        }
    }

    @Override
    public Long idUltimo() {
        return rr.findTopByEstadoOrderByIdDesc("FUGA")
                .map(registro::getId)
                .orElse(null);
    }
}