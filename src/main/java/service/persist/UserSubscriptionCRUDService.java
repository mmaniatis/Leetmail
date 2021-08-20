package service.persist;

import model.LeetcodeSubscription;
import model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserSubscriptionCRUDService implements CRUDService {

    public List<User> getUsers() {
        LeetcodeSubscription leetcodeSubscription = new LeetcodeSubscription(
                "array",
                "easy",
                "daily");
        User user = new User("mikejohnmaniatis@gmail.com");

        user.addSubscription(leetcodeSubscription);
        return new ArrayList<>(Arrays.asList(user));
    }

}
