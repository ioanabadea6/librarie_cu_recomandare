package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Represents an order placed by a user.
 */
@Entity
@Table(name="user_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date orderDate;
    private Date shippingDate;
    private String shippingMethod;
    private String orderStatus;
    private BigDecimal orderTotal;

    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL )
    private List<CartItem> cartItemList;

    @OneToOne(cascade=CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @OneToOne(cascade=CascadeType.ALL)
    private BillingAddress billingAddress;

    @OneToOne(cascade=CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    private User user;

    /**
     * Default constructor for Order.
     */
    public Order() {
    }

    /**
     * Constructs an Order with the specified details.
     * @param id the ID of the order
     * @param orderDate the date the order was placed
     * @param shippingDate the date the order was shipped
     * @param shippingMethod the shipping method for the order
     * @param orderStatus the status of the order
     * @param orderTotal the total amount of the order
     * @param cartItemList the list of cart items in the order
     * @param shippingAddress the shipping address for the order
     * @param billingAddress the billing address for the order
     * @param payment the payment details for the order
     * @param user the user who placed the order
     */
    public Order(Long id, Date orderDate, Date shippingDate, String shippingMethod, String orderStatus, BigDecimal orderTotal, List<CartItem> cartItemList, ShippingAddress shippingAddress, BillingAddress billingAddress, Payment payment, User user) {
        this.id = id;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
        this.shippingMethod = shippingMethod;
        this.orderStatus = orderStatus;
        this.orderTotal = orderTotal;
        this.cartItemList = cartItemList;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.payment = payment;
        this.user = user;
    }

    /**
     * Gets the ID of the order.
     * @return the ID of the order
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the order.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the date the order was placed.
     * @return the date the order was placed
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date the order was placed.
     * @param orderDate the date to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the date the order was shipped.
     * @return the date the order was shipped
     */
    public Date getShippingDate() {
        return shippingDate;
    }

    /**
     * Gets the date the order was shipped.
     * @return the date the order was shipped
     */
    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    /**
     * Gets the shipping method for the order.
     * @return the shipping method for the order
     */
    public String getShippingMethod() {
        return shippingMethod;
    }

    /**
     * Sets the shipping method for the order.
     * @param shippingMethod the shipping method to set
     */
    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    /**
     * Gets the status of the order.
     * @return the status of the order
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the status of the order.
     * @param orderStatus the status to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Gets the total amount of the order.
     * @return the total amount of the order
     */
    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    /**
     * Sets the total amount of the order.
     * @param orderTotal the total amount to set
     */
    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    /**
     * Gets the list of cart items in the order.
     * @return the list of cart items in the order
     */
    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    /**
     * Sets the list of cart items in the order.
     * @param cartItemList the list to set
     */
    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    /**
     * Gets the shipping address for the order.
     * @return the shipping address for the order
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shipping address for the order.
     * @param shippingAddress the shipping address to set
     */
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets the billing address for the order.
     * @return the billing address for the order
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the billing address for the order.
     * @param billingAddress the billing address to set
     */
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets the payment details for the order.
     * @return the payment details for the order
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Sets the payment details for the order.
     * @param payment the payment details to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Gets the user who placed the order.
     * @return the user who placed the order
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who placed the order.
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
