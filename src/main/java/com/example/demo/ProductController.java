package com.example.demo;

import com.example.model.Product;
import com.example.model.ProductsInCart;
import com.example.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductsService productService;

    @GetMapping("/products")
    public  Iterable<Product> listProducts() {
        try{
            return productService.getProducts();
        }
        catch(Exception e) {
            System.out.println("Error! addProduct failed!");
            return null;
        }
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody ProductsInCart request) {
        return "dummy";
    }

    @PostMapping("addProduct")
    public String addProduct(@RequestBody Product product){
        try{
            productService.addProduct(product);
            return "success!";
        }
        catch(Exception e){
            System.out.println("Error! addProduct failed!");
        }
        return "failed";
    }




}