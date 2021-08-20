package service.driver;

import model.LeetcodeQuestion;
import service.persist.CRUDService;
import service.scrape.ScrapeService;

import java.util.List;
import java.util.Map;

public class LeetcodeMailDriver {
    private final ScrapeService<Map<String, List<LeetcodeQuestion>>> scrapeService;
    private final CRUDService crudService;

    public LeetcodeMailDriver(
            ScrapeService<Map<String, List<LeetcodeQuestion>>> scrapeService,
            CRUDService userSubscriptionCRUDService){
        this.scrapeService = scrapeService;
        this.crudService = userSubscriptionCRUDService;
    }

    public void drive() {
        //TODO: Implement this
        crudService.getUsers()
                .stream()
                .filter(i ->)
        System.out.println("Driving...");
    }


}
