package by.pirog.project_for_devops.api.controller;

import by.pirog.project_for_devops.core.model.UserEntity;
import by.pirog.project_for_devops.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;

    @GetMapping("/{id:\\d+}")
    public UserEntity getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(UserEntity user){
        var result = this.userService.create(user);

        return ResponseEntity.created(URI.create("/api/v1/users/%d".formatted(result.getId())))
                .body(result);
    }
}
