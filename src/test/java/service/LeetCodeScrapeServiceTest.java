package service;

import model.LeetcodeQuestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import service.scrape.LeetCodeScrapeService;

import java.util.List;
import java.util.Map;

public class LeetCodeScrapeServiceTest {
    LeetCodeScrapeService leetCodeScrapeService;
    WebDriver webDriver;
    @Before
    public void before() {
        webDriver = new SafariDriver();
        leetCodeScrapeService = new LeetCodeScrapeService(webDriver);
    }

    @Test
    public void happyPath() {
        Map<String, List<LeetcodeQuestion>> map = leetCodeScrapeService.scrape("https://leetcode.com/tag/array");
        Assert.assertTrue(map.size() > 0);
    }
}
