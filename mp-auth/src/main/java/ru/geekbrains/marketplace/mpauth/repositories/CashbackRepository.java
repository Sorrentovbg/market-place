package ru.geekbrains.marketplace.mpauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mpauth.models.CashBack;

@Repository
public interface CashbackRepository extends JpaRepository<CashBack, Long> {
}
