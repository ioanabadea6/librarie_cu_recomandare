package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.model.OrderData;
import com.bookstore.bookstore.model.UsernameData;

import java.util.List;

/**
 * Interfața pentru serviciul de gestionare a comenzilor.
 */
public interface OrderService {

    /**
     * Inserează o comandă în sistem.
     *
     * @param orderData Informațiile despre comanda care urmează să fie inserată.
     * @return Comanda inserată.
     */
    Order insertOrder(OrderData orderData);

    /**
     * Șterge o comandă din sistem.
     *
     * @param orderData Informațiile despre comanda care urmează să fie ștearsă.
     */
    Order deleteOrder(OrderData orderData);

    /**
     * Actualizează informațiile unei comenzi în sistem.
     *
     * @param orderData Informațiile actualizate ale comenzii.
     * @return Comanda actualizată.
     */
    Order updateOrder(OrderData orderData);

    /**
     * Găsește o comandă în sistem pe baza informațiilor furnizate.
     *
     * @param orderData Informațiile despre comanda utilizate pentru căutare.
     * @return Comanda găsită sau null dacă nu a fost găsită nicio comandă.
     */
    Order findOrder(OrderData orderData);

    /**
     * Gaseste o comanda in functie de id.
     * @param id
     * @return
     */
    Order findOrderById(Integer id);

    /**
     * gaseste toate comenzile
     * @return
     */
    List<Order> findAll();

    /**
     * Gaseste comenzile unui user
     * @param usernameData
     * @return
     */
    List<Order> findByUsername(UsernameData usernameData);
}
