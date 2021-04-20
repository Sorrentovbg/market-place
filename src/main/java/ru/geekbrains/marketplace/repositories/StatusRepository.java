package ru.geekbrains.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
