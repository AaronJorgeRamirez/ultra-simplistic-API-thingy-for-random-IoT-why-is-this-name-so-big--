package com.example.waterProyect.service.serviceImpl;

import com.example.waterProyect.model.registro;
import com.example.waterProyect.repository.registroRepository;
import com.example.waterProyect.service.registroService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class registroServiceImpl implements registroService {

    private final registroRepository rr;

    public registroServiceImpl(registroRepository rr){
        this.rr = rr;
    }

    @Override
    public List<registro> listarRegistros() {
        return rr.findAll();
    }

    @Override
    public registro nuevoRegistro(registro r) {
        return rr.save(r);
    }

    @Override
    public void actualizarRegistro(Long id, LocalTime fin) {

        registro r = rr.findById(id).orElse(null);

        if (r != null) {
            r.setFin(fin);
            r.setEstado("Fuga Terminada");
            rr.save(r);
        }
    }
}
