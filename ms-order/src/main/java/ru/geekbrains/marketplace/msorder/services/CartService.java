package ru.geekbrains.marketplace.msorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.eurekafeignclient.product.ProductClientFeign;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msorder.models.Cart;
import ru.geekbrains.marketplace.msorder.models.CartItem;
import ru.geekbrains.marketplace.msorder.repository.CartRepository;


import java.util.List;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductClientFeign productClientFeign;


    public void addToCart(Long userId, ProductDto productDto, int count) {
        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart != null){
            List<CartItem> cartItems = cart.getCartItems();
            for (int i = 0; i < cartItems.size(); i++){
                if(cartItems.get(i).getProductId().equals(productDto.getProduct())){
                    if(count == 1L){
                        int productCount = cartItems.get(i).getCountProduct() + 1;
                        cartItems.get(i).setCountProduct(productCount);
                        cartItems.get(i).setTotalPriceProduct(productCount * cartItems.get(i).getPricePerProduct());
                    }else{
                        cartItems.get(i).setCountProduct(count);
                        cartItems.get(i).setTotalPriceProduct(count * cartItems.get(i).getPricePerProduct());
                    }
                }else {
                    cartItems.add(new CartItem(productDto.getProduct(),productDto.getProduct_price(),count,productDto.getProduct_price()));
                }
            }

            cart.setTotalPrice(getPrice(cartItems));
            cart.setCartItems(cartItems);
            cartRepository.save(cart);
        }else {
            Cart createCart = new Cart();
            createCart.setUserId(userId);
            createCart.getCartItems().add(new CartItem(productDto.getProduct(),productDto.getProduct_price(),count,productDto.getProduct_price()));
            createCart.setTotalPrice(getPrice(createCart.getCartItems()));
            cartRepository.save(createCart);
        }
    }

    private int getPrice(List<CartItem> cartItems) {
        int totalPrice = 0;
        for(CartItem item: cartItems){
            totalPrice +=  item.getTotalPriceProduct();
        }
        return totalPrice;
    }

    public Cart getCart(Long userId) {
        Cart cart = cartRepository.findCartByUserIdAndOrderCreatedIsNull(userId);
        return cart;
    }
}
