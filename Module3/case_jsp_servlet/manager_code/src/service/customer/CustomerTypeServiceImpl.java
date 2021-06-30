package service.customer;

import model.customer.CustomerType;
import repository.customer.CustomerTypeRepository;
import repository.customer.CustomerTypeRepositoryImpl;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository repository = new CustomerTypeRepositoryImpl();

    @Override
    public List<CustomerType> selectAllCustomerType() {
        return repository.selectAllCustomerType();
    }

    @Override
    public CustomerType findCustomerTypeById(int id) {
        for (int i = 0; i < selectAllCustomerType().size(); i++) {
            if (selectAllCustomerType().get(i).getId() == id) {
                return selectAllCustomerType().get(i);
            }
        }
        return null;
    }
}
