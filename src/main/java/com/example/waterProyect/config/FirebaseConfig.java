package com.example.waterProyect.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import com.google.api.client.googleapis.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void inicializarFirebase() throws IOException {

        String credenciales = System.getenv("FIREBASE_CREDENTIALS");

        if (credenciales == null || credenciales.isBlank()) {
            throw new IllegalStateException(
                    "No se encontraron las credenciales de Firebase"
            );
        }

        ByteArrayInputStream stream = new ByteArrayInputStream(
                credenciales.getBytes(StandardCharsets.UTF_8)
        );

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(stream))
                .setHttpTransport(Utils.getDefaultTransport())
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}