package com.bookstore.bookstore.api.controller.auth;

import com.bookstore.bookstore.api.model.RegistrationBody;
import com.bookstore.bookstore.exception.UserAlreadyExistsException;
import com.bookstore.bookstore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    /** The user service. */
    private UserService userService;

    /**
     * Spring injected constructor.
     * @param userService
     */
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Post Mapping to handle registering users.
     * @param registrationBody The registration information.
     * @return Response to front end.
     */
    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationBody registrationBody) {
        this.userService.registerUser(registrationBody);
    }

    @GetMapping("/find")
    public void findUser(@RequestBody RegistrationBody registrationBody){
        this.userService.findUser(registrationBody);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody RegistrationBody registrationBody){
        this.userService.deleteUser(registrationBody);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody RegistrationBody registrationBody) {
        this.userService.updateUser(registrationBody);
    }
}
