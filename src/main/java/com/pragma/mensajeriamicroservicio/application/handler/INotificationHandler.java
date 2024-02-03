package com.pragma.mensajeriamicroservicio.application.handler;

import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;

public interface INotificationHandler {
    void enviarSMS(String mensaje, String destino) throws NotificationFailedException;
}
