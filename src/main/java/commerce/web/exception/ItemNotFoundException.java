package commerce.web.exception;

public class ItemNotFoundException extends RuntimeException {
    
    public ItemNotFoundException(Long productID) {
        super("Item with id " + productID + " was not found.");
    }
}

// TODO: Implement exceptions to distinguish wether couldn't find a cart nor a product