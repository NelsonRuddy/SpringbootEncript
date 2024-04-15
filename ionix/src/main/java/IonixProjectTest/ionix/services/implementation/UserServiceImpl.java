package IonixProjectTest.ionix.services.implementation;

import IonixProjectTest.ionix.controller.request.CreateUserRequest;
import IonixProjectTest.ionix.controller.response.UserResponse;
import IonixProjectTest.ionix.repository.UserRepository;
import IonixProjectTest.ionix.repository.domain.Users;
import IonixProjectTest.ionix.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse createUser(CreateUserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        Users newUser = modelMapper.map(userRequest, Users.class);
        Users savedUser = userRepository.save(newUser);

        return modelMapper.map(savedUser, UserResponse.class);
    }


    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        Users user = userRepository.findAllByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el correo electrónico: " + email));

        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public void deleteUserByEmail(String email) {
        Users userToDelete = userRepository.findAllByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el correo electrónico: " + email));

        userRepository.delete(userToDelete);
    }
}
