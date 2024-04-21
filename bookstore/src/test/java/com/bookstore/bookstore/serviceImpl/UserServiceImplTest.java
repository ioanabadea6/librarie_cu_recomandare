package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
import com.bookstore.bookstore.model.UsernameData;
import com.bookstore.bookstore.repo.UserRepo;
import lombok.Builder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    @Mock
    private UserRepo userRepoMock;

    private UserServiceImpl userServiceImplTest;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the mocks using MockitoAnnotations and creates an instance of UserServiceImpl
     * with the mocked UserRepo.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userServiceImplTest = new UserServiceImpl(userRepoMock);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.UserServiceImpl#insertUser(UserData)} method.
     * Verifies that the user repository's save method is called with the expected user when inserting a user.
     */
    @Test
    public void insertUserTest(){
        UserData userData = new UserData();
        User userCreated = new User();
        userServiceImplTest.insertUser(userData);
        verify(userRepoMock).save(userCreated);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.UserServiceImpl#deleteUser(UsernameData)} method.
     * Verifies that the user repository's delete method is called with the expected user when deleting a user.
     */
    @Test
    public void deleteUserTest(){
        UsernameData usernameData = new UsernameData();
        User user = userServiceImplTest.deleteUser(usernameData);
        verify(userRepoMock).delete(user);
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.UserServiceImpl#updateUser(UserData)} method.
     * Verifies that the user repository's findByUsername method is called with the expected username when updating a user.
     */
    @Test
    public void updateUserTest(){
        UserData userData = new UserData();
        when(userServiceImplTest.findUser(new UsernameData())).thenReturn(new User());
        User user = userServiceImplTest.updateUser(userData);
        verify(userRepoMock).findByUsername(userData.getUsername());
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.UserServiceImpl#findUser(UsernameData)} method.
     * Verifies that the user repository's findByUsername method is called with the expected username when finding a user.
     */
    @Test
    public void findUserTest(){
        UsernameData usernameData = new UsernameData();
        userServiceImplTest.findUser(usernameData);
        verify(userRepoMock).findByUsername(usernameData.getUsername());
    }

    /**
     * Tests the behavior of the {@link com.bookstore.bookstore.serviceImpl.UserServiceImpl#findAll()} method.
     * Verifies that the user repository's findAll method is called when retrieving all users.
     */
    @Test
    public void findAll(){
        userServiceImplTest.findAll();
        verify(userRepoMock).findAll();
    }
}
