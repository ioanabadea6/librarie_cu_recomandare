package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

/**
 * Represents user payment information.
 */

@Entity
public class UserPayment {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;
    private boolean defaultPayment;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userPayment")
    private UserBilling userBilling;


    /**
     * Constructs a new UserPayment instance.
     */
    public UserPayment() {
    }

    /**
     * Constructs a new UserPayment instance with specified parameters.
     * @param id             The ID of the user payment.
     * @param type           The type of payment (e.g., credit card, debit card).
     * @param cardName       The name associated with the card.
     * @param cardNumber     The card number.
     * @param expiryMonth    The expiration month of the card.
     * @param expiryYear     The expiration year of the card.
     * @param cvc            The card verification code.
     * @param holderName     The name of the card holder.
     * @param defaultPayment Indicates whether this payment method is the default for the user.
     * @param user           The user associated with this payment method.
     * @param userBilling    The user billing information associated with this payment method.
     */
    public UserPayment(Long id, String type, String cardName, String cardNumber, int expiryMonth, int expiryYear, int cvc, String holderName, boolean defaultPayment, User user, UserBilling userBilling) {
        this.id = id;
        this.type = type;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvc = cvc;
        this.holderName = holderName;
        this.defaultPayment = defaultPayment;
        this.user = user;
        this.userBilling = userBilling;
    }

    /**
     * Gets the ID of the user payment.
     * @return The ID of the user payment.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the user payment.
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the type of payment.
     * @return The type of payment.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of payment.
     * @param type The type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the name associated with the card.
     * @return The card name.
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Sets the name associated with the card.
     * @param cardName The card name to set.
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Gets the card number.
     * @return The card number.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number.
     * @param cardNumber The card number to set.
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the expiration month of the card.
     * @return The expiration month.
     */
    public int getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * Sets the expiration month of the card.
     * @param expiryMonth The expiration month to set.
     */
    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    /**
     * Gets the expiration year of the card.
     * @return The expiration year.
     */
    public int getExpiryYear() {
        return expiryYear;
    }

    /**
     * Sets the expiration year of the card.
     * @param expiryYear The expiration year to set.
     */
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    /**
     * Gets the card verification code.
     * @return The card verification code.
     */
    public int getCvc() {
        return cvc;
    }

    /**
     * Sets the card verification code.
     * @param cvc The card verification code to set.
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    /**
     * Gets the name of the card holder.
     * @return The name of the card holder.
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Sets the name of the card holder.
     * @param holderName The name of the card holder to set.
     */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * Checks if this payment method is the default for the user.
     * @return True if this is the default payment method, otherwise false.
     */
    public boolean isDefaultPayment() {
        return defaultPayment;
    }

    /**
     * Sets whether this payment method is the default for the user.
     * @param defaultPayment True to set as default payment method, otherwise false.
     */
    public void setDefaultPayment(boolean defaultPayment) {
        this.defaultPayment = defaultPayment;
    }

    /**
     * Gets the user associated with this payment method.
     * @return The user associated with this payment method.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with this payment method.
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the user billing information associated with this payment method.
     * @return The user billing information associated with this payment method.
     */
    public UserBilling getUserBilling() {
        return userBilling;
    }

    /**
     * Sets the user billing information associated with this payment method.
     * @param userBilling The user billing information to set.
     */
    public void setUserBilling(UserBilling userBilling) {
        this.userBilling = userBilling;
    }
}
