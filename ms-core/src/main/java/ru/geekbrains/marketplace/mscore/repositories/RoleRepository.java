package ru.geekbrains.marketplace.mscore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.marketplace.mscore.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
