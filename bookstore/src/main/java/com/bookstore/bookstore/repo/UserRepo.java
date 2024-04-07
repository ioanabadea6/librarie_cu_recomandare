package com.bookstore.bookstore.repo;

import com.bookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfața care definește repository-ul pentru entitatea User.
 * Extinde JpaRepository pentru a beneficia de operațiile CRUD (Create, Read, Update, Delete) oferite de Spring Data JPA.
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    /**
     * Găsește un utilizator după numele său.
     *
     * @param name Numele utilizatorului căutat.
     * @return Utilizatorul găsit sau null dacă nu există niciun utilizator cu numele specificat.
     */
    User findByName(String name);
}
