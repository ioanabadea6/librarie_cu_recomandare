package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.model.BookData;
import com.bookstore.bookstore.repo.BookRepo;
import com.bookstore.bookstore.repo.CategoryRepo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class BookSeviceImplTest {
    @Mock
    private BookRepo bookRepoMock;
    @Mock
    private CategoryRepo categoryRepoMock;
    private BookServiceImpl bookServiceImplTest;

    @Mock
    private Observer observerMock;

    /**
     * Sets up the test environment by initializing mocks and the {@code BookServiceImpl} instance.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bookServiceImplTest = new BookServiceImpl(bookRepoMock, categoryRepoMock);
        bookServiceImplTest.attach(observerMock);
    }

    /**
     * Test case for inserting a book and notifying the observer.
     */
    @Test
    public void insertBookAndObserver(){
        BookData bookData = new BookData();
        Book book = new Book();
        bookServiceImplTest.insertBook(bookData);
        verify(bookRepoMock).save(book);
    }

    /**
     * Test case for updating a book's stock and notifying the observer.
     */
    @Test
    public void testUpdateBookWithStockChangeAndObserver() {
        // Arrange
        BookData bookData = new BookData();
        bookData.setTitle("Book Title");
        bookData.setStock(20); // New stock value

        Book existingBook = new Book();
        existingBook.setTitle("Book Title");
        existingBook.setStock(10); // Old stock value

        when(bookRepoMock.findByTitle("Book Title")).thenReturn(existingBook);

        Book updatedBook = new Book();
        updatedBook.setTitle("Book Title");
        updatedBook.setStock(20); // Updated stock value

        Book result = bookServiceImplTest.updateBook(bookData);
        verify(bookRepoMock).save(updatedBook);
        verify(observerMock).update("Cartea si-a modificat stocul in 20");
    }

    /**
     * Test case for updating a book's price and notifying the observer.
     */
    @Test
    public void testUpdateBookWithPriceChangeAndObserver() {
        // Arrange
        BookData bookData = new BookData();
        bookData.setTitle("Book Title");
        bookData.setPrice(100); // New price value

        Book existingBook = new Book();
        existingBook.setTitle("Book Title");
        existingBook.setPrice(50); // Old price value

        when(bookRepoMock.findByTitle("Book Title")).thenReturn(existingBook);

        Book updatedBook = new Book();
        updatedBook.setTitle("Book Title");
        updatedBook.setPrice(100); // Updated price value

        Book result = bookServiceImplTest.updateBook(bookData);
        verify(bookRepoMock).save(updatedBook);
        verify(observerMock).update("Cartea si-a modificat pretul in 100");
    }

    /**
     * Test case for deleting a book.
     */
    @Test
    public void deleteBookTest(){
        BookData bookData = new BookData();
        Book book = bookServiceImplTest.deleteBook(bookData);
        verify(bookRepoMock).delete(book);
    }

    /**
     * Test case for finding a book by its data.
     */
    @Test
    public void findBookTest(){
        BookData bookData = new BookData();
        bookServiceImplTest.findBook(bookData);
        verify(bookRepoMock).findByTitle(bookData.getTitle());
    }

    /**
     * Test case for finding all books.
     */
    @Test
    public void findAllBooksTest(){
        bookServiceImplTest.findAll();
        verify(bookRepoMock).findAll();
    }

    /**
     * Test case for finding books by title, price, author, and category.
     */
    @Test
    public void findByTitlePriceAuthorAndCategoryTest(){
        BookData bookData = new BookData();
        bookServiceImplTest.findByTitlePriceAuthorAndCategory(bookData);
        verify(bookRepoMock).findByTitlePriceAuthorAndCategory(bookData.getTitle(),bookData.getPrice(),bookData.getAuthor(), bookData.getCategory_fk());
    }

    /**
     * Test case for creating a notification message for a price change.
     */
    @Test
    public void createNotifyMessagePriceTest(){
        BookData bookData = new BookData();
        bookData.setPrice(100);
        String message = bookServiceImplTest.createNotifyMessagePrice(bookData);
        assertEquals("Cartea si-a modificat pretul in 100", message);
    }

    /**
     * Test case for creating a notification message for a stock change.
     */
    @Test
    public void createNotifyMessageStockTest(){
        BookData bookData = new BookData();
        bookData.setStock(100);
        String message = bookServiceImplTest.createNotifyMessageStock(bookData);
        assertEquals("Cartea si-a modificat stocul in 100", message);
    }


}
