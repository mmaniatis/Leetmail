package service.persist;

import model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserSubscriptionCRUDServiceTest {
    UserSubscriptionCRUDService userSubscriptionCRUDService = new UserSubscriptionCRUDService();


    @Test
    public void happyPath() {
        List<User> users = userSubscriptionCRUDService.getUsers();

        Assert.assertTrue(users.size() > 0);
    }

}
