package com.getfire.shop.service;

import com.getfire.shop.dao.jpaDao.ProductDao;
import com.getfire.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public void saveProduct(Product product) {
        productDao.saveAndFlush(product);
//        productDao.addProduct(product);


    }

    @Transactional
    public List<Product> findAllProducts() {
//        return productDao.getAllProducts();
        return productDao.findAll();
    }

    @Transactional
    public Product findProductById(long id) {
//        return productDao.findById(id);
        return productDao.findOne(id);
    }

    @Transactional
    public void deleteProduct(long id) {
        productDao.delete(id);
//        productDao.deleteProduct(id);

    }

    @Transactional
    public void updateProduct(Product product) {
        productDao.saveAndFlush(product);
//        productDao.updateProduct(product);
    }
}
