package service;

import model.CustomerType;
import repository.CustomerTypeRepository;
import repository.CustomerTypeRepositoryImpl;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository repository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> selectAllCustomerType() {
        return repository.selectAllCustomerType();
    }

    @Override
    public CustomerTypeRepository findCustomerTypeById() {
        return null;
    }
}
