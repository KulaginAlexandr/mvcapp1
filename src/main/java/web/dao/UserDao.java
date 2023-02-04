package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> getUserList();

    User getUserById(long id);

}
