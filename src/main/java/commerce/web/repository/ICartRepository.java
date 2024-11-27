package commerce.web.repository;

import java.util.Map;

import org.springframework.data.repository.CrudRepository;

public interface ICartRepository extends CrudRepository<Long, Map<Long, Integer>> {
    
}
