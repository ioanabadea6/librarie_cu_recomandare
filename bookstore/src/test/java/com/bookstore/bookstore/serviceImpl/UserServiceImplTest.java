package com.bookstore.bookstore.serviceImpl;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.model.UserData;
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

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userServiceImplTest = new UserServiceImpl(userRepoMock);
    }

    @Test
    public void insertUserTest(){
        UserData userData = new UserData();
//        userData.setName("ana");
//        userData.setContactNumber("0123456789");
//        userData.setEmail("ana@gmail.com");
//        userData.setPassword("ana2");
//        userData.setRole("user");
//
        User userCreated = new User();
//        userCreated.setName(userData.getName());
//        userCreated.setContactNumber(userData.getContactNumber());
//        userCreated.setEmail(userData.getEmail());
//        userCreated.setPassword(userData.getPassword());
//        userCreated.setRole(userData.getRole());
//
//        when(userRepoMock.save(userCreated)).thenReturn(userCreated);
//        User user = userServiceImplTest.insertUser(userData);
//        assertEquals(user, userCreated);
        userServiceImplTest.insertUser(userData);
        verify(userRepoMock).save(userCreated);
    }

    @Test
    public void deleteUserTest(){
        UserData userData = new UserData();
        User user = userServiceImplTest.deleteUser(userData);
        verify(userRepoMock).delete(user);
    }

    @Test
    public void updateUserTest(){
        UserData userData = new UserData();
        when(userServiceImplTest.findUser(new UserData())).thenReturn(new User());
        User user = userServiceImplTest.updateUser(userData);
        verify(userRepoMock).save(user);
    }

    @Test
    public void findUserTest(){
        UserData userData = new UserData();
        userServiceImplTest.findUser(userData);
        verify(userRepoMock).findByUsername(userData.getUsername());
    }

    @Test
    public void findAll(){
        userServiceImplTest.findAll();
        verify(userRepoMock).findAll();
    }
}
