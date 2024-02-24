package org.hillel.spring.repo;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hillel.spring.model.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderHibernateSessionRepo implements OrderRepo {
    private final Session session;

    @Override
    public Order save(Order order) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.persist(order);
            session.flush();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }

        return order;
    }

    @Override
    public Order find(Long id) {
        return session.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        final Query<Order> query = session.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }

    @Override
    public Order remove(Order order) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.remove(order);
            session.flush();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }

        return order;
    }
}
