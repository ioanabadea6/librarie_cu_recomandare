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
    public User registerUser(RegistrationBody registrationBody){
        User user = new User();
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());
        user.setPhone(registrationBody.getPhone());
        user.setEnabled(registrationBody.isEnabled());
        user.setUserRole(registrationBody.getUserRole());
        return userDAO.save(user);
    }

    public void deleteUser(RegistrationBody registrationBody){
        User user = new User();
        user = findUser(registrationBody);
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());
        user.setPhone(registrationBody.getPhone());
        user.setEnabled(registrationBody.isEnabled());
        user.setUserRole(registrationBody.getUserRole());
        userDAO.delete(user);
    }

    public User updateUser(RegistrationBody registrationBody){
        User user = findUser(registrationBody);
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());
        user.setPhone(registrationBody.getPhone());
        user.setEnabled(registrationBody.isEnabled());
        user.setUserRole(registrationBody.getUserRole());
        return userDAO.save(user);
    }

    public User findUser(RegistrationBody registrationBody){
        User user = new User();
        user.setUsername(registrationBody.getUsername());
        user.setPassword(registrationBody.getPassword());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setEmail(registrationBody.getEmail());
        user.setPhone(registrationBody.getPhone());
        user.setEnabled(registrationBody.isEnabled());
        user.setUserRole(registrationBody.getUserRole());
        return user;
    }

}
