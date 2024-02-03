package com.pragma.mensajeriamicroservicio.infrastructure.exception;

import com.pragma.mensajeriamicroservicio.MicroservicioDeMensajeriaApplication;
import com.pragma.mensajeriamicroservicio.infrastructure.input.rest.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseEntityExceptionManager {

    private static Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionManager.class);

    @ExceptionHandler(NotificationFailedException.class)
    public ResponseEntity<ErrorMessage> notificationFailedExceptionHandler(NotificationFailedException ex){
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        ErrorMessage message = new ErrorMessage(status, ex.getMessage());
        logger.error("No fue posible enviar el mensaje");
        return ResponseEntity.status(status).body(message);
    }

}
