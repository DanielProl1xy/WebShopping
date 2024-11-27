package commerce.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import commerce.web.entity.Cart;
import commerce.web.service.interfaces.ICartService;

@Service
public class CartService implements ICartService {

    @Override
    public Optional<Cart> findCart(Long cartID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'FindCart'");
    }

    @Override
    public void setProductQuantity(Long cartId, Long id, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SetProductQuantity'");
    }

    @Override
    public List<Long> getProducts(Long cartId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetProducts'");
    }

    @Override
    public int countProductsWithID(Long cartId, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CountProductsWithID'");
    }

    @Override
    public boolean isAddedProductWithID(Long cartId, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'IsAddedProductWithID'");
    }
    
}
