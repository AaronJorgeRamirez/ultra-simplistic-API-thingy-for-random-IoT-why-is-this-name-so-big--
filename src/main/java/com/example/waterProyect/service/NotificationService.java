package com.example.waterProyect.service;

import com.example.waterProyect.model.Dispositivo;
import com.example.waterProyect.repository.DispositivoRepository;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final DispositivoRepository repository;

    public NotificationService(DispositivoRepository repository) {
        this.repository = repository;
    }


    public void enviarNotificacion(String titulo, String cuerpo) {

        for (Dispositivo dispositivo : repository.findAll()) {

            try {
                Message mensaje = Message.builder()
                        .setToken(dispositivo.getToken())
                        .setNotification(
                                Notification.builder()
                                        .setTitle(titulo)
                                        .setBody(cuerpo)
                                        .build()
                        )
                        .build();

                String respuesta = FirebaseMessaging.getInstance().send(mensaje);

                System.out.println("FCM OK: " + respuesta);

            } catch (com.google.firebase.messaging.FirebaseMessagingException e) {

                System.out.println("ERROR CODE: " + e.getErrorCode());
                System.out.println("ERROR MESSAGE: " + e.getMessage());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}