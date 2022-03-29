package nl.hsleiden.controller;


import nl.hsleiden.model.Cart;
import nl.hsleiden.service.CartService;
import nl.hsleiden.service.CartServiceImpl;
import nl.hsleiden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api")
public class CartController {

    private final CartService cartService;
    private final UserService userService;


    @Autowired
    public CartController(CartServiceImpl cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }


    @GetMapping("/carts")
    public List<Cart> getVacations() {
        return cartService.getCarts();
    }

    @GetMapping("/carts/{userId}")
    public List<Cart> getCartsByUser(@PathVariable("userId") Integer userId){
        return cartService.getCart(userId);
    }



    @CrossOrigin
    @DeleteMapping(path = "cart/{cartId}")
    public void deleteVacation(@PathVariable("cartId") int cartId) {
       cartService.deleteCart(cartId);
    }


}