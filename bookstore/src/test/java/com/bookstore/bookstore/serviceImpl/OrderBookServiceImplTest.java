package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.entity.OrderBook;
import com.bookstore.bookstore.model.OrderBookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.OrderBookRepo;
import com.bookstore.bookstore.repo.OrderRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderBookServiceImplTest {
    @Mock
    private OrderBookRepo orderBookRepoMock;
    @Mock
    private OrderRepo orderRepoMock;
    @Mock
    private BookRepo bookRepoMock;
    private OrderBookServiceImpl orderBookServiceImplTest;

    /**
     * Sets up the test environment by initializing mocks and the {@code OrderBookServiceImpl} instance.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        orderBookServiceImplTest = new OrderBookServiceImpl(orderBookRepoMock,orderRepoMock,bookRepoMock);
    }

    /**
     * Test case for inserting an order book.
     */
    @Test
    public void insertOrderBook(){
        OrderBookData orderBookData = new OrderBookData();
        OrderBook orderBook = new OrderBook();
        orderBookServiceImplTest.insertOrderBook(orderBookData);
        verify(orderBookRepoMock).save(orderBook);
    }

    /**
     * Test case for deleting an order book.
     */
    @Test
    public void deleteOrderBook(){
        OrderBookData orderBookData = new OrderBookData();
        OrderBook orderBook = orderBookServiceImplTest.deleteOrderBook(orderBookData);
        verify(orderBookRepoMock).delete(orderBook);
    }

    /**
     * Test case for updating an order book.
     */
    @Test
    public void updateOrderBook(){
        OrderBookData orderBookData = new OrderBookData();
        when(orderBookServiceImplTest.findOrderBook(orderBookData)).thenReturn(new OrderBook());
        OrderBook orderBook = orderBookServiceImplTest.updateOrderBook(orderBookData);
        verify(orderBookRepoMock).findByOrderId(orderBookData.getOrder_id());
    }

    /**
     * Test case for finding an order book.
     */
    @Test
    public void findOrderBook(){
        OrderBookData orderBookData = new OrderBookData();
        orderBookServiceImplTest.findOrderBook(orderBookData);
        verify(orderBookRepoMock).findByOrderId(orderBookData.getOrder_id());
    }

    /**
     * Test case for finding all order books.
     */
    @Test
    public void findAllTest(){
        orderBookServiceImplTest.findAll();
        verify(orderBookRepoMock).findAll();
    }


}
