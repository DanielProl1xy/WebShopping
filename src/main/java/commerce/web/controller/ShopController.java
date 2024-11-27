package commerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import commerce.web.entity.Product;
import commerce.web.exception.ItemNotFoundException;
import commerce.web.repository.IProductsRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IProductsRepository productsService;

    @GetMapping
    public String viewProducts(Model model) {

        final Iterable<Product> products = productsService.findAll();
        model.addAttribute("products", products);
        return "shopview";
    }    

    @GetMapping("/{productid}")
    public String viewProduct(Model model, @PathVariable Long productid) {

        final Product product = productsService.findById(productid).orElseThrow(
            () -> new ItemNotFoundException(productid)
        );
        model.addAttribute("product", product);        
        return "itemview";
    }

}
