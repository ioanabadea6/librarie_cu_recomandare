package com.bookstore.bookstore.model;

import com.bookstore.bookstore.entity.Category;

/**
 * Clasa pentru reprezentarea datelor unei cărți.
 */
public class BookData {
    private String title;
    private String author;
    private Category category;
    private String description;
    private Integer price;

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
}
