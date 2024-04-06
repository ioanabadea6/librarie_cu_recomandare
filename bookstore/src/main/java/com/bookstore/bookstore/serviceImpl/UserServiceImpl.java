package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.repo.UserRepo;
import com.bookstore.bookstore.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    /** The user service. */
    private UserRepo reposityUser;
    public UserServiceImpl(UserRepo reposityUser){
        this.reposityUser = reposityUser;
    }

    public User insertUser(UserData userData){
        User user = new User();
        user.setName(userData.getName());
        user.setContactNumber(userData.getContactNumber());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    public void deleteUser(UserData userData){
        User user = new User();
        user = findUser(userData);
        user.setContactNumber(userData.getContactNumber());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        reposityUser.delete(user);
    }

    public User updateUser(UserData userData){
        User user = findUser(userData);
        user.setName(userData.getName());
        user.setContactNumber(userData.getContactNumber());
        user.setEmail(userData.getEmail());
        user.setPassword(userData.getPassword());
        user.setRole(userData.getRole());
        return reposityUser.save(user);
    }

    public User findUser(UserData userData){
        User user = new User();
        user = reposityUser.findByName(userData.getName());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        return user;
    }
}
