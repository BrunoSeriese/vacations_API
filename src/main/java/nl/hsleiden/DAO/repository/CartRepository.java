package nl.hsleiden.DAO.repository;

import nl.hsleiden.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository   extends JpaRepository<Cart, Long> {
   Cart findById(long id);
   List<Cart> findByUserId(long userId);
}
