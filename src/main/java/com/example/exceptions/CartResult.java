package com.example.exceptions;

import com.example.model.Cart;

public class CartResult extends GenericResult{

    private Cart result;

    public CartResult(String message){
        super(message);
    }

    public CartResult(String message, Cart result){
        super(message);
        this.result = result;
    }

    public Cart getResult() {
        return result;
    }

    public void setResult(Cart result) {
        this.result = result;
    }
}
