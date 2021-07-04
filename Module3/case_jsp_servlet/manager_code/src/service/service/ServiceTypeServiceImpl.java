package service.service;

import model.service.ServiceType;
import repository.service.ServiceTypeRepository;
import repository.service.ServiceTypeRepositoryImpl;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {

    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    @Override
    public List<ServiceType> selectAllServiceType() {
        return serviceTypeRepository.selectAllServiceType();
    }

    @Override
    public ServiceType getServiceTypeById(int id) {
        return serviceTypeRepository.getServiceTypeById(id);
    }
}