package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

@Entity
public class ShippingAddress {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ShippingAddressName;
    private String ShippingAddressStreet1;
    private String ShippingAddressStreet2;
    private String ShippingAddressCity;
    private String ShippingAddressState;
    private String ShippingAddressCountry;
    private String ShippingAddressZipcode;

    @OneToOne
    private Order order;

    public ShippingAddress() {
    }

    public ShippingAddress(Long id, String shippingAddressName, String shippingAddressStreet1, String shippingAddressStreet2, String shippingAddressCity, String shippingAddressState, String shippingAddressCountry, String shippingAddressZipcode, Order order) {
        this.id = id;
        ShippingAddressName = shippingAddressName;
        ShippingAddressStreet1 = shippingAddressStreet1;
        ShippingAddressStreet2 = shippingAddressStreet2;
        ShippingAddressCity = shippingAddressCity;
        ShippingAddressState = shippingAddressState;
        ShippingAddressCountry = shippingAddressCountry;
        ShippingAddressZipcode = shippingAddressZipcode;
        this.order = order;
    }

    /**
     * Gets the ID of the shipping address.
     * @return the ID of the shipping address
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the shipping address.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name associated with the shipping address.
     * @return the name associated with the shipping address
     */
    public String getShippingAddressName() {
        return ShippingAddressName;
    }

    /**
     * Sets the name associated with the shipping address.
     * @param shippingAddressName the name to set
     */
    public void setShippingAddressName(String shippingAddressName) {
        ShippingAddressName = shippingAddressName;
    }

    /**
     * Gets the first line of the shipping address street.
     * @return the first line of the shipping address street
     */
    public String getShippingAddressStreet1() {
        return ShippingAddressStreet1;
    }

    /**
     * Sets the first line of the shipping address street.
     * @param shippingAddressStreet1 the first line of the street to set
     */
    public void setShippingAddressStreet1(String shippingAddressStreet1) {
        ShippingAddressStreet1 = shippingAddressStreet1;
    }

    /**
     * Gets the second line of the shipping address street.
     * @return the second line of the shipping address street
     */
    public String getShippingAddressStreet2() {
        return ShippingAddressStreet2;
    }

    /**
     * Sets the second line of the shipping address street.
     * @param shippingAddressStreet2 the second line of the street to set
     */
    public void setShippingAddressStreet2(String shippingAddressStreet2) {
        ShippingAddressStreet2 = shippingAddressStreet2;
    }

    /**
     * Gets the city of the shipping address.
     * @return the city of the shipping address
     */
    public String getShippingAddressCity() {
        return ShippingAddressCity;
    }

    /**
     * Sets the city of the shipping address.
     * @param shippingAddressCity the city to set
     */
    public void setShippingAddressCity(String shippingAddressCity) {
        ShippingAddressCity = shippingAddressCity;
    }

    /**
     * Gets the state of the shipping address.
     * @return the state of the shipping address
     */
    public String getShippingAddressState() {
        return ShippingAddressState;
    }

    /**
     * Sets the state of the shipping address.
     * @param shippingAddressState the state to set
     */
    public void setShippingAddressState(String shippingAddressState) {
        ShippingAddressState = shippingAddressState;
    }

    /**
     * Gets the country of the shipping address.
     * @return the country of the shipping address
     */
    public String getShippingAddressCountry() {
        return ShippingAddressCountry;
    }

    /**
     * Sets the country of the shipping address.
     * @param shippingAddressCountry the country to set
     */
    public void setShippingAddressCountry(String shippingAddressCountry) {
        ShippingAddressCountry = shippingAddressCountry;
    }

    /**
     * Gets the zipcode of the shipping address.
     * @return the zipcode of the shipping address
     */
    public String getShippingAddressZipcode() {
        return ShippingAddressZipcode;
    }

    /**
     * Sets the zipcode of the shipping address.
     * @param shippingAddressZipcode the zipcode to set
     */
    public void setShippingAddressZipcode(String shippingAddressZipcode) {
        ShippingAddressZipcode = shippingAddressZipcode;
    }

    /**
     * Gets the order associated with the shipping address.
     * @return the order associated with the shipping address
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the shipping address.
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
