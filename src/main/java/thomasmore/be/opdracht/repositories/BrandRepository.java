package thomasmore.be.opdracht.repositories;

import org.springframework.data.repository.CrudRepository;
import thomasmore.be.opdracht.model.Brand;
import thomasmore.be.opdracht.model.Series;

import java.util.Optional;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Optional<Brand> findBrandByBrandNameEquals(String brandName);
}
