package service;

import model.Customer;
import model.CustomerType;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository repository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> selectAllCustomer() {
        return repository.selectAllCustomer();
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}
