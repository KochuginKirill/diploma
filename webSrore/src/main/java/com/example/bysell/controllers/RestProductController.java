package com.example.bysell.controllers;

import com.example.bysell.models.Product;
import com.example.bysell.services.ProductService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import com.example.bysell.models.ProductDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestProductController {

    private final ProductService productService;

    private final Gson gson;

//    @GetMapping("/api/products")
//    public List<ProductDTO> products() {
//        List<ProductDTO> result = new ArrayList<>();
//        for (Product product:
//                productService.getAllProducts()){
//            result.add(new ProductDTO(product.getTitle(), product.getPrice(), product.getCity()));
//        }
//        return result;
//    }

    @GetMapping("/products")
    public String products() {
        List<ProductDTO> tempList = new ArrayList<>();
        for (Product product:
                productService.getAllProducts()){
            tempList.add(new ProductDTO(product.getTitle(), product.getPrice(), product.getCity()));
        }
        return gson.toJson(tempList);
    }

}
