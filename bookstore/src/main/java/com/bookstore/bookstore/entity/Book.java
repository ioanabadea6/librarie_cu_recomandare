package com.bookstore.bookstore.entity;

import com.bookstore.bookstore.ObserverDesignPattern.Observer;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Reprezintă o entitate pentru o carte.
 */
@Entity
@Table(name = "book")
public class Book implements Observer {
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

    @Column(name = "stock")
    private Integer stock;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderBook> orderBooks;

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
     * Retrieves the stock quantity of this book.
     *
     * @return the stock quantity
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of this book.
     *
     * @param stock the stock quantity to be set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Retrieves the list of order books associated with this object.
     *
     * @return the list of order books
     */
    public List<OrderBook> getOrderBooks() {
        return orderBooks;
    }

    /**
     * Sets the list of order books associated with this object.
     *
     * @param orderBooks the list of order books to be set
     */
    public void setOrderBooks(List<OrderBook> orderBooks) {
        this.orderBooks = orderBooks;
    }

    /**
     * Metodă de actualizare a cărții, implementată din interfața Observer.
     *
     * @param msg Mesajul de actualizare.
     */
    @Override
    public void update(String msg) {
        System.out.println(this.title + ": " + msg);
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
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(category, book.category) && Objects.equals(description, book.description) && Objects.equals(price, book.price) && Objects.equals(stock, book.stock) && Objects.equals(orderBooks, book.orderBooks);
    }

    /**
     * Returns a hash code value for the object. This method is supported for the benefit of
     * hash tables such as those provided by {@link java.util.HashMap}.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, category, description, price, stock, orderBooks);
    }
}
