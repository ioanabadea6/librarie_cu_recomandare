package com.bookstore.bookstore.entity;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Reprezintă o entitate pentru o categorie de cărți.
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

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

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the {@code o} argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name) && Objects.equals(books, category.books);
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of
     * hash tables such as those provided by {@link java.util.HashMap}.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }
}
