package com.pragma.mensajeriamicroservicio.infrastructure.output.twilio;

import com.pragma.mensajeriamicroservicio.infrastructure.exception.NotificationFailedException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TwilioServiceTest {

    private TwilioService twilioService;
    private MockedStatic<Twilio> mockedTwilio;

    @BeforeEach
    void setUp() {
        twilioService = new TwilioService();
        mockedTwilio = Mockito.mockStatic(Twilio.class);
    }

    @Test
    void sendSMS_shouldThrowNotificationFailedException_whenTwilioFails() {
        // Arrange
        String recipient = "1234567890";
        String message = "Hello, World!";

        mockedTwilio.when(() -> Twilio.init(anyString(), anyString()))
                .thenThrow(RuntimeException.class);

        // Act & Assert
        assertThrows(NotificationFailedException.class, () -> twilioService.sendSMS(recipient, message));
    }

}