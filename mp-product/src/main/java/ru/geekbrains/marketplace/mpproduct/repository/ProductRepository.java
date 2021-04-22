package ru.geekbrains.marketplace.mpproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mpproduct.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
