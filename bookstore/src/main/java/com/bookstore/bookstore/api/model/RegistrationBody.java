package com.bookstore.bookstore.api.model;

import com.bookstore.bookstore.entity.Role2;


/**
 * The information required to register a user.
 */
public class RegistrationBody {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private String email;
    private String phone;
    private boolean enabled=true;

    private Role2 userRole;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role2 getUserRole() {
        return userRole;
    }

    public void setUserRole(Role2 userRole) {
        this.userRole = userRole;
    }
}
