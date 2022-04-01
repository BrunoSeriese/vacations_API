package nl.hsleiden.service;

import nl.hsleiden.model.Cart;

import java.util.List;

public interface CartService {

    List<Cart> getCart(long userId);
    List<Cart> getCarts();
     void deleteCart(long cartId);
     void deleteCarts(long userId);
}
