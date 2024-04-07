package com.bookstore.bookstore.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Reprezintă o entitate pentru o comandă.
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contactnumber")
    private String contactNumber;

    @Column(name = "paymentmethod")
    private String paymentMethod;

    @Column(name = "total")
    private Integer total;

    @Column(name = "productdetails")
    private String productDetails;

    @Column(name = "createdby")
    private String createdBy;

    /**
     * Constructor implicit pentru Order.
     */
    public Order() {
    }

    /**
     * Constructor pentru o comandă cu ID.
     *
     * @param id             ID-ul comenzii.
     * @param uuid           UUID-ul comenzii.
     * @param name           Numele clientului.
     * @param email          Adresa de email a clientului.
     * @param contactNumber  Numărul de contact al clientului.
     * @param paymentMethod  Metoda de plată.
     * @param total          Totalul comenzii.
     * @param productDetails Detaliile produsului comandat.
     * @param createdBy      Numele persoanei care a creat comanda.
     */
    public Order(Integer id, String uuid, String name, String email, String contactNumber, String paymentMethod, Integer total, String productDetails, String createdBy) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.productDetails = productDetails;
        this.createdBy = createdBy;
    }

    /**
     * Constructor pentru o comandă fără ID.
     *
     * @param uuid           UUID-ul comenzii.
     * @param name           Numele clientului.
     * @param email          Adresa de email a clientului.
     * @param contactNumber  Numărul de contact al clientului.
     * @param paymentMethod  Metoda de plată.
     * @param total          Totalul comenzii.
     * @param productDetails Detaliile produsului comandat.
     * @param createdBy      Numele persoanei care a creat comanda.
     */
    public Order(String uuid, String name, String email, String contactNumber, String paymentMethod, Integer total, String productDetails, String createdBy) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.productDetails = productDetails;
        this.createdBy = createdBy;
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
     * Returnează UUID-ul comenzii.
     *
     * @return UUID-ul comenzii.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setează UUID-ul comenzii.
     *
     * @param uuid UUID-ul comenzii.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
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
     * Returnează detaliile produsului comandat.
     *
     * @return Detaliile produsului comandat.
     */
    public String getProductDetails() {
        return productDetails;
    }

    /**
     * Setează detaliile produsului comandat.
     *
     * @param productDetails Detaliile produsului comandat.
     */
    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    /**
     * Returnează numele persoanei care a creat comanda.
     *
     * @return Numele persoanei care a creat comanda.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Setează numele persoanei care a creat comanda.
     *
     * @param createdBy Numele persoanei care a creat comanda.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
