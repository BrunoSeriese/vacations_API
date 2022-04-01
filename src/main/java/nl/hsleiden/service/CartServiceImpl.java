package nl.hsleiden.service;


import nl.hsleiden.DAO.repository.CartRepository;
import nl.hsleiden.DAO.repository.VacationRepository;
import nl.hsleiden.model.Cart;
import nl.hsleiden.model.User;
import nl.hsleiden.model.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCarts(){
        return cartRepository.findAll();
    }

    @Override
    public void deleteCart(long cartId) {
        boolean exists = cartRepository.existsById(cartId);
        if(!exists){
            throw new IllegalStateException
                    ("Vacation with id" + cartId + " does not exist");
        }
        cartRepository.deleteById(cartId);
    }
    public void deleteCarts(long userId) {
        cartRepository.deleteAllByUserId(userId);
    }



    @Override
    public  List<Cart> getCart(long userId) {

        return cartRepository.findByUserId(userId);
    }




}
