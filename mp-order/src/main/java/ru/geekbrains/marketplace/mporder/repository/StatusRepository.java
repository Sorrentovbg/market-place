package ru.geekbrains.marketplace.mporder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mporder.models.Status;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}
