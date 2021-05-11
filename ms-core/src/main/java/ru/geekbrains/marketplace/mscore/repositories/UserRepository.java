package ru.geekbrains.marketplace.mscore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.marketplace.mscore.models.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);
}
