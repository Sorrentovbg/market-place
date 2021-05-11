package ru.geekbrains.marketplace.msauth.repositories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.msauth.repositories.entities.User;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);
}
