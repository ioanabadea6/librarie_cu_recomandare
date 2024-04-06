package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

/**
 * Represents an association between a book and a cart item.
 */
@Entity
public class BookToCartItem {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="cart_item_id")
    private CartItem cartItem;

    /**
     * Default constructor for BookToCartItem.
     */
    public BookToCartItem() {
    }

    /**
     * Constructs a BookToCartItem with the specified details.
     * @param id the ID of the association
     * @param book the book associated with the cart item
     * @param cartItem the cart item associated with the book
     */
    public BookToCartItem(Long id, Book book, CartItem cartItem) {
        this.id = id;
        this.book = book;
        this.cartItem = cartItem;
    }

    /**
     * Gets the ID of the association.
     * @return the ID of the association
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the association.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the book associated with the cart item.
     * @return the book associated with the cart item
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book associated with the cart item.
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the cart item associated with the book.
     * @return the cart item associated with the book
     */
    public CartItem getCartItem() {
        return cartItem;
    }

    /**
     * Sets the cart item associated with the book.
     * @param cartItem the cart item to set
     */
    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}
