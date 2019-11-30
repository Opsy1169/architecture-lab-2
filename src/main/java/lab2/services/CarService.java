package lab2.services;

import lab2.entities.Car;
import lab2.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findCarById(UUID id) {
        return carRepository.findById(id).get();
    }

    public Car saveCar(Car car) {
        if (car.getId() == null) {
            car.setId(UUID.randomUUID());
        }
        return carRepository.save(car);
    }

    public void deleteCar(Car car) {
        carRepository.delete(car);
    }
}
