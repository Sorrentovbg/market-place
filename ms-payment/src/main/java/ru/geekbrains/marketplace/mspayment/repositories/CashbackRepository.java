package ru.geekbrains.marketplace.mspayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mspayment.models.CashBack;

@Repository
public interface CashbackRepository extends JpaRepository<CashBack, Long> {

}
