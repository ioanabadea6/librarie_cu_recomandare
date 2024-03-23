package com.bookstore.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Represents an item in a shopping cart.
 */
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qty;
    private BigDecimal subtotal;

    @OneToOne
    private Book book;

    @OneToMany(mappedBy = "cartItem")
    @JsonIgnore
    private List<BookToCartItem> bookToCartItemList;

    @ManyToOne
    @JoinColumn(name="shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    /**
     * Default constructor for CartItem.
     */
    public CartItem() {
    }

    /**
     * Constructs a CartItem with the specified details.
     * @param id the ID of the cart item
     * @param qty the quantity of the cart item
     * @param subtotal the subtotal of the cart item
     * @param book the book associated with the cart item
     * @param bookToCartItemList the list of book-to-cart-item associations
     * @param shoppingCart the shopping cart associated with the cart item
     * @param order the order associated with the cart item
     */
    public CartItem(Long id, int qty, BigDecimal subtotal, Book book, List<BookToCartItem> bookToCartItemList, ShoppingCart shoppingCart, Order order) {
        this.id = id;
        this.qty = qty;
        this.subtotal = subtotal;
        this.book = book;
        this.bookToCartItemList = bookToCartItemList;
        this.shoppingCart = shoppingCart;
        this.order = order;
    }

    /**
     * Gets the ID of the cart item.
     * @return the ID of the cart item
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the cart item.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the quantity of the cart item.
     * @return the quantity of the cart item
     */
    public int getQty() {
        return qty;
    }

    /**
     * Sets the quantity of the cart item.
     * @param qty the quantity to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * Gets the subtotal of the cart item.
     * @return the subtotal of the cart item
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /**
     * Sets the subtotal of the cart item.
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
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
     * Gets the list of book-to-cart-item associations.
     * @return the list of book-to-cart-item associations
     */
    public List<BookToCartItem> getBookToCartItemList() {
        return bookToCartItemList;
    }

    /**
     * Sets the list of book-to-cart-item associations.
     * @param bookToCartItemList the list to set
     */
    public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
        this.bookToCartItemList = bookToCartItemList;
    }

    /**
     * Gets the shopping cart associated with the cart item.
     * @return the shopping cart associated with the cart item
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart associated with the cart item.
     * @param shoppingCart the shopping cart to set
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Gets the order associated with the cart item.
     * @return the order associated with the cart item
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the cart item.
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
