package service.persist.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.persist.UserSubscriptionCRUDService;

@Configuration
public class UserSubscriptionConfig {

    @Bean
    public UserSubscriptionCRUDService userSubscriptionCRUDService() {
        return new UserSubscriptionCRUDService();
    }
}
