package lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import lab2.entities.Car;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    @Override
    List<Car> findAll();

    Optional<Car> findById(UUID id);

    @Override
    Car save(Car s);

    @Override
    void delete(Car car);
}
