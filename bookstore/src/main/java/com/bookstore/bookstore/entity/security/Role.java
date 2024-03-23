package com.bookstore.bookstore.entity.security;

import jakarta.persistence.*;

import java.util.*;

/**
 * Represents a role in the system.
 */
@Entity
public class Role {
    @Id
    private int roleId;
    private String name;

    @OneToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    /**
     * Gets the ID of the role.
     * @return the role ID
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the ID of the role.
     * @param roleId the role ID to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the name of the role.
     * @return the role name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     * @param name the role name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the user roles associated with this role.
     * @return the user roles
     */
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets the user roles associated with this role.
     * @param userRoles the user roles to set
     */
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
