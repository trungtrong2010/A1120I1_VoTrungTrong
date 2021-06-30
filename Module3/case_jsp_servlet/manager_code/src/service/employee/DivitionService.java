package service.employee;

import model.employee.Divition;

import java.util.List;

public interface DivitionService {
    List<Divition> selectAllDivition();

    Divition getDivitionById(int id);
}
