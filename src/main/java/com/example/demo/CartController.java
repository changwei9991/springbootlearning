package com.example.demo;


import com.example.exceptions.CartResult;
import com.example.model.Cart;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4401", allowedHeaders = {}, exposedHeaders = {})
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addToCart/{productId}")
    public CartResult addToCart(@PathVariable("productId") String id, @RequestHeader("userId") String userId){
      try{
          Long productId = Long.parseLong(id);
          Long parsedUserId = Long.parseLong(userId);
          return cartService.addToCart(productId,parsedUserId);

      }
      catch(Exception e){
          System.out.println("Failed to add specified product to cart!! Exception caught.");
          return null;
      }
    }

    @DeleteMapping("/removeFromCart")
    public CartResult removeFromCart(@RequestHeader("userId") String userId){
        try{
            Long parsedUserId = Long.parseLong(userId);
            return cartService.removeFromCart(parsedUserId);
        }
        catch(Exception e){
            System.out.println("Error in deletion! Exception caught.");
            return null;
        }
    }

    @GetMapping("/getCart")
    public CartResult getCart(@RequestHeader("userId") String userId){
        try{
            Long parsedUserId = Long.parseLong(userId);
            return cartService.getCart(parsedUserId);
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
