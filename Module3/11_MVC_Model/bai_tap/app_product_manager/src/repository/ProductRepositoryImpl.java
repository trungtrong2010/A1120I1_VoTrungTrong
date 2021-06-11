package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    public static List<Product> listProduct;

    static {
        listProduct = new ArrayList<>();
        listProduct.add(new Product(123, "Iphone 6", 2000000, "Iphone 6 1/16gb", "Apple"));
        listProduct.add(new Product(456, "Joy 3", 3100000, "Vsmart Joy 3 3/64gb", "Vsmart"));
        listProduct.add(new Product(789, "Samsung J2", 500000, "Samsung J2 2/16gb", "Samsung"));
        listProduct.add(new Product(113, "Redmi note 4X", 4600000, "Note 4X 3/32gb", "Xiaomi"));
        listProduct.add(new Product(115, "Iphone 7 plus", 5500000, "Iphone 7 plus 3/32gb", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return listProduct;
    }

    @Override
    public void save(Product product) {
        listProduct.add(product);
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.set(id, product);
    }

    @Override
    public void remove(int id) {
        listProduct.remove(id);
    }
}
