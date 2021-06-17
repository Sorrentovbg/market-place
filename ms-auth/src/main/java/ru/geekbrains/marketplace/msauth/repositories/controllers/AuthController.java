package ru.geekbrains.marketplace.msauth.repositories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.marketplace.msauth.repositories.entities.User;
import ru.geekbrains.marketplace.msauth.repositories.services.UserService;
import ru.geekbrains.marketplace.mscore.interfaces.ITokenService;
import ru.geekbrains.marketplace.mscore.models.UserInfo;
import ru.geekbrains.marketplace.mscore.models.dto.AuthRequestDto;
import ru.geekbrains.marketplace.mscore.models.dto.AuthResponseDto;
import ru.geekbrains.marketplace.mscore.models.dto.SignUpRequestDto;
import ru.geekbrains.marketplace.mscore.services.RedisService;

@RestController
@RequestMapping("/marketplace/v1/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    ITokenService tokenService;

    @Autowired
    RedisService redisService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setLogin(signUpRequest.getLogin());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());

        UserInfo userInfo = UserInfo.builder()
                .userId(user.getId())
                .userEmail(user.getLogin())
                .role(user.getRole().getName())
                .build();
        String token = tokenService.generateToken(userInfo);
        return new AuthResponseDto(token);
    }

    @GetMapping("/logout")
    public void logout(@RequestHeader String authorization){
        UserInfo userInfo = tokenService.parseToken(authorization);
        redisService.putInvalidToken(authorization);
    }

    @GetMapping("/check")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String check() {
        return "OK!";
    }

    @GetMapping("/getuser")
    public User getUser(String login){
        return userService.findByLogin(login);
    }
}
