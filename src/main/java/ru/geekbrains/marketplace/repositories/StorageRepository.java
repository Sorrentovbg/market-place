package ru.geekbrains.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.models.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
