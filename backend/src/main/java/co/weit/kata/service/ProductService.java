package co.weit.kata.service;


import co.weit.kata.entity.Product;
import co.weit.kata.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    public static final String URL = "https://fakestoreapi.com/products";
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RestTemplate restTemplate;

    public void fetchAndSaveProducts() throws JsonProcessingException {
        String response = restTemplate.getForObject(URL, String.class);

        List<Product> products = productMapper.mapToProducts(response);  // Use mapToProducts for array
        productRepository.saveAll(products);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
