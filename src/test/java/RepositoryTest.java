import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import commerce.web.Application;
import commerce.web.entity.Product;
import commerce.web.repository.IProductsRepository;

@SpringBootTest(classes = {Application.class})
@AutoConfiguration
public class RepositoryTest {
    
    @Autowired
    private IProductsRepository productsRepository;

    @Test
    public void TestProductsRepository() {
        
        String name = "Test Name 1";
        Product product = new Product(name, "test", "test", 30.0f);
        productsRepository.save(product);

        Optional<Product> found1 = productsRepository.findById(product.getID());

        Assert.isTrue(found1.isPresent(), "Couldn't find product with given ID");
        Assert.isTrue(found1.get().getName().equals(name), "Product names doesn't match");

        productsRepository.deleteById(product.getID());

        Optional<Product> found2 = productsRepository.findById(product.getID());
        
        Assert.isTrue(!found2.isPresent(), "Failed to delete the product");
    }
}
