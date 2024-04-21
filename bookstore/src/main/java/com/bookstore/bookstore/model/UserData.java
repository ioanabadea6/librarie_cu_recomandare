package com.bookstore.bookstore.model;

/**
 * Clasa pentru reprezentarea datelor unui utilizator.
 */
public class UserData {
    private String username;
    private String name;
    private String contactNumber;
    private String email;
    private String password;
    private String role;


    /**
     * Returnează utilizatorul.
     *
     * @return utilizatorul.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setează numele utilizatorul.
     *
     * @param username utilizatorul.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returnează numele utilizatorului.
     *
     * @return Numele utilizatorului.
     */
    public String getName() {
        return name;
    }

    /**
     * Setează numele utilizatorului.
     *
     * @param name Numele utilizatorului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returnează numărul de contact al utilizatorului.
     *
     * @return Numărul de contact al utilizatorului.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Setează numărul de contact al utilizatorului.
     *
     * @param contactNumber Numărul de contact al utilizatorului.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Returnează adresa de email a utilizatorului.
     *
     * @return Adresa de email a utilizatorului.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setează adresa de email a utilizatorului.
     *
     * @param email Adresa de email a utilizatorului.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returnează parola utilizatorului.
     *
     * @return Parola utilizatorului.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setează parola utilizatorului.
     *
     * @param password Parola utilizatorului.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returnează rolul utilizatorului.
     *
     * @return Rolul utilizatorului.
     */
    public String getRole() {
        return role;
    }

    /**
     * Setează rolul utilizatorului.
     *
     * @param role Rolul utilizatorului.
     */
    public void setRole(String role) {
        this.role = role;
    }
}
