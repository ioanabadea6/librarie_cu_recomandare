package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

/**
 * Represents user billing information.
 */
@Entity
public class UserBilling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userBillingName;
    private String userBillingStreet1;
    private String userBillingStreet2;
    private String userBillingCity;
    private String userBillingState;
    private String userBillingCountry;
    private String userBillingZipcode;

    @OneToOne(cascade=CascadeType.ALL)
    private UserPayment userPayment;

    /**
     * Represents user billing information.
     */
    public UserBilling() {
    }

    /**
     * Constructs a new UserBilling instance with specified parameters.
     *
     * @param id                  The ID of the user billing.
     * @param userBillingName     The name associated with the user billing.
     * @param userBillingStreet1  The first line of the street address.
     * @param userBillingStreet2  The second line of the street address.
     * @param userBillingCity     The city of the user billing address.
     * @param userBillingState    The state of the user billing address.
     * @param userBillingCountry  The country of the user billing address.
     * @param userBillingZipcode  The zipcode of the user billing address.
     * @param userPayment         The associated user payment method.
     */
    public UserBilling(Long id, String userBillingName, String userBillingStreet1, String userBillingStreet2, String userBillingCity, String userBillingState, String userBillingCountry, String userBillingZipcode, UserPayment userPayment) {
        this.id = id;
        this.userBillingName = userBillingName;
        this.userBillingStreet1 = userBillingStreet1;
        this.userBillingStreet2 = userBillingStreet2;
        this.userBillingCity = userBillingCity;
        this.userBillingState = userBillingState;
        this.userBillingCountry = userBillingCountry;
        this.userBillingZipcode = userBillingZipcode;
        this.userPayment = userPayment;
    }

    /**
     * Gets the ID of the user billing.
     * @return The ID of the user billing.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user billing.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name associated with the user billing.
     * @return The name associated with the user billing.
     */
    public String getUserBillingName() {
        return userBillingName;
    }

    /**
     * Sets the name associated with the user billing.
     * @param userBillingName The name to set.
     */
    public void setUserBillingName(String userBillingName) {
        this.userBillingName = userBillingName;
    }

    /**
     * Gets the first line of the street address.
     * @return The first line of the street address.
     */
    public String getUserBillingStreet1() {
        return userBillingStreet1;
    }

    /**
     * Sets the first line of the street address.
     * @param userBillingStreet1 The first line to set.
     */
    public void setUserBillingStreet1(String userBillingStreet1) {
        this.userBillingStreet1 = userBillingStreet1;
    }

    /**
     * Gets the second line of the street address.
     * @return The second line of the street address.
     */
    public String getUserBillingStreet2() {
        return userBillingStreet2;
    }

    /**
     * Sets the second line of the street address.
     * @param userBillingStreet2 The second line to set.
     */
    public void setUserBillingStreet2(String userBillingStreet2) {
        this.userBillingStreet2 = userBillingStreet2;
    }

    /**
     * Gets the city of the user billing address.
     * @return The city of the user billing address.
     */
    public String getUserBillingCity() {
        return userBillingCity;
    }

    /**
     * Sets the city of the user billing address.
     * @param userBillingCity The city to set.
     */
    public void setUserBillingCity(String userBillingCity) {
        this.userBillingCity = userBillingCity;
    }

    /**
     * Gets the state of the user billing address.
     * @return The state of the user billing address.
     */
    public String getUserBillingState() {
        return userBillingState;
    }

    /**
     * Sets the state of the user billing address.
     * @param userBillingState The state to set.
     */
    public void setUserBillingState(String userBillingState) {
        this.userBillingState = userBillingState;
    }

    /**
     * Gets the country of the user billing address.
     * @return The country of the user billing address.
     */
    public String getUserBillingCountry() {
        return userBillingCountry;
    }

    /**
     * Sets the country of the user billing address.
     * @param userBillingCountry The country to set.
     */
    public void setUserBillingCountry(String userBillingCountry) {
        this.userBillingCountry = userBillingCountry;
    }

    /**
     * Gets the zipcode of the user billing address.
     * @return The zipcode of the user billing address.
     */
    public String getUserBillingZipcode() {
        return userBillingZipcode;
    }

    /**
     * Sets the zipcode of the user billing address.
     * @param userBillingZipcode The zipcode to set.
     */
    public void setUserBillingZipcode(String userBillingZipcode) {
        this.userBillingZipcode = userBillingZipcode;
    }

    /**
     * Gets the associated user payment method.
     * @return The associated user payment method.
     */
    public UserPayment getUserPayment() {
        return userPayment;
    }

    /**
     * Sets the associated user payment method.
     * @param userPayment The user payment method to set.
     */
    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }
}
