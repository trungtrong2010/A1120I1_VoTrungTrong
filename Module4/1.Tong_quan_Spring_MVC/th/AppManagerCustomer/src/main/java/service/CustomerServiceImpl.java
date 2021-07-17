package service;

import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository repository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return null;
    }
}
