package service.employee;

import model.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> seclectAllPosition();

    Position getPositionById(int id);
}
