package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;

import java.util.List;

/**
 * Interfața pentru serviciul de gestionare a utilizatorilor.
 */
public interface UserService {

    /**
     * Inserează un utilizator în sistem.
     *
     * @param userData Informațiile despre utilizatorul care urmează să fie inserat.
     * @return Utilizatorul inserat.
     */
    User insertUser(UserData userData);

    /**
     * Șterge un utilizator din sistem.
     *
     * @param userData Informațiile despre utilizatorul care urmează să fie șters.
     */
    void deleteUser(UserData userData);

    /**
     * Actualizează informațiile unui utilizator în sistem.
     *
     * @param userData Informațiile actualizate ale utilizatorului.
     * @return Utilizatorul actualizat.
     */
    User updateUser(UserData userData);

    /**
     * Găsește un utilizator în sistem pe baza informațiilor furnizate.
     *
     * @param userData Informațiile despre utilizatorul utilizate pentru căutare.
     * @return Utilizatorul găsit sau null dacă nu a fost găsit niciun utilizator.
     */
    User findUser(UserData userData);

    /**
     * Returnează o listă cu toți utilizatorii din sistem.
     *
     * @return Lista de utilizatori din sistem.
     */
    List<User> findAll();
}
