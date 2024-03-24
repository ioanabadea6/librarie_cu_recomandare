package com.bookstore.bookstore.service;

import com.bookstore.bookstore.api.model.RegistrationBody;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.entity.dao.UserDAO;
import com.bookstore.bookstore.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

/**
 * Service for handling user actions.
 */
@Service
public class UserService {

    /** The UserDAO. */
    private UserDAO userDAO;

    /**
     * Constructor injected by spring.
     * @param userDAO
     */
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Attempts to register a user given the information provided.
     * @param registrationBody The registration information.
     * @return The user that has been written to the database.
     * @throws UserAlreadyExistsException Thrown if there is already a user with the given information.
     */
    public UserDAO registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());

        user.setPassword(registrationBody.getPassword());
        return userDAO.save(user);
    }

}
