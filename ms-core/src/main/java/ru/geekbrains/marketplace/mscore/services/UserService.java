package ru.geekbrains.marketplace.mscore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.mscore.models.User;
import ru.geekbrains.marketplace.mscore.repositories.RoleRepository;
import ru.geekbrains.marketplace.mscore.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

}
