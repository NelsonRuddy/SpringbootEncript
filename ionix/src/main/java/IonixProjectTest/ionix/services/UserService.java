package IonixProjectTest.ionix.services;

import IonixProjectTest.ionix.controller.request.CreateUserRequest;
import IonixProjectTest.ionix.controller.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(CreateUserRequest userRequest);
    List<UserResponse> getAllUsers();
    UserResponse getUserByEmail(String email);
    void deleteUserByEmail(String email);
}

