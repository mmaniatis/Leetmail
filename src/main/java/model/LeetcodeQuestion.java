package model;

public class LeetcodeQuestion {
    final String title;
    final String url;

    public LeetcodeQuestion(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
