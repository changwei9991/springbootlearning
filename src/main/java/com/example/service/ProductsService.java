package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        Optional<Product> val =  productRepository.findById(id);
        return val.orElse(null);
    }

    public String addProduct(Product newProduct){
        productRepository.save(newProduct);
        return "success";
    }

    public String deleteProduct(Long productId){
        productRepository.deleteById(productId);
        return "success";
    }


}
