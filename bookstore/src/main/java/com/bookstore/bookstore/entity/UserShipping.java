package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

/**
 * Represents user shipping information.
 */
@Entity
public class UserShipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userShippingName;
    private String userShippingStreet1;
    private String userShippingStreet2;
    private String userShippingCity;
    private String userShippingState;
    private String userShippingCountry;
    private String userShippingZipcode;
    private boolean userShippingDefault;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Constructs a new UserShipping instance.
     */
    public UserShipping() {
    }

    /**
     * Constructs a new UserShipping instance with specified parameters.
     *
     * @param id                   The ID of the user shipping.
     * @param userShippingName     The name associated with the user shipping.
     * @param userShippingStreet1  The first line of the shipping address.
     * @param userShippingStreet2  The second line of the shipping address.
     * @param userShippingCity     The city of the shipping address.
     * @param userShippingState    The state of the shipping address.
     * @param userShippingCountry  The country of the shipping address.
     * @param userShippingZipcode  The zipcode of the shipping address.
     * @param userShippingDefault Indicates whether this shipping address is the default for the user.
     * @param user                 The user associated with this shipping address.
     */
    public UserShipping(Long id, String userShippingName, String userShippingStreet1, String userShippingStreet2, String userShippingCity, String userShippingState, String userShippingCountry, String userShippingZipcode, boolean userShippingDefault, User user) {
        this.id = id;
        this.userShippingName = userShippingName;
        this.userShippingStreet1 = userShippingStreet1;
        this.userShippingStreet2 = userShippingStreet2;
        this.userShippingCity = userShippingCity;
        this.userShippingState = userShippingState;
        this.userShippingCountry = userShippingCountry;
        this.userShippingZipcode = userShippingZipcode;
        this.userShippingDefault = userShippingDefault;
        this.user = user;
    }

    /**
     * Gets the ID of the user shipping.
     * @return The ID of the user shipping.
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the ID of the user shipping.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name associated with the user shipping.
     * @return The name associated with the user shipping.
     */
    public String getUserShippingName() {
        return userShippingName;
    }

    /**
     * Sets the name associated with the user shipping.
     * @param userShippingName The name to set.
     */
    public void setUserShippingName(String userShippingName) {
        this.userShippingName = userShippingName;
    }

    /**
     * Gets the first line of the shipping address.
     * @return The first line of the shipping address.
     */
    public String getUserShippingStreet1() {
        return userShippingStreet1;
    }

    /**
     * Sets the first line of the shipping address.
     * @param userShippingStreet1 The first line to set.
     */
    public void setUserShippingStreet1(String userShippingStreet1) {
        this.userShippingStreet1 = userShippingStreet1;
    }

    /**
     * Gets the second line of the shipping address.
     * @return The second line of the shipping address.
     */
    public String getUserShippingStreet2() {
        return userShippingStreet2;
    }

    /**
     * Sets the second line of the shipping address.
     * @param userShippingStreet2 The second line to set.
     */
    public void setUserShippingStreet2(String userShippingStreet2) {
        this.userShippingStreet2 = userShippingStreet2;
    }

    /**
     * Gets the city of the shipping address.
     * @return The city of the shipping address.
     */
    public String getUserShippingCity() {
        return userShippingCity;
    }

    /**
     * Sets the city of the shipping address.
     * @param userShippingCity The city to set.
     */
    public void setUserShippingCity(String userShippingCity) {
        this.userShippingCity = userShippingCity;
    }

    /**
     * Gets the state of the shipping address.
     * @return The state of the shipping address.
     */
    public String getUserShippingState() {
        return userShippingState;
    }

    /**
     * Sets the state of the shipping address.
     * @param userShippingState The state to set.
     */
    public void setUserShippingState(String userShippingState) {
        this.userShippingState = userShippingState;
    }

    /**
     * Gets the country of the shipping address.
     * @return The country of the shipping address.
     */
    public String getUserShippingCountry() {
        return userShippingCountry;
    }

    /**
     * Sets the country of the shipping address.
     * @param userShippingCountry The country to set.
     */
    public void setUserShippingCountry(String userShippingCountry) {
        this.userShippingCountry = userShippingCountry;
    }

    /**
     * Gets the zipcode of the shipping address.
     * @return The zipcode of the shipping address.
     */
    public String getUserShippingZipcode() {
        return userShippingZipcode;
    }

    /**
     * Sets the zipcode of the shipping address.
     * @param userShippingZipcode The zipcode to set.
     */
    public void setUserShippingZipcode(String userShippingZipcode) {
        this.userShippingZipcode = userShippingZipcode;
    }

    /**
     * Checks if this shipping address is the default for the user.
     * @return True if this is the default shipping address, otherwise false.
     */
    public boolean isUserShippingDefault() {
        return userShippingDefault;
    }

    /**
     * Sets whether this shipping address is the default for the user.
     * @param userShippingDefault True to set as default shipping address, otherwise false.
     */
    public void setUserShippingDefault(boolean userShippingDefault) {
        this.userShippingDefault = userShippingDefault;
    }

    /**
     * Gets the user associated with this shipping address.
     * @return The user associated with this shipping address.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with this shipping address.
     * @param user The user associated with this shipping address.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
