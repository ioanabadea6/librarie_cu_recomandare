package com.bookstore.bookstore.model;

public class OrderBookData {
    private Integer order_id;
    private Integer book_id;
    private Integer quantity;

    /**
     * Retrieves the order ID associated with this order book.
     *
     * @return the order ID associated with this order book
     */
    public Integer getOrder_id() {
        return order_id;
    }

    /**
     * Sets the order ID associated with this order book.
     *
     * @param order_id the order ID to be associated with this order book
     */
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    /**
     * Retrieves the book ID associated with this order book.
     *
     * @return the book ID associated with this order book
     */
    public Integer getBook_id() {
        return book_id;
    }

    /**
     * Sets the book ID associated with this order book.
     *
     * @param book_id the book ID to be associated with this order book
     */
    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
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

}
