package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_book")
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    private Integer quantity;


    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of this order book.
     *
     * @param id the ID to be set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retrieves the order associated with this order book.
     *
     * @return the order associated with this order book
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with this order book.
     *
     * @param order the order to be associated with this order book
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Retrieves the book associated with this order book.
     *
     * @return the book associated with this order book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book associated with this order book.
     *
     * @param book the book to be associated with this order book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Retrieves the quantity of books in this order book.
     *
     * @return the quantity of books in this order book
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of books in this order book.
     *
     * @param quantity the quantity of books to be set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the {@code o} argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBook orderBook = (OrderBook) o;
        return Objects.equals(id, orderBook.id) && Objects.equals(order, orderBook.order) && Objects.equals(book, orderBook.book) && Objects.equals(quantity, orderBook.quantity);
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of
     * hash tables such as those provided by {@link java.util.HashMap}.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, order, book, quantity);
    }
}
