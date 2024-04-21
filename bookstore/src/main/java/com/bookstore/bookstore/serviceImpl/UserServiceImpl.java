package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    /** The user service. */
    private UserRepo reposityUser;

    /**
     * Constructs a new UserServiceImpl with the given UserRepo.
     *
     * @param reposityUser The repository for User entities.
     */
    public UserServiceImpl(UserRepo reposityUser){
        this.reposityUser = reposityUser;
    }

    /**
     * Inserts a new user into the system.
     *
     * @param userData the data of the user to be inserted
     * @return the inserted user
     */
    public User insertUser(UserData userData){
        User user = new User();
        user.setName(userData.getName());
        user.setUsername(userData.getUsername());
        user.setContactNumber(userData.getContactNumber());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    /**
     * Deletes a user from the system.
     *
     * @param userData the data of the user to be deleted
     */
    public User deleteUser(UserData userData){
        User user = new User();
        user = findUser(userData);
        user.setUsername(user.getUsername());
        user.setContactNumber(userData.getContactNumber());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        reposityUser.delete(user);
        return user;
    }

    /**
     * Updates an existing user in the system.
     *
     * @param userData the new data for the user
     * @return the updated user
     */
    public User updateUser(UserData userData){
        User user = findUser(userData);
        user.setUsername(user.getUsername());
        user.setName(userData.getName());
        user.setContactNumber(userData.getContactNumber());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    /**
     * Finds a user by username.
     *
     * @param userData the data of the user to be found
     * @return the found user
     */

    public User findUser(UserData userData){
        User user = new User();
        user = reposityUser.findByUsername(userData.getUsername());
        return user;
    }

    /**
     * Retrieves all users from the system.
     *
     * @return a list of all users
     */
    @Override
    public List<User> findAll() {
        return reposityUser.findAll();
    }
}

