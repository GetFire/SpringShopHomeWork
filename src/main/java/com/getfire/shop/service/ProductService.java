package com.getfire.shop.service;


import com.getfire.shop.model.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);

    List<Product>findAllProducts();

    Product findProductById(long id);

    void deleteProduct(long id);

    void updateProduct(Product product);

}