package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.model.UserPasswordData;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class UserController {

    /** The user service. */
    private final UserService userService;


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
     * @param usernameData The RegistrationBody object containing user information.
     */
    @PostMapping("/find")
    public User findUser(@RequestBody UsernameData usernameData){
        return this.userService.findUser(usernameData);
    }

    /**
     * Handles DELETE requests to "/delete" endpoint.
     * Deletes a user based on the provided RegistrationBody.
     * @param usernameData The RegistrationBody object containing user information.
     */
    @DeleteMapping("/delete")
    public User deleteUser(@RequestBody UsernameData usernameData){
        return this.userService.deleteUser(usernameData);
    }

    /**
     * Handles PUT requests to "/update" endpoint.
     * Updates a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information to be updated.
     */
    @PutMapping("/update")
    public void updateUser(@RequestBody UserData userData) {
        this.userService.updateUser(userData);
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

    /**
     * Updates the password of a user.
     *
     * @param userdata The user data containing the updated password.
     */
    @PutMapping("/updatePass")
    public void updatePassword(@RequestBody UserPasswordData userdata){
        this.userService.updatePassword(userdata);
    }

    /**
     * Endpoint for logging in a user with provided user and password data.
     */
    @PostMapping("/login")
    public Integer login(@RequestBody UserPasswordData userPasswordData){
        return this.userService.logIn(userPasswordData);
    }

    /**
     * Endpoint for logging out a user.
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidate the session
        request.getSession().invalidate();
        return ResponseEntity.ok().build();
    }

}
