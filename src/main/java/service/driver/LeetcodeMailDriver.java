package service.driver;

import model.LeetcodeQuestion;
import model.LeetcodeSubscription;
import model.User;
import service.persist.CRUDService;
import service.scrape.ScrapeService;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetcodeMailDriver {
    private final ScrapeService<Map<String, List<LeetcodeQuestion>>> scrapeService;
    private final CRUDService crudService;

    public LeetcodeMailDriver(
            ScrapeService<Map<String, List<LeetcodeQuestion>>> scrapeService,
            CRUDService userSubscriptionCRUDService){
        this.scrapeService = scrapeService;
        this.crudService = userSubscriptionCRUDService;
    }
    private List<LeetcodeSubscription> getSubscriptions() {
        return crudService.getUsers().stream()
                .filter(user -> user.getSubscriptions().size() >= 1)
                .flatMap(user -> user.getSubscriptions().stream())
                .filter(sub -> sub.getLastSent() == null || sub.getLastSent()
                        .compareTo(Date.from(Instant.now().minus(1, ChronoUnit.DAYS))) > 0)
                .collect(Collectors.toList());
    }

    public void drive() {
        //TODO: Implement this
        List<LeetcodeSubscription> subscriptions = getSubscriptions();

        System.out.println("Driving...");
    }
}
