package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(Long id, User user);
    void removeUserById(long id);
    List<User> getUserList();
    User getUserById(long id);
}