package com.pragma.mensajeriamicroservicio.infrastructure.output.twilio;

import com.pragma.mensajeriamicroservicio.MicroservicioDeMensajeriaApplication;
import com.pragma.mensajeriamicroservicio.domain.spi.INotificationPersistencePort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TwilioService implements INotificationPersistencePort {
    private static Logger logger = LoggerFactory.getLogger(TwilioService.class);

    public void sendSMS(String recipient, String message){
        try{
            Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
            Message.creator(new PhoneNumber(recipient),
                    new PhoneNumber(System.getenv("TWILIO_SENDER_NUMBER")), message).create();
        }catch (Exception e){
            logger.error("No fue posible enviar el mensaje ", e);

        }

    }
}
