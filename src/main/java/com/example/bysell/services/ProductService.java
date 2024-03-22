package com.example.bysell.services;

import com.example.bysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        products.add(new Product(++ID, "Playstation 5", "Simple describtion", 67000, "Krasnoyars", "Tomas"));
        products.add(new Product(++ID, "Iphone 8", "Simple describtion", 24000, "Moscow", "Arthur"));
    }

    public List<Product> listProducts() { return products; }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId() == id);
    }
}
