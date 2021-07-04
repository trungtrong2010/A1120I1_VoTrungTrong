package service.service;

import model.service.Service;
import repository.service.ServiceRepository;
import repository.service.ServiceRepositoryImpl;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {

    ServiceRepository repository = new ServiceRepositoryImpl();

    @Override
    public List<Service> selectAllService() {
        return repository.selectAllService();
    }

    @Override
    public void save(Service service) {
        repository.save(service);
    }

    @Override
    public Service getServiceById(int id) {
        return repository.getServiceById(id);
    }

    @Override
    public void update(int id, Service service) {
        repository.update(id, service);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<Service> getListServiceByName(String name) {
        return repository.getListServiceByName(name);
    }

    @Override
    public boolean isFullName(String name) {
        String expression = "^[a-zA-Z\\s]+";
        return name.matches(expression);
    }

    @Override
    public boolean isNumberPositive(int number) {
        if (number > 0) return true;
        else return false;
    }

    @Override
    public boolean isDoublePositive(double number) {
        if (number > 0) return true;
        else return false;
    }

    @Override
    public boolean isNullPointerException(String string) {
        if (string != null) return true;
        else return false;
    }
}
