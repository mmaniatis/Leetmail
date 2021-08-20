package service.persist;

import model.User;

import java.util.List;

public interface CRUDService {
    List<User> getUsers();
}
