package ru.geekbrains.marketplace.mpproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mpproduct.models.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
