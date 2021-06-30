package repository.employee;

import model.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeRepository {
    List<EducationDegree> selectAllEducationDegree();

    EducationDegree getEducationDegreeById(int id);
}
