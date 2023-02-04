package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpLOCAL implements UserDao{
    private List<User> userList = new ArrayList<>();
    private long index =0;
    public UserDaoImpLOCAL() {
        userList.add(new User("Иванна", "Титова", "afasfas@mail.ru"));
        userList.add(new User("Ангелина", "Игнатова", "afasfas@mail.ru"));
        userList.add(new User("Дмитрий", "Фома", "afasfas@mail.ru"));
        userList.add(new User("Игнат", "Кудряшов", "afasfas@mail.ru"));

    }

    @Override
    public void saveUser(User user) {
        user.setId(++index);
        userList.add(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User buffUser = getUserById(id);
        buffUser.setFirstName(user.getFirstName());
        buffUser.setLastName(user.getLastName());
        buffUser.setEmail(user.getEmail());
    }

    @Override
    public void removeUserById(long id) {
        userList.removeIf(user -> user.getId()==id);
    }

    @Override
    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User getUserById(long id) {
        return userList.stream().filter(user -> user.getId()== id).findAny().orElse(null);
    }
}
