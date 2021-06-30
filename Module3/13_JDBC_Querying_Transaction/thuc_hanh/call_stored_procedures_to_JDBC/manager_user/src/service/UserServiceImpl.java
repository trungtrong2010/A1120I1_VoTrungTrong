package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserRepository repository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User findId(int id) {
        return repository.findId(id);
    }

    @Override
    public void update(int id, User user) {
        repository.update(id,user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<User> findByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<User> sortName() {
        return repository.sortName();
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        repository.addUserTransaction(user, permision);
    }
}