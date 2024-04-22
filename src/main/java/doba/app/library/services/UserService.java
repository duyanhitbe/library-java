package doba.app.library.services;

import doba.app.library.dto.user.CreateUserDto;
import doba.app.library.dto.user.UpdateUserDto;
import doba.app.library.entities.UserEntity;
import doba.app.library.enums.UserRole;
import doba.app.library.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //Get list of categories with pagination
    public List<UserEntity> getAllUserPaginated() {
        return userRepository.findAll();
    }

    //Get one user by id
    public UserEntity getOneUserById(UUID id) throws Exception {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new Exception("User not found"));
    }

    //Create a new user
    public UserEntity createUser(CreateUserDto dto) {
        UserEntity user = UserEntity
                .builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();
        return userRepository.save(user);
    }

    //Update one user by id
    public UserEntity updateOneUserById(UUID id, UpdateUserDto dto) throws Exception {
        UserEntity user = this.getOneUserById(id);

        String username = dto.getUsername();
        UserRole role = dto.getRole();

        String updatedUsername = username != null ? username : user.getUsername();
        UserRole updatedRole = role != null ? role : user.getRole();

        user.setUsername(updatedUsername);
        user.setRole(updatedRole);

        return userRepository.save(user);
    }

    //Delete one user by id
    public UserEntity deleteOneUserById(UUID id) throws Exception {
        UserEntity user = this.getOneUserById(id);
        userRepository.delete(user);
        return user;
    }
}
