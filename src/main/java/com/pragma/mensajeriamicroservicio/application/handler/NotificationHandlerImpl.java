package com.pragma.mensajeriamicroservicio.application.handler;


import com.pragma.mensajeriamicroservicio.domain.api.INotificationServicePort;
import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationHandlerImpl implements INotificationHandler {

    private final INotificationServicePort notificationServicePort;
    @Override
    public void enviarSMS(String mensaje, String destino) throws NotificationFailedException {
        notificationServicePort.enviarSMS(mensaje, destino);
    }
}
