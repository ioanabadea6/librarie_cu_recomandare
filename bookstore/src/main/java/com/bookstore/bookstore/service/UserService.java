package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.model.UserPasswordData;
import com.bookstore.bookstore.model.UsernameData;

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
     * @param usernameData Informațiile despre utilizatorul care urmează să fie șters.
     */
    User deleteUser(UsernameData usernameData);

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
     * @param usernameData Informațiile despre utilizatorul utilizate pentru căutare.
     * @return Utilizatorul găsit sau null dacă nu a fost găsit niciun utilizator.
     */
    User findUser(UsernameData usernameData);

    /**
     * Returnează o listă cu toți utilizatorii din sistem.
     *
     * @return Lista de utilizatori din sistem.
     */
    List<User> findAll();

    /**
     * Updates the password of a user.
     *
     * @param userPasswordData The user data containing the updated password.
     * @return The updated user object.
     */
    User updatePassword(UserPasswordData userPasswordData);

    /**
     * Logs in a user using the provided user and password data.
     *
     * @param userPasswordData The user and password data used for authentication.
     * @return An Integer representing the login status.
     */
    Integer logIn(UserPasswordData userPasswordData);
}
