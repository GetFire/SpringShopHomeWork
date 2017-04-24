package com.getfire.shop.dao;

import com.getfire.shop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    void addProduct(Product product);

    List<Product> getAllProducts();

    Product findById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);
}
