package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.repo.OrderBookRepo;
import com.bookstore.bookstore.repo.OrderRepo;
import com.bookstore.bookstore.repo.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {
    @Mock
    private OrderRepo orderRepoMock;

    @Mock
    private UserRepo userRepoMock;

    @Mock
    private OrderBookRepo orderBookRepoMock;

    private OrderServiceImpl orderServiceImplTest;

    /**
     * Sets up the test environment by initializing mocks and the {@code OrderServiceImpl} instance.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        orderServiceImplTest = new OrderServiceImpl(orderRepoMock, userRepoMock, orderBookRepoMock);
    }

    /**
     * Test case for inserting an order.
     */
    @Test
    public void insertOrderTest(){
        OrderData orderData = new OrderData();
        Order order = new Order();
        orderServiceImplTest.insertOrder(orderData);
        verify(orderRepoMock).save(order);
    }

    /**
     * Test case for deleting an order.
     */
    @Test
    public void deleteOrderTest(){
        OrderData orderData = new OrderData();
        orderData.setName("Test Order");

        Order existingOrder = new Order();
        existingOrder.setName("Test Order");

        when(orderRepoMock.findByName("Test Order")).thenReturn(existingOrder);

        Order result = orderServiceImplTest.deleteOrder(orderData);

        assertEquals(existingOrder, result);
        verify(orderRepoMock).delete(existingOrder);

    }

    /**
     * Test case for updating an order.
     */
    @Test
    public void updateOrderTest(){
        OrderData orderData = new OrderData();
        orderData.setName("Old Name");
        orderData.setEmail("newemail@example.com");


        Order existingOrder = new Order();
        existingOrder.setName("Old Name");
        existingOrder.setEmail("oldemail@example.com");


        when(orderRepoMock.findByName("Old Name")).thenReturn(existingOrder);

        Order updatedOrder = new Order();
        updatedOrder.setName("Old Name");
        updatedOrder.setEmail("newemail@example.com");


        // Act
        Order result = orderServiceImplTest.updateOrder(orderData);

        verify(orderRepoMock).save(updatedOrder);
    }

    /**
     * Test case for finding an order.
     */
    @Test
    public void findOrderTest(){
        OrderData orderData = new OrderData();
        orderServiceImplTest.findOrder(orderData);
        verify(orderRepoMock).findByName(orderData.getName());
    }
}
