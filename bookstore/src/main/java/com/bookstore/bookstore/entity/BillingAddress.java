package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

/**
 * Represents a billing address associated with an order.
 */
@Entity
public class BillingAddress {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "BillingAddressName", nullable = false)
    private String BillingAddressName;
    @Column(name = "BillingAddressStreet1", nullable = false)
    private String BillingAddressStreet1;
    @Column(name = "BillingAddressStreet2", nullable = false)
    private String BillingAddressStreet2;
    @Column(name = "BillingAddressCity", nullable = false)
    private String BillingAddressCity;
    @Column(name = "BillingAddressState", nullable = false)
    private String BillingAddressState;
    @Column(name = "BillingAddressCountry", nullable = false)
    private String BillingAddressCountry;
    @Column(name = "BillingAddressZipcode", nullable = false)
    private String BillingAddressZipcode;
    @OneToOne
    private Order order;

    /**
     * Default constructor for BillingAddress.
     */
    public BillingAddress() {
    }

    /**
     * Constructs a BillingAddress with the specified details.
     * @param id the ID of the billing address
     * @param billingAddressName the name associated with the billing address
     * @param billingAddressStreet1 the first street address
     * @param billingAddressStreet2 the second street address
     * @param billingAddressCity the city
     * @param billingAddressState the state or region
     * @param billingAddressCountry the country
     * @param billingAddressZipcode the postal code
     * @param order the order associated with the billing address
     */
    public BillingAddress(Long id, String billingAddressName, String billingAddressStreet1, String billingAddressStreet2, String billingAddressCity, String billingAddressState, String billingAddressCountry, String billingAddressZipcode, Order order) {
        this.id = id;
        BillingAddressName = billingAddressName;
        BillingAddressStreet1 = billingAddressStreet1;
        BillingAddressStreet2 = billingAddressStreet2;
        BillingAddressCity = billingAddressCity;
        BillingAddressState = billingAddressState;
        BillingAddressCountry = billingAddressCountry;
        BillingAddressZipcode = billingAddressZipcode;
        this.order = order;
    }

    /**
     * Gets the ID of the billing address.
     * @return the ID of the billing address
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the billing address.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name associated with the billing address.
     * @return the name of the billing address
     */
    public String getBillingAddressName() {
        return BillingAddressName;
    }

    /**
     * Sets the name associated with the billing address.
     * @param billingAddressName the name to set
     */
    public void setBillingAddressName(String billingAddressName) {
        BillingAddressName = billingAddressName;
    }

    /**
     * Gets the first street address of the billing address.
     * @return the first street address
     */
    public String getBillingAddressStreet1() {
        return BillingAddressStreet1;
    }

    /**
     * Sets the first street address of the billing address.
     * @param billingAddressStreet1 the first street address to set
     */
    public void setBillingAddressStreet1(String billingAddressStreet1) {
        BillingAddressStreet1 = billingAddressStreet1;
    }

    /**
     * Gets the second street address of the billing address.
     * @return the second street address
     */
    public String getBillingAddressStreet2() {
        return BillingAddressStreet2;
    }

    /**
     * Sets the second street address of the billing address.
     * @param billingAddressStreet2 the second street address to set
     */
    public void setBillingAddressStreet2(String billingAddressStreet2) {
        BillingAddressStreet2 = billingAddressStreet2;
    }

    /**
     * Gets the city of the billing address.
     * @return the city of the billing address
     */
    public String getBillingAddressCity() {
        return BillingAddressCity;
    }

    /**
     * Sets the city of the billing address.
     * @param billingAddressCity the city to set
     */
    public void setBillingAddressCity(String billingAddressCity) {
        BillingAddressCity = billingAddressCity;
    }

    /**
     * Gets the state or region of the billing address.
     * @return the state or region of the billing address
     */
    public String getBillingAddressState() {
        return BillingAddressState;
    }

    /**
     * Sets the state or region of the billing address.
     * @param billingAddressState the state or region to set
     */
    public void setBillingAddressState(String billingAddressState) {
        BillingAddressState = billingAddressState;
    }

    /**
     * Gets the country of the billing address.
     * @return the country of the billing address
     */
    public String getBillingAddressCountry() {
        return BillingAddressCountry;
    }

    /**
     * Sets the country of the billing address.
     * @param billingAddressCountry the country to set
     */
    public void setBillingAddressCountry(String billingAddressCountry) {
        BillingAddressCountry = billingAddressCountry;
    }

    /**
     * Gets the postal code of the billing address.
     * @return the postal code of the billing address
     */
    public String getBillingAddressZipcode() {
        return BillingAddressZipcode;
    }

    /**
     * Sets the postal code of the billing address.
     * @param billingAddressZipcode the postal code to set
     */
    public void setBillingAddressZipcode(String billingAddressZipcode) {
        BillingAddressZipcode = billingAddressZipcode;
    }

    /**
     * Gets the order associated with the billing address.
     * @return the order associated with the billing address
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the billing address.
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
