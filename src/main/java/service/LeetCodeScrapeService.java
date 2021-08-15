package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.LeetcodeQuestion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeetCodeScrapeService implements ScrapeService<Map<String, List<LeetcodeQuestion>>> {
    final WebDriver webDriver;
    final static String ELEMENT_TO_WAIT_ON = "table.table__XKyc";
    final static String ELEMENT_TO_SCRAPE = ".reactable-data tr";
    final static String EASY_DIFFICULTY = "easy";
    final static String MEDIUM_DIFFICULTY = "medium";
    final static String HARD_DIFFICULTY = "hard";


    public LeetCodeScrapeService(WebDriver _webDriver) {
        webDriver = _webDriver;
    }

    //Wrapper method for WebDriver.get(String s)
    //Contains some custom error handling + logging in case of any issue.
    private void openUrl(final String url) {
        if(url.isEmpty())
            throw new NullPointerException("error url provided to openUrl was empty");
        try {
            webDriver.get(url);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    //Target the ELEMENT_TO_WAIT_ON until it is there. Once element is loaded on page we can break loop and continue
    private void waitForLoad() {
        List<WebElement> element = new ArrayList<>();
        while(element.size() < 1) {
            element = webDriver.findElements(By.cssSelector(ELEMENT_TO_WAIT_ON));
        }
    }

    private List<LeetcodeQuestion> getElementsByDifficulty(final String difficulty) {
        List<WebElement> table = webDriver.findElements(By.cssSelector(ELEMENT_TO_SCRAPE));
        return table.stream()
                .filter(element -> element.getText().toLowerCase().contains(difficulty.toLowerCase()))
                .map(element -> {
                    String title = element.findElement(By.tagName("a")).getText();
                    String url = element.findElement(By.tagName("a")).getAttribute("href");
                    return new LeetcodeQuestion(title, url);
                })
                .collect(Collectors.toList());
    }

    private void populateQuestionMap(Map<String, List<LeetcodeQuestion>> map) {
        List<LeetcodeQuestion> easyQuestions = getElementsByDifficulty(EASY_DIFFICULTY);
        List<LeetcodeQuestion> mediumQuestions = getElementsByDifficulty(MEDIUM_DIFFICULTY);
        List<LeetcodeQuestion> hardQuestions = getElementsByDifficulty(HARD_DIFFICULTY);

        map.put(EASY_DIFFICULTY, easyQuestions);
        map.put(MEDIUM_DIFFICULTY, mediumQuestions);
        map.put(HARD_DIFFICULTY, hardQuestions);
    }

    public Map<String, List<LeetcodeQuestion>> scrape(final String url) {
        openUrl(url);

        waitForLoad();

        Map<String, List<LeetcodeQuestion>> map = new HashMap<>(3);
        populateQuestionMap(map);

        return map;
    }
}
