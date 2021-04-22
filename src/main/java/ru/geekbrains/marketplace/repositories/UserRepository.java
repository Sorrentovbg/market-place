package ru.geekbrains.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
