package com.pragma.mensajeriamicroservicio.infrastructure.configuration;

import com.pragma.mensajeriamicroservicio.domain.api.INotificationServicePort;
import com.pragma.mensajeriamicroservicio.domain.spi.INotificationPersistencePort;
import com.pragma.mensajeriamicroservicio.domain.usecase.NotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final INotificationPersistencePort notificationPersistencePort;
    @Bean
    public INotificationServicePort notificationServicePort(){
        return new NotificationUseCase(notificationPersistencePort);
    }
}
