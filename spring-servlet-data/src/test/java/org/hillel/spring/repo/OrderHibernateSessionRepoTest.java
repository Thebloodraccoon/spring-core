package org.hillel.spring.repo;


import org.hibernate.Session;
import org.hillel.spring.model.entity.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OrderHibernateSessionRepoTest extends RepoTestParent {
    private OrderRepo orderRepo;
    private Session testSession;

    @BeforeEach
    public void setUp() {
        testSession = testSessionFactory.openSession();

        orderRepo = new OrderHibernateSessionRepo(testSession);
    }
    @Test
    public void findTest_returnsNonNullOrder() {
        Long testId = 2L;

        final Order order = orderRepo.find(testId);

        assertNotNull(order);
        assertNotNull(order.getId());
        assertEquals(order.getId(), testId);
        assertNotEquals(order.getProducts().size(), 0);
    }

    @Test
    public void findAllTest_returnsNonEmptyOrderList() {
        final List<Order> orders = orderRepo.findAll();

        assertNotNull(orders);
        assertNotEquals(orders.size(), 0);
    }

    @Test
    public void removeTest_removesExistingOrder() {
        Long testId = 3L;

        final Order existing = orderRepo.find(testId);
        final Order removed = orderRepo.remove(existing);

        assertNotNull(removed);
        assertEquals(removed.getId(), testId);
    }

    @Test
    public void saveTest_returnsNonNullHotel() {
        final Order order = new Order();
        order.setCost(200.00);
        order.setData(LocalDate.now());

        final Order savedOrder = orderRepo.save(order);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertEquals(savedOrder.getCost(), order.getCost());
        assertEquals(savedOrder.getData(), order.getData());
    }

    @AfterEach
    public void tearDown() {
        testSession.close();
    }

}