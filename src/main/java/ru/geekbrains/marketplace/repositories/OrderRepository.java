package ru.geekbrains.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
