package service.employee;

import model.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> selectAllEducationDegree();

    EducationDegree getEducationDegreeById(int id);
}
