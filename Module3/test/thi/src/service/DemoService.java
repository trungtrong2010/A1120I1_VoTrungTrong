package service;

import model.Demo;
import repository.DemoRepository;

import java.util.List;

public class DemoService {
    DemoRepository repository = new DemoRepository();
    public List<Demo> selectAll() {
        return repository.selectAllDemo();
    }
}
