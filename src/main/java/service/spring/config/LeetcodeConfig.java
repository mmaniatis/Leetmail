package service.spring.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import service.driver.LeetcodeMailDriver;
import service.persist.UserSubscriptionCRUDService;
import service.persist.spring.config.UserSubscriptionConfig;
import service.scrape.LeetCodeScrapeService;

@Configuration
@Import({UserSubscriptionConfig.class})
public class LeetcodeConfig {

    @Bean(destroyMethod = "close")
    public WebDriver webDriver(){
        return new SafariDriver();
    }

    @Bean
    public LeetCodeScrapeService leetCodeScrapeService(@Autowired WebDriver webDriver) {
        return new LeetCodeScrapeService(webDriver);
    }

    @Bean
    public LeetcodeMailDriver leetcodeMailDriver(
            @Autowired LeetCodeScrapeService leetCodeScrapeService,
            @Autowired UserSubscriptionCRUDService userSubscriptionCRUDService) {
        return new LeetcodeMailDriver(leetCodeScrapeService, userSubscriptionCRUDService);
    }
}
