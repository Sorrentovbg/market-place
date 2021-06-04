package ru.geekbrains.marketplace.msproduct.models.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msproduct.models.Product;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecifications {
    private static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("productPrice"), minPrice);
            }
        };
    }

    private static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("productPrice"), maxPrice);
            }
        };
    }

    public static Specification<Product> buildQuery(Integer priceAt, Integer priceTo) {
        Specification<Product> spec = Specification.where(null);
        if (priceAt != null) {
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(priceAt));
        }
        if (priceTo != null) {
            spec = spec.and(ProductSpecifications.priceLesserOrEqualsThan(priceTo));
        }
        return spec;
    }
}
