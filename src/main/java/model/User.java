package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private List<LeetcodeSubscription> subscriptions;

    public User(String email) {
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    public void addSubscription(LeetcodeSubscription subscription) {
        this.subscriptions.add(subscription);
    }

    public List<LeetcodeSubscription> getSubscriptions() {
        return this.subscriptions;
    }
}
