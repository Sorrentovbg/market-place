package ru.geekbrains.marketplace.msorder.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketplace.eurekafeignclient.product.ProductClientFeign;
import ru.geekbrains.marketplace.mscore.models.dto.CartDto;
import ru.geekbrains.marketplace.mscore.models.dto.CartItemDto;
import ru.geekbrains.marketplace.mscore.models.dto.ProductDto;
import ru.geekbrains.marketplace.msorder.models.Cart;
import ru.geekbrains.marketplace.msorder.models.CartItem;
import ru.geekbrains.marketplace.msorder.repository.CartRepository;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductClientFeign productClientFeign;

    private final ModelMapper modelMapper = new ModelMapper();


    public void addToCart(Long userId, Long productId, int count) {
        ProductDto productDto = productClientFeign.get(productId).orElse(new ProductDto());
        Cart cart = cartRepository.findCartByUserId(userId);
        if (cart != null){
            List<CartItem> cartItems = cart.getCartItems();
            int listProductId = getListProductId(cartItems, productId);

            if(listProductId >= 0){
                addCount(count, cartItems.get(listProductId));
            }else{
                cartItems.add(new CartItem(
                        productDto.getProduct(),
                        productDto.getProductName(),
                        productDto.getProductPrice(),count,
                        productDto.getProductPrice() * count));
            }

            cart.setTotalPrice(getPrice(cartItems));
            cart.setCartItems(cartItems);
            cartRepository.save(cart);
        }else {
            Cart createCart = new Cart();
            createCart.setUserId(userId);
            createCart.getCartItems().add(new CartItem(
                    productDto.getProduct(),
                    productDto.getProductName(),
                    productDto.getProductPrice(),
                    count,productDto.getProductPrice() * count));
            createCart.setTotalPrice(getPrice(createCart.getCartItems()));
            cartRepository.save(createCart);
        }
    }

    private int getListProductId(List<CartItem> cartItems, Long productId) {
        int listProductId = -1;
        for (int i = 0; i < cartItems.size(); i++){
                if(cartItems.get(i).getProductId().equals(productId)){
                    listProductId = i;
                    break;
                }
            }
        return listProductId;
    }

    private void addCount(int count, CartItem cartItems) {
        if(count == 1){
            int productCount = cartItems.getCountProduct() + 1;
            cartItems.setCountProduct(productCount);
            cartItems.setTotalPriceProduct(productCount * cartItems.getPricePerProduct());
        }else{
            cartItems.setCountProduct(count);
            cartItems.setTotalPriceProduct(count * cartItems.getPricePerProduct());
        }
    }

    public int getPrice(List<CartItem> cartItems) {
        int totalPrice = 0;
        for(CartItem item: cartItems){
            totalPrice +=  item.getTotalPriceProduct();
        }
        return totalPrice;
    }

    public CartDto getCart(Long userId) {
        Cart cart = cartRepository.findCartByUserId(userId);
        List<CartItemDto> cartItemDtos = cart.getCartItems().stream().map(this::toDto).collect(Collectors.toList());
        CartDto cartDto = modelMapper.map(cart, CartDto.class);
        cartDto.setCartItems(cartItemDtos);
        return cartDto;
    }

    public Cart getCartToOrder(Long userId){
        return cartRepository.findCartByUserId(userId);
    }

    public void delFromCart(Long userId, Long productId) {
        Cart cart = cartRepository.findCartByUserId(userId);
        List<CartItem> cartItems = cart.getCartItems();
        int deletedId = getListProductId(cartItems,productId);
        if(deletedId >= 0){
            cartItems.remove(deletedId);
        }
        cart.setCartItems(cartItems);
        cartRepository.save(cart);
    }

    public void clearCart(Long userId) {
        Cart cart = cartRepository.findCartByUserId(userId);
        List<CartItem> cartItems = cart.getCartItems();
        cartItems.clear();
        cart.setTotalPrice(0);
        cart.setCartItems(cartItems);
        cartRepository.save(cart);
    }

    public CartItemDto toDto (CartItem cartItem){
        return modelMapper.map(cartItem, CartItemDto.class);
    }
}
