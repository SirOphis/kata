package co.weit.kata.service;

import co.weit.kata.entity.Description;
import co.weit.kata.entity.Product;
import co.weit.kata.entity.Rating;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper {

    @Autowired
    private ObjectMapper mapper;

    public List<Product> mapToProducts(String json) throws JsonProcessingException {
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Product.class);
        JsonNode node = mapper.readTree(json);

        List<Product> products = new ArrayList<>();
        for (JsonNode productNode : node) {
            Product product = new Product();
            product.setId(productNode.get("id").asLong());
            product.setTitle(productNode.get("title").asText());
            product.setPrice(new BigDecimal(productNode.get("price").asText()));
            Description description = new Description();
            description.setContent(productNode.get("description").asText());
            product.setDescription(description);
            product.setCategory(productNode.get("category").asText());
            product.setImageUrl(productNode.get("image").asText());

            Rating rating = new Rating();
            rating.setRate(productNode.get("rating").get("rate").asDouble());
            rating.setCount(productNode.get("rating").get("count").asInt());
            product.setRating(rating);

            products.add(product);
        }

        return products;
    }
}
