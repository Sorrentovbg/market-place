package ru.geekbrains.marketplace.msproduct.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msproduct.models.Product;
import ru.geekbrains.marketplace.msproduct.models.specification.ProductSpecifications;
import ru.geekbrains.marketplace.msproduct.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public Page<ProductDto> getAllProduct(int page, int size){
        return productRepository.findAll(PageRequest.of(page -1, size)).map(this::toDto);
    }

    public Page<ProductDto> getSortedProduct(Integer page, String sort, int size, Integer priceAt, Integer priceTo) {
        Page<ProductDto> product;
        if (sort != null){
            if (sort.equals("asc")){
                product =  productRepository.findAll(ProductSpecifications.buildQuery(priceAt,priceTo),
                        PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "productPrice"))).map(this::toDto);
                return product;
            }else if(sort.equals("desc")){
                product =  productRepository.findAll(ProductSpecifications.buildQuery(priceAt,priceTo),
                        PageRequest.of(page - 1, size, Sort.by(Sort.Direction.DESC, "productPrice"))).map(this::toDto);
                return product;
            }
        }
        product = productRepository.findAll(ProductSpecifications.buildQuery(priceAt,priceTo),
                PageRequest.of(page -1, size)).map(this::toDto);

        return product;
    }

    public void addProduct(Product product){
        Product productTest = new Product(product.getProductName(),product.getProductPrice(), product.getUrlPicture());
        productRepository.save(productTest);
    }

    public Optional<ProductDto> getProductToCart(Long id){
        return  productRepository.findById(id).map(this::toDto);

    }

    public List<ProductDto> findProductByIds(List<Long> ids) {
        List<Product> productIds = productRepository.findAllById(ids);
        List<ProductDto> productDtosIds = new ArrayList<>();
        for(int i = 0; i <= productIds.size()-1; i++){
            ProductDto dtos = toDto(productIds.get(i));
            productDtosIds.add(dtos);
        }
        return productDtosIds;
    }

    public ProductDto toDto (Product product){
        return modelMapper.map(product, ProductDto.class);
    }
}
