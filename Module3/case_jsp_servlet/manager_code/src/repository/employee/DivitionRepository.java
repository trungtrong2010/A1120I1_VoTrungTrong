package repository.employee;

import model.employee.Divition;

import java.util.List;

public interface DivitionRepository {
    List<Divition> selectAllDivition();

    Divition getDivitionById(int id);
}
