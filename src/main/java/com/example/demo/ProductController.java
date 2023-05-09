package com.example.demo;

import com.example.exceptions.GenericErrorMessage;
import com.example.model.Product;
import com.example.model.Cart;
import com.example.service.ProductsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductsService productService;

    @GetMapping("/products")
    public Iterable<Product> listProducts() {
        try{
            return productService.getProducts();
        }
        catch(Exception e) {
            System.out.println("Error! getting list of products failed! Exception!");
            return null;
        }
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        try{
            return productService.addProduct(product);
        }
        catch(Exception e) {
            System.out.println("Error! addProduct failed! Exception!");
            return "failed";
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id){
        Long productId = Long.parseLong(id);
        try{
            return productService.deleteProduct(productId);
        }
        catch (Exception e){
            System.out.println("Error! Delete product failed. Exception!");
            return "failed";
        }

    }




}