package service.customer;

import model.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> selectAllCustomer();

    void save(Customer customer);

    Customer getCustomerById(int id);

    void update(int id, Customer customer);

    void delete(int id);

    List<Customer> getCustomerByName(String name);
}
