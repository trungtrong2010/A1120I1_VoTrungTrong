package repository.employee;

import model.employee.EducationDegree;
import model.user.User;

import java.util.List;

public interface UserRepository {
    List<User> selectAllUser();

    User getUserByName(String username);
}
