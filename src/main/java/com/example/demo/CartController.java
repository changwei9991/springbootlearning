package com.example.demo;


import com.example.exceptions.CartResult;
import com.example.model.Cart;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart/{productId}")
    public CartResult addToCart(@PathVariable("productId") String id, @RequestHeader("userId") Long userId){
      try{
          Long productId = Long.parseLong(id);
          return cartService.addToCart(productId,userId);

      }
      catch(Exception e){
          System.out.println("Failed to add specified product to cart!! Exception caught.");
          return null;
      }
    }

    @DeleteMapping("/removeFromCart")
    public CartResult removeFromCart(@RequestHeader("userId") Long userId){
        try{
             return cartService.removeFromCart(userId);
        }
        catch(Exception e){
            System.out.println("Error in deletion! Exception caught.");
            return null;
        }
    }

    @GetMapping("/getCart")
    public CartResult getCart(@RequestHeader("userId") Long userId){
        try{
            return cartService.getCart(userId);
        }
        catch(Exception e){
            System.out.println("Unable to get cart! Exception! ");
            return null;
        }
    }

    // just for testing
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
