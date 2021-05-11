package ru.geekbrains.marketplace.mscore.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.geekbrains.marketplace.mscore.models.User;
import ru.geekbrains.marketplace.mscore.services.UserService;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByLogin(userName);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}
