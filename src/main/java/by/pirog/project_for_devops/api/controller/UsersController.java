package by.pirog.project_for_devops.api.controller;

import by.pirog.project_for_devops.api.dto.UserRequestDto;
import by.pirog.project_for_devops.core.model.UserEntity;
import by.pirog.project_for_devops.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
@Log4j2
public class UsersController {

    private final UserService userService;

    @GetMapping("/{id:\\d+}")
    public UserEntity getUserById(@PathVariable Long id) {
        log.info("Получен запрос на получение пользователя по id={}", id);
        var user = this.userService.getById(id);
        log.info("Пользователь успешно получен по id={}", id);
        return user;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getUsers(){
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserRequestDto user){
        log.info("Получен запрос на создание пользователя: userName={}, email={}", user.userName(), user.email());
        var result = this.userService.create(user);
        log.info("Пользователь успешно создан с id={}", result.getId());

        return ResponseEntity.created(URI.create("/api/v1/users/%d".formatted(result.getId())))
                .body(result);
    }
}
