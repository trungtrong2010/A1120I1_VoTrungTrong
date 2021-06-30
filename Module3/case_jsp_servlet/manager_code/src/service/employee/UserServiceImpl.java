package service.employee;

import model.user.User;
import repository.employee.UserRepository;
import repository.employee.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository repository = new UserRepositoryImpl();

    @Override
    public List<User> selectAllUser() {
        return repository.selectAllUser();
    }

    @Override
    public User getUserByName(String username) {
        return repository.getUserByName(username);
    }
}
