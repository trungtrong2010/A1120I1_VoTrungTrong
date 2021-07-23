package repository;

import model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerRepository {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
