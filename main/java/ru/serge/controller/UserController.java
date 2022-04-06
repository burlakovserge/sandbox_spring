package ru.serge.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.serge.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity getUsers() {
        log.info("Get request for users");
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/set_admin/{userId}")
    public ResponseEntity setAdmin(@PathVariable Long userId) {
        log.info("Get request for edit user role");
        userService.setAdmin(userId);
        log.info(String.format("User with %s id changed role to Admin", userId));
        return ResponseEntity.ok().build();
    }

}
