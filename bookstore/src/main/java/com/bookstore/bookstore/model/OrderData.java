package com.bookstore.bookstore.model;

import java.util.List;

/**
 * Clasa pentru reprezentarea datelor unei comenzi.
 */
public class OrderData {
    private String name;
    private String email;
    private String contactNumber;
    private String paymentMethod;
    private Integer total;
    private Integer userId;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returnează numele clientului.
     *
     * @return Numele clientului.
     */
    public String getName() {
        return name;
    }

    /**
     * Setează numele clientului.
     *
     * @param name Numele clientului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returnează adresa de email a clientului.
     *
     * @return Adresa de email a clientului.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setează adresa de email a clientului.
     *
     * @param email Adresa de email a clientului.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returnează numărul de contact al clientului.
     *
     * @return Numărul de contact al clientului.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Setează numărul de contact al clientului.
     *
     * @param contactNumber Numărul de contact al clientului.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Returnează metoda de plată a comenzii.
     *
     * @return Metoda de plată a comenzii.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Setează metoda de plată a comenzii.
     *
     * @param paymentMethod Metoda de plată a comenzii.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Returnează totalul comenzii.
     *
     * @return Totalul comenzii.
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Setează totalul comenzii.
     *
     * @param total Totalul comenzii.
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Gets the ID of the user associated with the order.
     *
     * @return The ID of the user.
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user associated with the order.
     *
     * @param userId The ID of the user.
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
