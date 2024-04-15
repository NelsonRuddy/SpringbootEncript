package IonixProjectTest.ionix.controller;

import IonixProjectTest.ionix.controller.request.CreateUserRequest;
import IonixProjectTest.ionix.controller.response.UserResponse;
import IonixProjectTest.ionix.services.UserService;
import IonixProjectTest.ionix.services.implementation.ApiService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTests {

    @Test
    public void testCreateUser() {

        UserService userService = mock(UserService.class);
        ApiService apiService = mock(ApiService.class);
        UserController userController = new UserController(userService, apiService);

        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("testuser");
        request.setName("John Doe");
        request.setEmail("john@example.com");
        request.setPhone("4561236547");

        UserResponse expectedResponse = new UserResponse();
        expectedResponse.setUsername("testuser");

        when(userService.createUser(request)).thenReturn(expectedResponse);

        UserResponse response = userController.createUser(request);


        assertEquals(expectedResponse, response);
    }

    @Test
    public void testListUsers() {

        UserService userService = mock(UserService.class);
        ApiService apiService = mock(ApiService.class);
        UserController userController = new UserController(userService, apiService);

        List<UserResponse> expectedResponse = new ArrayList<>();

        when(userService.getAllUsers()).thenReturn(expectedResponse);

        List<UserResponse> response = userController.listUsers();

        assertEquals(expectedResponse, response);
    }

}