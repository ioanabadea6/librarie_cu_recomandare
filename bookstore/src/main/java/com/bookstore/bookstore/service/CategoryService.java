package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.model.CategoryData;

import java.util.List;

/**
 * Interfața pentru serviciul de gestionare a categoriilor.
 */
public interface CategoryService {

    /**
     * Inserează o categorie în sistem.
     *
     * @param categoryData Informațiile despre categoria care urmează să fie inserată.
     * @return Categoria inserată.
     */
    Category insertCategory(CategoryData categoryData);

    /**
     * Șterge o categorie din sistem.
     *
     * @param categoryData Informațiile despre categoria care urmează să fie ștearsă.
     */
    Category deleteCategory(CategoryData categoryData);

    /**
     * Actualizează informațiile unei categorii în sistem.
     *
     * @param categoryData Informațiile actualizate ale categoriei.
     * @return Categoria actualizată.
     */
    Category updateCategory(CategoryData categoryData);

    /**
     * Găsește o categorie în sistem pe baza informațiilor furnizate.
     *
     * @param categoryData Informațiile despre categorie utilizate pentru căutare.
     * @return Categoria găsită sau null dacă nu a fost găsită nicio categorie.
     */
    Category findCategory(CategoryData categoryData);

    /**
     * Caută o categorie în baza de date după numele său.
     *
     * @param categoryData Obiectul care conține datele categoriei pentru căutare.
     * @return Categorie găsită sau {@code null} dacă nu există o categorie cu numele respectiv.
     */
    Category findCategoryByName(CategoryData categoryData);

    /**
     * Gaseste toate categoriile
     * @return
     */
    List<Category> findAll();
}
