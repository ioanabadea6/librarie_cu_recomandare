package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class User  {
    @Id
   // @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @Column(name="email", nullable = false, updatable = false)
    private String email;
    private String phone;
    private boolean enabled=true;
    private Role2 userRole;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private ShoppingCart shoppingCart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserShipping> userShippingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPayment> userPaymentList;
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
    public User() {
    }

    public User(Long id, String username, String password, String firstName, String lastName, String email, String phone, boolean enabled, ShoppingCart shoppingCart, List<UserShipping> userShippingList, List<UserPayment> userPaymentList, List<Order> orderList, Role2 userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.enabled = enabled;
        this.shoppingCart = shoppingCart;
        this.userShippingList = userShippingList;
        this.userPaymentList = userPaymentList;
        this.orderList = orderList;
        this.userRole = userRole;
    }

    /**
     * Gets the user's ID.
     * @return The user's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     * @return The user's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username The username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name of the user.
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     * @param firstName The first name to be set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the user.
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     * @param lastName The last name to be set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the user.
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email The email address to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the user.
     * @return The phone number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the user.
     * @param phone The phone number to be set.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the enabled status of the user's account.
     * @param enabled The enabled status to be set.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets the shopping cart associated with the user.
     * @return The shopping cart.
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart associated with the user.
     * @param shoppingCart The shopping cart to be set.
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Gets the list of user shipping addresses.
     * @return The list of user shipping addresses.
     */
    public List<UserShipping> getUserShippingList() {
        return userShippingList;
    }

    /**
     * Sets the list of user shipping addresses.
     * @param userShippingList The list of user shipping addresses to be set.
     */
    public void setUserShippingList(List<UserShipping> userShippingList) {
        this.userShippingList = userShippingList;
    }

    /**
     * Gets the list of user payment methods.
     * @return The list of user payment methods.
     */
    public List<UserPayment> getUserPaymentList() {
        return userPaymentList;
    }

    /**
     * Sets the list of user payment methods.
     * @param userPaymentList The list of user payment methods to be set.
     */
    public void setUserPaymentList(List<UserPayment> userPaymentList) {
        this.userPaymentList = userPaymentList;
    }

    /**
     * Gets the list of orders associated with the user.
     * @return The list of orders.
     */
    public List<Order> getOrderList() {
        return orderList;
    }

    /**
     * Sets the list of orders associated with the user.
     * @param orderList The list of orders to be set.
     */
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    /**
     * Gets the roles assigned to the user.
     * @return The set of user roles.
     */
    public Role2 getUserRole() {
        return userRole;


    }

    /**
     * Sets the roles assigned to the user.
     * @param userRole The set of user roles to be set.
     */
    public void setUserRole(Role2 userRole) {
        this.userRole = userRole;
    }

}
