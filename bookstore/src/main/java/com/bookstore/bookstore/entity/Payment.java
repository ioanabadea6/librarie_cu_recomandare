package com.bookstore.bookstore.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;

    @OneToOne
    private Order order;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userPayment")
    private UserBilling userBilling;

    public Payment() {
    }

    public Payment(Long id, String type, String cardName, String cardNumber, int expiryMonth, int expiryYear, int cvc, String holderName, Order order, UserBilling userBilling) {
        this.id = id;
        this.type = type;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.cvc = cvc;
        this.holderName = holderName;
        this.order = order;
        this.userBilling = userBilling;
    }

    /**
     * Gets the ID of the payment.
     * @return the ID of the payment
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the payment.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the type of payment (e.g., credit card, PayPal).
     * @return the type of payment
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of payment.
     * @param type the type of payment to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the name on the card.
     * @return the name on the card
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Sets the name on the card.
     * @param cardName the name on the card to set
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * Gets the card number.
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number.
     * @param cardNumber the card number to set
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the expiry month of the card.
     * @return the expiry month of the card
     */
    public int getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * Sets the expiry month of the card.
     * @param expiryMonth the expiry month to set
     */
    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    /**
     * Gets the expiry year of the card.
     * @return the expiry year of the card
     */
    public int getExpiryYear() {
        return expiryYear;
    }

    /**
     * Sets the expiry year of the card.
     * @param expiryYear the expiry year to set
     */
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    /**
     * Gets the card's security code.
     * @return the card's security code
     */
    public int getCvc() {
        return cvc;
    }

    /**
     * Sets the card's security code.
     * @param cvc the security code to set
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    /**
     * Gets the name of the cardholder.
     * @return the name of the cardholder
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Sets the name of the cardholder.
     * @param holderName the name of the cardholder to set
     */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * Gets the order associated with the payment.
     * @return the order associated with the payment
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the payment.
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Gets the user billing details associated with the payment.
     * @return the user billing details associated with the payment
     */
    public UserBilling getUserBilling() {
        return userBilling;
    }

    /**
     * Sets the user billing details associated with the payment.
     * @param userBilling the user billing details to set
     */
    public void setUserBilling(UserBilling userBilling) {
        this.userBilling = userBilling;
    }
}
