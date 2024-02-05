package com.pragma.mensajeriamicroservicio.domain.usecase;

import com.pragma.mensajeriamicroservicio.domain.spi.INotificationPersistencePort;
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
class NotificationUseCaseTest {

    @Mock
    private INotificationPersistencePort notificationPersistencePort;

    @InjectMocks
    private NotificationUseCase notificationUseCase;

    @Test
    void enviarSMS() throws NotificationFailedException {
        // Datos de prueba
        String destino = "+57312154512";
        String mensaje = "Este es un mensaje de prueba";

        // ACT
        notificationUseCase.enviarSMS(destino, mensaje);

        // ASSERT
        verify(notificationPersistencePort, times(1)).sendSMS(destino, mensaje);
    }
}