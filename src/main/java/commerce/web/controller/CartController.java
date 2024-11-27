package commerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import commerce.web.entity.Cart;
import commerce.web.exception.ItemNotFoundException;
import commerce.web.service.interfaces.ICartService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/mycart")
public class CartController {
    
    @Autowired
    private ICartService cartService;

    @GetMapping
    public String viewCart(Model model) {
        Cart cart = cartService.findCart(0L).orElseThrow(
            () -> new ItemNotFoundException(0L)
        );

        model.addAttribute("cart", cart);

        return "cartview";
    }
    
}
