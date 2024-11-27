package commerce.web.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.PersistenceCreator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cart {
    
    @JsonProperty
    private Long id;

    @JsonProperty
    private Map<Long, Integer> productsToCount;

    public Cart() {
        productsToCount = new HashMap<>();
    }

    @PersistenceCreator
    public Cart(Long id, Map<Long, Integer> items) {
        this.id = id;
        productsToCount = new HashMap<>(items);
    }

    public void setProductQuantity(Long productid, int quantity) {

        if(quantity > 0) {
            productsToCount.put(productid, quantity);
            return;
        }
        
        productsToCount.remove(productid);
    }

    public Long getID() {
        return this.id;
    }
}
