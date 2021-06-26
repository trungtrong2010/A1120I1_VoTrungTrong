package repository;

import model.CustomerType;

import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    public static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM customer_type;";

    @Override
    public List<CustomerType> selectAllCustomerType() {
        return null;
    }
    @Override
    public CustomerTypeRepository findCustomerTypeById() {
        return null;
    }
}
