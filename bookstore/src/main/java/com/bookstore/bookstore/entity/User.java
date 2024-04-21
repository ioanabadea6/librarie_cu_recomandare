package com.bookstore.bookstore.entity;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Reprezintă o entitate pentru un utilizator.
 */
@Entity
@Table(name = "user")
public class User implements Observer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public User() {
    }


    /**
     * Returnează ID-ul utilizatorului.
     *
     * @return ID-ul utilizatorului.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setează ID-ul utilizatorului.
     *
     * @param id ID-ul utilizatorului.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returnează utilizatorul.
     *
     * @return utilizatorul.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setează utilizatorul.
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

    /**
     * Metodă de actualizare, implementată din interfața Observer.
     *
     * @param msg Mesajul de actualizare.
     */
    @Override
    public void update(String msg) {
        System.out.println(this.name + ": " + msg);
    }

    /**
     * Verifică dacă doi utilizatori sunt egali.
     *
     * @param o Obiectul cu care să se compare.
     * @return true dacă utilizatorii sunt egali, altfel false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of
     * hash tables such as those provided by {@link java.util.HashMap}.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, contactNumber, email, password, role);
    }
}
