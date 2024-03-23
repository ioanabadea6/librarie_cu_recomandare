package com.bookstore.bookstore.entity.security;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.entity.security.Role;
import jakarta.persistence.*;

/**
 * Represents the association between a user and a role in the system.
 */
@Entity
@Table(name="user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;

    /**
     * Default constructor for UserRole.
     */
    public UserRole(){}

    /**
     * Constructs a UserRole with the specified user and role.
     * @param user the user associated with the role
     * @param role the role associated with the user
     */
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    /**
     * Gets the ID of the user role.
     * @return the user role ID
     */
    public Long getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets the ID of the user role.
     * @param userRoleId the user role ID to set
     */
    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets the user associated with the user role.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the user role.
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the role associated with the user role.
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role associated with the user role.
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
