package com.bookstore.bookstore.entity.security;

import com.bookstore.bookstore.entity.User;
import jakarta.persistence.*;

import java.util.*;

/**
 * Represents a token used for resetting a user's password.
 */
@Entity
public class PasswordResetToken {
    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable=false, name="user_id")
    private User user;

    private Date expiryDate;

    /**
     * Default constructor for PasswordResetToken.
     */
    public PasswordResetToken(){}

    /**
     * Constructs a PasswordResetToken with the specified token and user.
     * @param token the token for resetting the password
     * @param user the user associated with the token
     */
    public PasswordResetToken(final String token, final User user) {
        super ();

        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    /**
     * Calculates the expiry date for the password reset token based on the specified expiration time.
     *
     * @param expiryTimeInMinutes the expiration time in minutes
     * @return the expiry date for the password reset token
     */
    private Date calculateExpiryDate (final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    /**
     * Updates the token and expiry date.
     * @param token the new token value
     */
    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    /**
     * Gets the ID of the password reset token.
     * @return the ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the password reset token.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the token value.
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token value.
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the user associated with the token.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the token.
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the expiry date of the token.
     * @return the expiry date
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the token.
     * @param expiryDate the expiry date to set
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the expiration time for the token.
     * @return the expiration time
     */
    public static int getExpiration() {
        return EXPIRATION;
    }

    /**
     * Provides a string representation of the PasswordResetToken.
     * @return string representation of the PasswordResetToken
     */
    @Override
    public String toString() {
        return "PasswordResetToken [id=" + id + ", token=" + token + ", user=" + user + ", expiryDate=" + expiryDate
                + "]";
    }
}
