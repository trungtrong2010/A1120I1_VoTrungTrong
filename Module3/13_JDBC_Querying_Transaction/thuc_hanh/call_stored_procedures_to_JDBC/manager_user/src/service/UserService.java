package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    User findId(int id);

    void update(int id, User user);

    void delete(int id);

    List<User> findByCountry(String country);

    List<User> sortName();

    public void addUserTransaction(User user, int[] permision);
}
