package com.bookstore.bookstore.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Represents a book entity.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "publisher", nullable = false)
    private String publisher;
    @Column(name = "publicationDate", nullable = false)
    private String publicationDate;
    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "numberOfPages", nullable = false)
    private int numberOfPages;
    @Column(name = "format", nullable = false)
    private String format;
    @Column(name = "isbn", nullable = false)
    private int isbn;
    @Column(name = "shippingWeight", nullable = false)
    private double shippingWeight;
    @Column(name = "listPrice", nullable = false)
    private double listPrice;
    @Column(name = "ourPrice", nullable = false)
    private double ourPrice;
    @Column(name = "active", nullable = false)
    private boolean active=true;

    @Column(name = "description",columnDefinition="text")
    private String description;
    @Column(name = "inStockNumber", nullable = false)
    private int inStockNumber;

    @Transient
    private MultipartFile bookImage;


    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<BookToCartItem> bookToCartItemList;

    /**
     * Default constructor for Book.
     */
    public Book() {
    }

    /**
     * Constructs a Book with the specified details.
     * @param id the ID of the book
     * @param title the title of the book
     * @param author the author of the book
     * @param publisher the publisher of the book
     * @param publicationDate the publication date of the book
     * @param language the language of the book
     * @param category the category of the book
     * @param numberOfPages the number of pages of the book
     * @param format the format of the book
     * @param isbn the ISBN of the book
     * @param shippingWeight the shipping weight of the book
     * @param listPrice the list price of the book
     * @param ourPrice the our price of the book
     * @param active the active status of the book
     * @param description the description of the book
     * @param inStockNumber the in-stock number of the book
     * @param bookImage the image of the book
     * @param bookToCartItemList the list of cart items associated with the book
     */
    public Book(Long id, String title, String author, String publisher, String publicationDate, String language, String category, int numberOfPages, String format, int isbn, double shippingWeight, double listPrice, double ourPrice, boolean active, String description, int inStockNumber, MultipartFile bookImage, List<BookToCartItem> bookToCartItemList) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.language = language;
        this.category = category;
        this.numberOfPages = numberOfPages;
        this.format = format;
        this.isbn = isbn;
        this.shippingWeight = shippingWeight;
        this.listPrice = listPrice;
        this.ourPrice = ourPrice;
        this.active = active;
        this.description = description;
        this.inStockNumber = inStockNumber;
        this.bookImage = bookImage;
        this.bookToCartItemList = bookToCartItemList;
    }

    /**
     * Gets the ID of the book.
     * @return the ID of the book
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the title of the book.
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the publisher of the book.
     * @return the publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book.
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the publication date of the book.
     * @return the publication date of the book
     */
    public String getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the publication date of the book.
     * @param publicationDate the publication date to set
     */
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Gets the language of the book.
     * @return the language of the book
     */
    public String getLanguage() {
        return language;
    }


    /**
     * Sets the language of the book.
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the category of the book.
     * @return the category of the book
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the book.
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the number of pages of the book.
     * @return the number of pages of the book
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Sets the number of pages of the book.
     * @param numberOfPages the number of pages to set
     */
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Gets the format of the book.
     * @return the format of the book
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the book.
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Gets the ISBN of the book.
     * @return the ISBN of the book
     */
    public int getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     * @param isbn the ISBN to set
     */
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the shipping weight of the book.
     * @return the shipping weight of the book
     */
    public double getShippingWeight() {
        return shippingWeight;
    }

    /**
     * Sets the shipping weight of the book.
     * @param shippingWeight the shipping weight to set
     */
    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    /**
     * Gets the list price of the book.
     * @return the list price of the book
     */
    public double getListPrice() {
        return listPrice;
    }

    /**
     * Sets the list price of the book.
     * @param listPrice the list price to set
     */
    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * Gets the our price of the book.
     * @return the our price of the book
     */
    public double getOurPrice() {
        return ourPrice;
    }

    /**
     * Sets the our price of the book.
     * @param ourPrice the our price to set
     */
    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    /**
     * Checks if the book is active.
     * @return true if the book is active, false otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active status of the book.
     * @param active the active status to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets the description of the book.
     * @return the description of the book
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the book.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the in-stock number of the book.
     * @return the in-stock number of the book
     */
    public int getInStockNumber() {
        return inStockNumber;
    }

    /**
     * Sets the in-stock number of the book.
     * @param inStockNumber the in-stock number to set
     */
    public void setInStockNumber(int inStockNumber) {
        this.inStockNumber = inStockNumber;
    }

    /**
     * Gets the image of the book.
     * @return the image of the book
     */
    public MultipartFile getBookImage() {
        return bookImage;
    }

    /**
     * Sets the image of the book.
     * @param bookImage the image to set
     */
    public void setBookImage(MultipartFile bookImage) {
        this.bookImage = bookImage;
    }

    /**
     * Gets the list of cart items associated with the book.
     * @return the list of cart items associated with the book
     */
    public List<BookToCartItem> getBookToCartItemList() {
        return bookToCartItemList;
    }

    /**
     * Sets the list of cart items associated with the book.
     * @param bookToCartItemList the list of cart items to set
     */
    public void setBookToCartItemList(List<BookToCartItem> bookToCartItemList) {
        this.bookToCartItemList = bookToCartItemList;
    }
}
