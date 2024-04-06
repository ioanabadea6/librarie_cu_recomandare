package com.bookstore.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal GrandTotal;

    @OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public ShoppingCart() {
    }

    public ShoppingCart(Long id, BigDecimal grandTotal, List<CartItem> cartItemList, User user) {
        this.id = id;
        GrandTotal = grandTotal;
        this.cartItemList = cartItemList;
        this.user = user;
    }

    /**
     * Gets the ID of the shopping cart.
     * @return the ID of the shopping cart
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the shopping cart.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the grand total of the shopping cart.
     * @return the grand total of the shopping cart
     */
    public BigDecimal getGrandTotal() {
        return GrandTotal;
    }

    /**
     * Sets the grand total of the shopping cart.
     * @param grandTotal the grand total to set
     */
    public void setGrandTotal(BigDecimal grandTotal) {
        GrandTotal = grandTotal;
    }

    /**
     * Gets the list of cart items in the shopping cart.
     * @return the list of cart items in the shopping cart
     */
    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    /**
     * Sets the list of cart items in the shopping cart.
     * @param cartItemList the list of cart items to set
     */
    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    /**
     * Gets the user associated with the shopping cart.
     * @return the user associated with the shopping cart
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the shopping cart.
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
