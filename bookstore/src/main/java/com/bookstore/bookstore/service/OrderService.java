package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Order;
import com.bookstore.bookstore.model.OrderData;

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
    void deleteOrder(OrderData orderData);

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
}
