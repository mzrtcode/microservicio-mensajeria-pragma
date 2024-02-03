package com.pragma.mensajeriamicroservicio.domain.usecase;

import com.pragma.mensajeriamicroservicio.domain.api.INotificationServicePort;
import com.pragma.mensajeriamicroservicio.domain.spi.INotificationPersistencePort;
import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;

public class NotificationUseCase implements INotificationServicePort {

    private final INotificationPersistencePort notificationPersistencePort;

    public NotificationUseCase(INotificationPersistencePort notificationPersistencePort) {
        this.notificationPersistencePort = notificationPersistencePort;
    }

    @Override
    public void enviarSMS(String destino, String mensaje) throws NotificationFailedException {
        notificationPersistencePort.sendSMS(destino, mensaje);
    }
}
