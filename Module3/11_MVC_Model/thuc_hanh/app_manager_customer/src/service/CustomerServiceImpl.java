package service;

import model.Customer;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

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
        for (int i = 0; i < CustomerRepositoryImpl.listCustomers.size(); i++) {
            if (id == CustomerRepositoryImpl.listCustomers.get(i).getId()) {
                return customerRepository.findById(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        for (int i = 0; i < CustomerRepositoryImpl.listCustomers.size(); i++) {
            if (id == CustomerRepositoryImpl.listCustomers.get(i).getId()) {
                customerRepository.update(i, customer);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < CustomerRepositoryImpl.listCustomers.size(); i++) {
            if (id == CustomerRepositoryImpl.listCustomers.get(i).getId()) {
                customerRepository.remove(i);
            }
        }
    }
}