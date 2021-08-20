package service.scrape;

public interface ScrapeService<O> {
    O scrape(String url);
}
