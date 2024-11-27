package commerce.web.service.interfaces;

import java.util.List;
import java.util.Optional;

import commerce.web.entity.Cart;

public interface ICartService {

    public Optional<Cart> findCart(Long cartID);

    public void setProductQuantity(Long cartId, Long id, int quantity);

    public List<Long> getProducts(Long cartId);

    public int countProductsWithID(Long cartId, Long id);

    public boolean isAddedProductWithID(Long cartId, Long id);
} 
