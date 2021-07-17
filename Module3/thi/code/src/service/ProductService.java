package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAllProduct();

    void save(Product product);

    Product getProductById(int id);

    void update(int id, Product product);

    void remove(int id);

    List<Product> getListProductByName(String name);
}
