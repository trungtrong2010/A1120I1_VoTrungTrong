package service.employee;

import model.employee.Divition;
import repository.employee.DivitionRepository;
import repository.employee.DivitionRepositoryImpl;

import java.util.List;

public class DivitionServiceImpl implements DivitionService {

    DivitionRepository repository = new DivitionRepositoryImpl();

    @Override
    public List<Divition> selectAllDivition() {
        return repository.selectAllDivition();
    }

    @Override
    public Divition getDivitionById(int id) {
        for (int i = 0; i < repository.selectAllDivition().size(); i++) {
            if (repository.selectAllDivition().get(i).getId() == id) {
                return repository.selectAllDivition().get(i);
            }
        }
        return null;
    }
}
