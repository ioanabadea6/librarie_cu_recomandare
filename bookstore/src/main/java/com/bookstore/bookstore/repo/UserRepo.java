package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfața care definește repository-ul pentru entitatea User.
 * Extinde JpaRepository pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) oferite de Spring Data JPA.
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    /**
     * Găsește un utilizator după username.
     *
     * @param username Utilizatorului căutat.
     * @return Utilizatorul găsit sau null dacă nu există niciun utilizator cu acest username.
     */
    User findByUsername(String username);

    /**
     * Finds a user by their unique identifier.
     *
     * @param id the unique identifier of the user
     * @return the user with the specified identifier, or null if not found
     */
    User findUserById(Integer id);

}
