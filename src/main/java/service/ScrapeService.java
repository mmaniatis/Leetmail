package service;

public interface ScrapeService<O> {
    O scrape(String url);
}
