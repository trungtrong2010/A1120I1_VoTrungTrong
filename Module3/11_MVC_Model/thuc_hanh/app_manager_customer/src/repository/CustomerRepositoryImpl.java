package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    public static List<Customer> listCustomers;

    static {
        listCustomers = new ArrayList<>();
        listCustomers.add(new Customer(1, "Võ Trung Trọng", "votrungtrong@mail.com", "Quảng Nam"));
        listCustomers.add(new Customer(2, "Trần Thanh Phương", "tranthanhphuong@mail.com", "Đà Nẵng"));
        listCustomers.add(new Customer(3, "Doãn Mạnh Thắng", "doanmanhthang@mail.com", "Đà Nẵng"));
        listCustomers.add(new Customer(4, "Trần Lý Mỹ Hạnh", "tranlymyhnah@mail.com", "Đà Nẵng"));
        listCustomers.add(new Customer(5, "Phạm Thị Quỳnh Như", "phamthiquynhnhu@mail.com", "Thanh Hóa"));
    }

    @Override
    public List<Customer> findAll() {
        return listCustomers;
    }

    @Override
    public void save(Customer customer) {
        listCustomers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return listCustomers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        listCustomers.set(id, customer);
    }

    @Override
    public void remove(int id) {
        listCustomers.remove(id);
    }
}
