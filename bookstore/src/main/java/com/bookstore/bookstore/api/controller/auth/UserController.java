package com.bookstore.bookstore.api.controller.auth;


import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.service.UserService;
import com.bookstore.bookstore.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    /** The user service. */
    private UserServiceImpl userServiceImpl;


    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * Post Mapping to handle registering users.
     * @param userData The registration information.
     * @return Response to front end.
     */
    @PostMapping("/insert")
    public UserData registerUser(@RequestBody UserData userData) {
        this.userServiceImpl.insertUser(userData);
        return userData;
    }

    /**
     * Handles GET requests to "/find" endpoint.
     * Finds a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information.
     */
    @GetMapping("/find")
    public UserData findUser(@RequestBody UserData userData){
        this.userServiceImpl.findUser(userData);
        return userData;
    }

    /**
     * Handles DELETE requests to "/delete" endpoint.
     * Deletes a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information.
     */
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody UserData userData){
        this.userServiceImpl.deleteUser(userData);
    }

    /**
     * Handles PUT requests to "/update" endpoint.
     * Updates a user based on the provided RegistrationBody.
     * @param userData The RegistrationBody object containing user information to be updated.
     */
    @PutMapping("/update")
    public UserData updateUser(@RequestBody UserData userData) {
        this.userServiceImpl.updateUser(userData);
        return userData;
    }
}
