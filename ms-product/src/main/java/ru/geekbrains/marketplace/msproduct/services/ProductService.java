package ru.geekbrains.marketplace.msproduct.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msproduct.models.Product;
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
        return productRepository.findAll(PageRequest.of(page -1, size)).map(new Function<Product, ProductDto>() {
            @Override
            public ProductDto apply(Product product) {
                return toDto(product);
            }
        });
    }

    public void addProduct(Product product){
        Product productTest = new Product(product.getProductName(),product.getProduct_price(), product.getUrl_picture());
        productRepository.save(productTest);
    }

    public Optional<Product> getProductById(Long id){
        return  productRepository.findById(id);

    }

    public List<ProductDto> findProductByIds(List<Long> ids) {
        List<Product> productIds = productRepository.findAllById(ids);
        List<ProductDto> productDtosIds = new ArrayList<>();
        for(int i = 0; i <= productIds.size()-1; i++){
            ProductDto dtos = toDto(productIds.get(i));
            productDtosIds.add(dtos);
        }

//        List<ProductDto> productIds = productRepository.findAllById(ids).stream().map(new Function<Product, ProductDto>() {
//            @Override
//            public ProductDto apply(Product product){
//                return ProductService.this.toDto(product);
//            }
//        }).collect(Collectors.toList());

        return productDtosIds;
    }

    public ProductDto toDto (Product product){
        System.out.println("Method toDto(productName = " + product.getProductName() + " )");
        System.out.println("Method toDto(productName = " + product.getProduct() + " )");
        System.out.println("Method toDto(productName = " + product.getProduct_price() + " )");
        return modelMapper.map(product, ProductDto.class);
    }
//    public Page<Product> getAllProductNot(int page, int size){
//        int checkedPage = checkPageNumber(page);
//        return productRepository.findProductByDeletedAtIsNull(PageRequest.of(checkedPage,size));
//    }
//
//    private int checkPageNumber(int page) {
//        int pageNumber = page;
//        if(page < 0){
//            pageNumber = 0;
//        }
//        if(page >= productRepository.findProductByDeletedAtIsNull(PageRequest.of(0,5)).getTotalPages()){
//            pageNumber = productRepository.findProductByDeletedAtIsNull(PageRequest.of(0,5)).getTotalPages() - 1;
//        }
//        return pageNumber;
//    }
}
