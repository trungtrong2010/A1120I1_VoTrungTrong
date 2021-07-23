package repository;

import model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {

    private static List<Customer> list;

    static {
        list = new ArrayList<>();
        list.add(new Customer(131, "Võ", "john@codegym.vn", "Hanoi"));
        list.add(new Customer(24234, "Bill", "bill@codegym.vn", "Danang"));
        list.add(new Customer(3321, "Alex", "alex@codegym.vn", "Saigon"));
        list.add(new Customer(4123, "Adam", "adam@codegym.vn", "Beijin"));
        list.add(new Customer(5123, "Sophia", "sophia@codegym.vn", "Miami"));
        list.add(new Customer(6321, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        return list;
    }

    @Override
    public void save(Customer customer) {
        list.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return list.get(findByIndex(id));
    }

    public static int findByIndex(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Customer customer) {
        list.set(findByIndex(id), customer);
    }

    @Override
    public void remove(int id) {
        list.remove(findByIndex(id));
    }
}
