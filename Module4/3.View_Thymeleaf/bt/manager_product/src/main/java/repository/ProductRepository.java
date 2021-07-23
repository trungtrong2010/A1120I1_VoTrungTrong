package repository;

import model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductRepository {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
