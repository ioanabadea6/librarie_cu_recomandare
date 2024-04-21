package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Interfața care definește repository-ul pentru entitatea Order.
 * Extinde JpaRepository pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) oferite de Spring Data JPA.
 */
public interface OrderRepo extends JpaRepository<Order, Long> {

    /**
     * Găsește o comandă după numele său.
     *
     * @param name Numele comenzii căutate.
     * @return Comanda găsită sau null dacă nu există nicio comandă cu numele specificat.
     */
    Order findByName(String name);
    /**
     * Găsește o comandă după id-ul său.
     *
     * @param id Id-ul comenzii căutate.
     * @return Comanda găsită sau null dacă nu există nicio comandă cu id-ul specificat.
     */
    Order findById(Integer id);

}
