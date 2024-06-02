package com.bookstore.bookstore.model;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.Order;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

/**
 * Clasa pentru reprezentarea datelor unei cărți.
 */
public class BookData {
    private String title;
    private String author;
    private Integer category_fk;
    private String description;
    private Integer price;
    private Integer stock;
    private MultipartFile image;

    /**
     * Returnează fișierul imagine asociat cărții.
     *
     * @return Fișierul imagine asociat cărții.
     */
    public MultipartFile getImage() {
        return image;
    }

    /**
     * Setează fișierul imagine asociat cărții.
     *
     * @param image Fișierul imagine asociat cărții.
     */
    public void setImageFile(MultipartFile image) {
        this.image = image;
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
     * Retrieves the stock quantity of this item.
     *
     * @return the stock quantity
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of this item.
     *
     * @param stock the stock quantity to be set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Retrieves the foreign key referencing the category of this item.
     *
     * @return the foreign key representing the category
     */
    public Integer getCategory_fk() {
        return category_fk;
    }

    /**
     * Sets the foreign key referencing the category of this item.
     *
     * @param category_fk the foreign key representing the category to be set
     */
    public void setCategory_fk(Integer category_fk) {
        this.category_fk = category_fk;
    }

}
