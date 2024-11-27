package commerce.web.repository;


import commerce.web.entity.Product;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends CrudRepository<Product, Long> {
    
    @Query(value = "SELECT * FROM \"PRODUCTS\" LIMIT :#{#n} OFFSET :#{#offset}")
    public Iterable<Product> getNWithOffset(int offset, int n);
}
