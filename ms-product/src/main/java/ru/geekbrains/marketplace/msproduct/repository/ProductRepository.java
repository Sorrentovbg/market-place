package ru.geekbrains.marketplace.msproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.msproduct.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    Page<Product> findProductByDeletedAtIsNull(Pageable var1);

}
