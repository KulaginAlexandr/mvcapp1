package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(Long id, User user);

    void removeUserById(long id);

    List<User> getUserList();

    User getUserById(long id);

}
