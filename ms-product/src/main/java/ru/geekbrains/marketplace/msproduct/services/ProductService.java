package ru.geekbrains.marketplace.msproduct.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.msproduct.models.Product;
import ru.geekbrains.marketplace.msproduct.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){
        System.out.println("Method getAllProduct");
        List<Product> listp = productRepository.findAll();
        for(Product p: listp){
            System.out.println(p.getProductName() + "--" + p.getProduct_price() + "--" + p.getUrl_picture());
        }
//        int checkedPage = checkPageNumber(page);
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        Product productTest = new Product(product.getProductName(),product.getProduct_price(), product.getUrl_picture());
        productRepository.save(productTest);
    }

    public Optional<Product> getProductById(Long id){
        return  productRepository.findById(id);

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
