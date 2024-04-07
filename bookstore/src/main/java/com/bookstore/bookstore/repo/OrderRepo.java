package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfața care definește repository-ul pentru entitatea Order.
 * Extinde JpaRepository pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) oferite de Spring Data JPA.
 */
public interface OrderRepo extends JpaRepository<Order, Integer> {

    /**
     * Găsește o comandă după UUID-ul său.
     *
     * @param uuid UUID-ul comenzii căutate.
     * @return Comanda găsită sau null dacă nu există nicio comandă cu UUID-ul specificat.
     */
    Order findByUuid(String uuid);

    /**
     * Găsește o comandă după numele său.
     *
     * @param name Numele comenzii căutate.
     * @return Comanda găsită sau null dacă nu există nicio comandă cu numele specificat.
     */
    Order findByName(String name);
}
