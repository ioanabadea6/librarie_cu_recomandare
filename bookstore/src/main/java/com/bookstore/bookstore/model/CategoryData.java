package com.bookstore.bookstore.model;

/**
 * Clasa pentru reprezentarea datelor unei categorii.
 */
public class CategoryData {
    private Integer id;
    private String name;

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
}
