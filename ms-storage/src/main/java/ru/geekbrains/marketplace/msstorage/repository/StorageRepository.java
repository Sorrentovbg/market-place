package ru.geekbrains.marketplace.msstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.msstorage.model.Storage;


@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

}
