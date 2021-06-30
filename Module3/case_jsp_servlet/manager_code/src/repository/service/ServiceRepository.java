package repository.service;

import model.service.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> selectAllService();

    void save(Service service);

    Service getServiceById(int id);

    void update(int id, Service service);

    void remove(int id);

    List<Service> getListCustomerByName(String name);

}
