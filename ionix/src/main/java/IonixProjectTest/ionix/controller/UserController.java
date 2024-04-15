package IonixProjectTest.ionix.controller;

import IonixProjectTest.ionix.controller.request.CreateUserRequest;
import IonixProjectTest.ionix.controller.request.SearchRequest;
import IonixProjectTest.ionix.controller.response.SearchResponse;
import IonixProjectTest.ionix.controller.response.UserResponse;
import IonixProjectTest.ionix.services.UserService;
import IonixProjectTest.ionix.services.implementation.ApiService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ApiService apiService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> listUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserByEmail(@PathVariable @NotBlank String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/search")
    public SearchResponse search(@RequestBody SearchRequest request) {
        return apiService.search(request.getParam());
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable @NotBlank String email) {
        userService.deleteUserByEmail(email);
    }
}
