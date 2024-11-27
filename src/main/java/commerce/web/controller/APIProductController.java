package commerce.web.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import commerce.web.entity.Product;
import commerce.web.exception.ItemNotFoundException;
import commerce.web.repository.IProductsRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/products")
public class APIProductController {
    
    @Autowired
    private IProductsRepository productsRepository;

    @GetMapping("/list")
    public ResponseEntity<?> listProducts(@RequestParam int offset, @RequestParam int quantity) {
        Iterable<Product> iter = productsRepository.getNWithOffset(offset, quantity);

        ArrayList<Product> products = new ArrayList<>();
        for (Product product : iter) {
            products.add(product);
        }

        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 0);
        responseBody.put("size", products.size());
        responseBody.put("products", iter);   
        return ResponseEntity.ok().body(responseBody);
    }
    

    @GetMapping("/get")
    public ResponseEntity<?> getProduct(Model model, @RequestParam("productid") Long productid) {
        return productsRepository.findById(productid).map(product -> {
            HashMap<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", 0);
            responseBody.put("product", product);
            return ResponseEntity.ok().body(product);
        }).orElseThrow( ()-> 
            new ItemNotFoundException(productid)
        );
    }
    
    @PutMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        if(product == null) {
            return ResponseEntity.badRequest().body(null);
        }

        productsRepository.findById(product.getID()).orElseThrow( ()-> 
            new ItemNotFoundException(product.getID())
        );

        productsRepository.save(product);
        
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 0);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/create")
    public ResponseEntity<?> createProduct() {
        Product product = productsRepository.save(new Product("name", "descr", "imageSrc", 0));

        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 0);
        responseBody.put("product", product);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteProducts(@RequestParam("productid") Long productid) {
        productsRepository.findById(productid).orElseThrow( ()-> 
            new ItemNotFoundException(productid)
        );
        productsRepository.deleteById(productid);;

        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 0);
        return ResponseEntity.accepted().body(responseBody);
    }
}

// TODO: access checking