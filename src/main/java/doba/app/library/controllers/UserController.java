package doba.app.library.controllers;

import doba.app.library.dto.user.CreateUserDto;
import doba.app.library.dto.user.UpdateUserDto;
import doba.app.library.entities.UserEntity;
import doba.app.library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/user")
    UserEntity createUser(@RequestBody CreateUserDto dto) {
        return userService.createUser(dto);
    }

    @GetMapping("/v1/user")
    List<UserEntity> getAllUserPaginated() {
        return userService.getAllUserPaginated();
    }

    @GetMapping("/v1/user/{id}")
    UserEntity getOneUserById(@PathVariable("id") UUID id) throws Exception {
        return userService.getOneUserById(id);
    }

    @PatchMapping("/v1/user/{id}")
    UserEntity updateOneUserById(@PathVariable("id") UUID id, @RequestBody UpdateUserDto dto) throws Exception {
        return userService.updateOneUserById(id, dto);
    }

    @DeleteMapping("/v1/user/{id}")
    UserEntity deleteOneUserById(@PathVariable("id") UUID id) throws Exception {
        return userService.deleteOneUserById(id);
    }
}
