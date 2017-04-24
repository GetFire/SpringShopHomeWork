package com.getfire.shop.dao;

import com.getfire.shop.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Product>) session.createQuery("from Product").list();
    }

    public Product findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    public void deleteProduct(long id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = findById(id);
        session.delete(product);

    }

    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }
}
