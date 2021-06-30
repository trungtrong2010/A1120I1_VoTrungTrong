package service.customer;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpl;

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
        for (int i = 0; i < selectAllCustomer().size(); i++) {
            if (selectAllCustomer().get(i).getId() == id) {
                return selectAllCustomer().get(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        repository.update(id,customer);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<Customer> getCustomerByName(String name) {
//        List<Customer> list = new ArrayList<>();
//        for (int i = 0; i < selectAllCustomer().size(); i++) {
//            if (Objects.equals(selectAllCustomer().get(i).getName(), name)) {
//                list.add(selectAllCustomer().get(i));
//            }
//        }
//        return list;
        return repository.getCustomerByName(name);
    }
}
