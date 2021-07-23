package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
//    CustomerRepository repository = new CustomerRepositoryImpl();

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}
