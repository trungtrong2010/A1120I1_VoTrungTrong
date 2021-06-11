package service;

import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < ProductRepositoryImpl.listProduct.size(); i++) {
            if (id == ProductRepositoryImpl.listProduct.get(i).getId()) {
                return productRepository.findById(i);
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < ProductRepositoryImpl.listProduct.size(); i++) {
            if (id == ProductRepositoryImpl.listProduct.get(i).getId()) {
                productRepository.update(i,product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < ProductRepositoryImpl.listProduct.size(); i++) {
            if (id == ProductRepositoryImpl.listProduct.get(i).getId()) {
                productRepository.remove(i);
            }
        }
    }

    @Override
    public Product findByName(String name) {
        for (int i = 0; i < ProductRepositoryImpl.listProduct.size(); i++) {
            if (name.equals(ProductRepositoryImpl.listProduct.get(i).getName())) {
                return ProductRepositoryImpl.listProduct.get(i);
            }
        }
        return null;
    }
}

