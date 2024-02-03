package com.pragma.mensajeriamicroservicio.domain.spi;

public interface INotificationPersistencePort {
    void sendSMS(String recipient, String message);
}
