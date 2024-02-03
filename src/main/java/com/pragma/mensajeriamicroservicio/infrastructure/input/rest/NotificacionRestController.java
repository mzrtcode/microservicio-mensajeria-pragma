package com.pragma.mensajeriamicroservicio.infrastructure.input.rest;

import com.pragma.mensajeriamicroservicio.application.handler.INotificationHandler;
import com.pragma.mensajeriamicroservicio.application.handler.NotificationHandlerImpl;
import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notificaciones")
@RequiredArgsConstructor
public class NotificacionRestController {

    private final INotificationHandler notificationHandler;

    @GetMapping
    public void enviarNotificacionCliente(
            @RequestParam(value = "destino") String destino,
            @RequestParam(value = "mensaje") String mensaje) throws NotificationFailedException {
                notificationHandler.enviarSMS(destino, mensaje);

    }
}
