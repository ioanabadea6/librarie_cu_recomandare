package com.bookstore.bookstore.entity;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * Reprezintă o entitate pentru o carte.
 */
@Entity
@Table(name = "book")
public class Book implements Serializable, Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_fk", nullable = false)
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    /**
     * Constructor pentru o carte cu ID.
     *
     * @param id          ID-ul cărții.
     * @param title       Titlul cărții.
     * @param author      Autorul cărții.
     * @param category    Categoria cărții.
     * @param description Descrierea cărții.
     * @param price       Prețul cărții.
     */
    public Book(Integer id, String title, String author, Category category, String description, Integer price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    /**
     * Constructor pentru o carte fără ID.
     *
     * @param title       Titlul cărții.
     * @param author      Autorul cărții.
     * @param category    Categoria cărții.
     * @param description Descrierea cărții.
     * @param price       Prețul cărții.
     */
    public Book(String title, String author, Category category, String description, Integer price) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    /**
     * Constructor implicit pentru Book.
     */
    public Book() {
    }

    /**
     * Returnează titlul cărții.
     *
     * @return Titlul cărții.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setează titlul cărții.
     *
     * @param title Titlul cărții.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returnează autorul cărții.
     *
     * @return Autorul cărții.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setează autorul cărții.
     *
     * @param author Autorul cărții.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returnează categoria cărții.
     *
     * @return Categoria cărții.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setează categoria cărții.
     *
     * @param category Categoria cărții.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returnează descrierea cărții.
     *
     * @return Descrierea cărții.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setează descrierea cărții.
     *
     * @param description Descrierea cărții.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returnează prețul cărții.
     *
     * @return Prețul cărții.
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Setează prețul cărții.
     *
     * @param price Prețul cărții.
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Returnează ID-ul cărții.
     *
     * @return ID-ul cărții.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setează ID-ul cărții.
     *
     * @param id ID-ul cărții.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Metodă de actualizare a cărții, implementată din interfața Observer.
     *
     * @param msg Mesajul de actualizare.
     */
    @Override
    public void update(String msg) {
        System.out.println(this.title + ":" + msg);
    }
}
