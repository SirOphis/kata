package co.weit.kata.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    private Description description;
    private BigDecimal price;
    private String category;
    private String imageUrl;
    private Rating rating;
}
