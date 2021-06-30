package service;

import model.CustomerType;
import repository.CustomerTypeRepository;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> selectAllCustomerType();

    CustomerType findCustomerTypeById(int id);
}
