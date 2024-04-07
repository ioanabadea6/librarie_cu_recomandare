package com.bookstore.bookstore.api.controller.auth;


import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.service.UserService;
import com.bookstore.bookstore.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    /** The user service. */
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Post Mapping to handle registering users.
     * @param userData The registration information.
     * @return Response to front end.
     */
    @PostMapping("/insert")
    public UserData registerUser(@RequestBody UserData userData) {
        this.userService.insertUser(userData);
        return userData;
    }

    /**
     * Handles GET requests to "/find" endpoint.
     * Finds a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information.
     */
    @GetMapping("/find")
    public UserData findUser(@RequestBody UserData userData){
        this.userService.findUser(userData);
        return userData;
    }

    /**
     * Handles DELETE requests to "/delete" endpoint.
     * Deletes a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information.
     */
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserData userData){
        this.userService.deleteUser(userData);
    }

    /**
     * Handles PUT requests to "/update" endpoint.
     * Updates a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information to be updated.
     */
    @PutMapping("/update")
    public UserData updateUser(@RequestBody UserData userData) {
        this.userService.updateUser(userData);
        return userData;
    }

    /**
     * Endpoint for retrieving all users.
     *
     * @return A list of User objects representing all users in the system.
     */
    @GetMapping("/findAll")
    public List<User> findAllUser(){
        return this.userService.findAll();
    }

}
