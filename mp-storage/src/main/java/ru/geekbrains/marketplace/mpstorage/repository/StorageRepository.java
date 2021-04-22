package ru.geekbrains.marketplace.mpstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mpstorage.model.Storage;


@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

}
