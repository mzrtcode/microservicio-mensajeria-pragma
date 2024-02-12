package com.pragma.mensajeriamicroservicio.infrastructure.output.twilio;

import com.pragma.mensajeriamicroservicio.domain.spi.INotificationPersistencePort;
import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwilioService implements INotificationPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(TwilioService.class);

    public void sendSMS(String recipient, String message) throws NotificationFailedException {

        try {
            Twilio.init("ACa60f6253d04eae5f93e1101e305cc01c", "60f3d6c94f3fd746a20520b4abe42fba");
            Message.creator(new PhoneNumber(recipient),
                    new PhoneNumber("+573215427064"), message).create();
            logger.info("DESTINO: {} MENSAJE: {}", recipient, message);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new NotificationFailedException("No fue posible enviar el mensaje");

        }


    }
}
