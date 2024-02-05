package com.pragma.mensajeriamicroservicio.application.handler;

import com.pragma.mensajeriamicroservicio.domain.api.INotificationServicePort;
import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationHandlerImplTest {

    @Mock
    private INotificationServicePort notificationServicePort;

    @InjectMocks
    private NotificationHandlerImpl notificationHandler;


    @Test
    void enviarSMS() throws NotificationFailedException {
        // Datos de prueba
        String destino = "+57312154512";
        String mensaje = "Este es un mensaje de prueba";

        // ACT
        notificationHandler.enviarSMS(destino, mensaje);

        // ASSERT
        verify(notificationServicePort, times(1)).enviarSMS(destino, mensaje);

    }
}