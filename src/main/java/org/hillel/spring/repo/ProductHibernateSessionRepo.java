package org.hillel.spring.repo;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hillel.spring.model.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
@RequiredArgsConstructor
public class ProductHibernateSessionRepo implements ProductRepo {
    private final SessionFactory sessionFactory;

    @Override
    public Product save(Product product) {
        getCurrentSession().persist(product);
        return product;
    }

    @Override
    public Product find(Long id) {
        return getCurrentSession().find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        final Query<Product> query = getCurrentSession().createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product remove(Product product) {
        getCurrentSession().remove(product);
        return product;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
