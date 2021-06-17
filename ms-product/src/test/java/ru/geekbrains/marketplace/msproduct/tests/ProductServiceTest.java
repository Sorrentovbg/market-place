package ru.geekbrains.marketplace.msproduct.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msproduct.services.ProductService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;


    @Test
    public void testGetAllProduct(){
        Page<ProductDto> allProduct = productService.getAllProduct(1,5);
        assertEquals(20,allProduct.getTotalElements());
        assertEquals("Телефон",allProduct.getContent().get(0).getProductName());
    }

    @Test
    public void testGetSortAscProduct(){
        List<ProductDto> allProduct = productService.getSortedProduct(1,"asc",5,0,1000000).toList();
        int price = allProduct.get(0).getProductPrice();
        for(int i = 0; i < allProduct.size()-1; i++){
            Assertions.assertTrue(price <= allProduct.get(i).getProductPrice());
            price = allProduct.get(i).getProductPrice();
        }
    }
    @Test
    public void testGetSortDescProduct(){
        List<ProductDto> allProduct = productService.getSortedProduct(1,"desc",5,0,1000000).toList();
        int price = allProduct.get(0).getProductPrice();
        for(int i = 0; i < allProduct.size()-1; i++){
            Assertions.assertTrue(price >= allProduct.get(i).getProductPrice());
            price = allProduct.get(i).getProductPrice();
        }
    }
    @Test
    public void findProductByCart(){
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        List<ProductDto> listDto = productService.findProductByIds(ids);
        assertEquals("Телефон",listDto.get(0).getProductName());
    }
}
