package com.bookstore.bookstore.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Reprezintă o entitate pentru o categorie de cărți.
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

    /**
     * Constructor pentru o categorie cu ID.
     *
     * @param id   ID-ul categoriei.
     * @param name Numele categoriei.
     */
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Constructor implicit pentru Category.
     */
    public Category() {
    }

    /**
     * Constructor pentru o categorie fără ID.
     *
     * @param name Numele categoriei.
     */
    public Category(String name) {
        this.name = name;
    }

    /**
     * Returnează ID-ul categoriei.
     *
     * @return ID-ul categoriei.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setează ID-ul categoriei.
     *
     * @param id ID-ul categoriei.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returnează numele categoriei.
     *
     * @return Numele categoriei.
     */
    public String getName() {
        return name;
    }

    /**
     * Setează numele categoriei.
     *
     * @param name Numele categoriei.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returnează lista de cărți din această categorie.
     *
     * @return Lista de cărți din această categorie.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Setează lista de cărți din această categorie.
     *
     * @param books Lista de cărți din această categorie.
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
