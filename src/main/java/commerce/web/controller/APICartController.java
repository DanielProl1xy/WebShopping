package commerce.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import commerce.web.entity.Cart;
import commerce.web.exception.ItemNotFoundException;
import commerce.web.repository.IProductsRepository;
import commerce.web.service.interfaces.ICartService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/cart")
public class APICartController {

    @Autowired ICartService cartService;

    @Autowired IProductsRepository productsRepository;
    
    @GetMapping("/set")
    public ResponseEntity<?> setProductQuantity(@RequestParam Long productid
                                            , @RequestParam Long cartid
                                            , @RequestParam int quantity) {

        if(quantity < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        
        productsRepository.findById(productid).orElseThrow( 
            ()-> new ItemNotFoundException(productid)
        );
        
        cartService.findCart(cartid).orElseThrow( 
            ()-> new ItemNotFoundException(cartid));

        cartService.setProductQuantity(cartid, productid, quantity);

        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 0);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/get")
    public Cart getCart(@RequestParam Long cartid) {
        return new Cart();
    }
}
