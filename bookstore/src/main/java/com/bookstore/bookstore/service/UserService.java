package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.repo.UserRepo;

public interface UserService {

    public User insertUser(UserData userData);

    public void deleteUser(UserData userData);

    public User updateUser(UserData userData);

    public User findUser(UserData userData);
}
