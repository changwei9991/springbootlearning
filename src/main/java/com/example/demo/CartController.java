package com.example.demo;


import com.example.model.Cart;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart/{productId}")
    public Long addToCart(@PathVariable("productId") String id, @RequestHeader("userId") Long userId){
      try{
          Long productId = Long.parseLong(id);
          return cartService.addToCart(productId,userId);

      }
      catch(Exception e){
          System.out.println("Failed!!");
          return null;
      }
    }

    @DeleteMapping("/removeFromCart")
    public String removeFromCart(@RequestHeader("userId") Long userId){
        try{
            return cartService.removeFromCart(userId);
        }
        catch(Exception e){
            System.out.println("Error in deletion!");
            return null;
        }
    }

    @GetMapping("/getCart")
    public Cart getCart(@RequestHeader("userId") Long userId){
        try{
            return cartService.getCart(userId);
        }
        catch(Exception e){
            System.out.println("Error in deletion!");
            return null;
        }
    }

    @GetMapping("/getAllCart")
    public Iterable<Cart>getAllCart(){
        try{
            return cartService.getAllCart();
        }
        catch(Exception e){
            System.out.println("Error in getting all cart!");
            return null;
        }
    }
}
