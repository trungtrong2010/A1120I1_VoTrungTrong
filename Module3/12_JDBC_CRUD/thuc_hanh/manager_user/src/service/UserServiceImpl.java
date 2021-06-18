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
        for (int i = 0; i < repository.findAll().size(); i++) {
            if (id == repository.findAll().get(i).getId()) {
                return repository.findAll().get(i);
            }
        }
        return null;
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
}