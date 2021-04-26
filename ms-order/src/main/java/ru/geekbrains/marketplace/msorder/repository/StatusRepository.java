package ru.geekbrains.marketplace.msorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.msorder.models.Status;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
