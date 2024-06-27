package com.spring.data.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.data.entity.Product;
import com.spring.data.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	  @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
}
