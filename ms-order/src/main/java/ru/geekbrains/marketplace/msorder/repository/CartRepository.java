package ru.geekbrains.marketplace.msorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.msorder.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart  findCartByUserId(Long userid);

}
