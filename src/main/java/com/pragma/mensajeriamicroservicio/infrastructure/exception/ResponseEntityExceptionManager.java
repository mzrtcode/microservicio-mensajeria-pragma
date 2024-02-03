package com.pragma.mensajeriamicroservicio.infrastructure.exception;

import com.pragma.mensajeriamicroservicio.MicroservicioDeMensajeriaApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResponseEntityExceptionManager {

    private static Logger logger = LoggerFactory.getLogger(ResponseEntityExceptionManager.class);

}
