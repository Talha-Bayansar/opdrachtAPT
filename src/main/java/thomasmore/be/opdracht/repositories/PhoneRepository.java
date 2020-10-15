package thomasmore.be.opdracht.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import thomasmore.be.opdracht.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {
    Iterable<Phone> findByPrijsGreaterThan(int prijs);
    Iterable<Phone> findByPrijsBetween(int minPrijs, int maxPrijs);
    Iterable<Phone> findPhonesByNameContains(String phoneName);

    @Query("SELECT p FROM Phone p WHERE " +
    "(:min is null or p.prijs > :min) and " +
    "(:max is null or p.prijs <= :max) and " +
    "(:phoneName is null or p.name like %:phoneName%)")
    Iterable<Phone> findPhonesByCriteria(@Param("min") Integer min,
                                         @Param("max") Integer max,
                                         @Param("phoneName") String phoneName);
}
