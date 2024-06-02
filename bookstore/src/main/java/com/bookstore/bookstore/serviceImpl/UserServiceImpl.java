package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.model.UserPasswordData;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
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
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    /**
     * Deletes a user from the system.
     *
     * @param usernameData the data of the user to be deleted
     */
    public User deleteUser(UsernameData usernameData){
        User user = new User();
        user = reposityUser.findByUsername(usernameData.getUsername());
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
        User user = reposityUser.findByUsername(userData.getUsername());
        if(user != null){
            user.setUsername(user.getUsername());
            user.setName(userData.getName());
            user.setEmail(userData.getEmail());
            user.setPassword(userData.getPassword());
            user.setRole(userData.getRole());
        }
        return reposityUser.save(user);
    }

    /**
     * Finds a user by username.
     *
     * @param usernameData the data of the user to be found
     * @return the found user
     */

    public User findUser(UsernameData usernameData){
        User user = new User();
        user = reposityUser.findByUsername(usernameData.getUsername());
        if(user == null){
            return null;
        }
        else {
            return user;
        }
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

    /**
     * Updates the password of a user.
     *
     * @param userPasswordData The user data containing the updated password.
     * @return The updated user object, or null if the user with the given username is not found.
     */
    @Override
    public User updatePassword(UserPasswordData userPasswordData) {
        User user = reposityUser.findByUsername(userPasswordData.getUsername());
        if(user != null){
            user.setPassword(userPasswordData.getPassword());
        }
        reposityUser.save(user);
        return user;
    }

    /**
     * Logs in a user using the provided user and password data.
     *
     * @param userPasswordData The user and password data used for authentication.
     * @return An Integer representing the login status.
     */
    @Override
    public Integer logIn(UserPasswordData userPasswordData) {
        User user = reposityUser.findByUsername(userPasswordData.getUsername());
        if(user == null){
            return null;
        }
        else{
            if(user.getPassword().equals(userPasswordData.getPassword())){
                if(user.getRole().equals("admin")){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
        return null;
    }


}

