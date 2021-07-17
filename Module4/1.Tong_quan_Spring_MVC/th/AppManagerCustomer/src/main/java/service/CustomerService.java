package service;

import model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {



    List<Customer> findAll();

    Customer findById(int id);
}
