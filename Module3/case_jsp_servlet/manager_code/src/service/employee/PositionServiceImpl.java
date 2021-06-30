package service.employee;

import model.employee.Position;
import repository.employee.PositionRepository;
import repository.employee.PositionRepositoryImpl;

import java.util.List;

public class PositionServiceImpl implements PositionService {

    PositionRepository repository = new PositionRepositoryImpl();
    @Override
    public List<Position> seclectAllPosition() {
        return repository.selectAllPosition();
    }

    @Override
    public Position getPositionById(int id) {
        for (int i = 0; i < repository.selectAllPosition().size(); i++) {
            if (repository.selectAllPosition().get(i).getId() == id) {
                return repository.selectAllPosition().get(i);
            }
        }
        return null;
    }
}
