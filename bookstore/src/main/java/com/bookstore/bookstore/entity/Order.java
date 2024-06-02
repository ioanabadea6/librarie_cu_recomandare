package com.bookstore.bookstore.entity;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Reprezintă o entitate pentru o comandă.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contactnumber")
    private String contactNumber;

    @Column(name = "paymentmethod")
    private String paymentMethod;

    @Column(name = "address")
    private String address;

    @Column(name = "total")
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    /**
     * Constructor implicit pentru Order.
     */
    public Order() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returnează ID-ul comenzii.
     *
     * @return ID-ul comenzii.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setează ID-ul comenzii.
     *
     * @param id ID-ul comenzii.
     */
    public void setId(Integer id) {
        this.id = id;
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
     * Retrieves the user associated with this order.
     *
     * @return the user associated with this order
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with this order.
     *
     * @param user the user to be associated with this order
     */
    public void setUser(User user) {
        this.user = user;
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
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(name, order.name) && Objects.equals(email, order.email) && Objects.equals(contactNumber, order.contactNumber) && Objects.equals(paymentMethod, order.paymentMethod) && Objects.equals(total, order.total) && Objects.equals(user, order.user);
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of
     * hash tables such as those provided by {@link java.util.HashMap}.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, contactNumber, paymentMethod, total, user);
    }
}
