package com.pragma.mensajeriamicroservicio.domain.spi;

import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;

public interface INotificationPersistencePort {
    void sendSMS(String recipient, String message) throws NotificationFailedException;
}
