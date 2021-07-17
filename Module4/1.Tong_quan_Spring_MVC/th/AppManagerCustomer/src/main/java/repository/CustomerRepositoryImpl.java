package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static List<Customer> listCustomer;
    static {
        listCustomer = new ArrayList<>();
        listCustomer.add(new Customer(1, "Vo"));
        listCustomer.add(new Customer(2, "Trung"));
        listCustomer.add(new Customer(3, "Trong"));
    }

    @Override

    public List<Customer> findAll() {
        return listCustomer;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }
}
