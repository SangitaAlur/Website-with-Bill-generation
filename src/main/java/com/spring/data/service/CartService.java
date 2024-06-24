package com.spring.data.service;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.data.entity.Cart;
import com.spring.data.entity.Order;
import com.spring.data.entity.Product;
import com.spring.data.entity.User;
import com.spring.data.repository.CartRepository;
import com.spring.data.repository.OrderRepository;
import com.spring.data.repository.ProductRepository;
import com.spring.data.repository.UserRepository;
import jakarta.transaction.Transactional;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<Cart> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }
    
    @Transactional
    public void addToCart(Long userId, Long productId) {
        Cart cart = new Cart();

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        cart.setUser(user);
        
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + productId));
        cart.setProduct(product);

        cartRepository.save(cart);
    }

    @Transactional
    public void removeFromCart(Long userId, Long productId) {
        cartRepository.deleteByUserIdAndProductId(userId, productId);
    }
    
    @Transactional
    public int getCartCount(Long userId) {
        return cartRepository.findByUserId(userId).size();
    }
    
    public void placeOrder(User user, double totalAmount) {
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
    }
}
