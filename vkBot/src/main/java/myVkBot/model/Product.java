package myVkBot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private String city;
    @Column(name = "preview_image_id")
    private Long previewImageId;
    @Column(name = "date_of_created")
    private LocalDateTime dateOfCreated;
    @Column(name = "user_id")
    private Long userId;
}
