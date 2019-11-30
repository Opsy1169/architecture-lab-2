package lab2.controllers;

import lab2.entities.Car;
import lab2.repositories.CarRepository;
import lab2.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    CarRepository repository;

    @GetMapping("/cars")
    public String getCarBrowsePage(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", carService.findAll());
        return "cars";
    }

    @GetMapping("car-edit")
    public String getCarEditPage(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) {
        if (id.isEmpty()) {
            Car car = new Car();
            car.setId(UUID.randomUUID());
            model.addAttribute("car", car);
            return "carEdit";
        }
        UUID uuid = UUID.fromString(id);
        model.addAttribute("car", carService.findCarById(uuid));
        return "carEdit";
    }

    @GetMapping("car-delete/{id}")
    @ResponseBody
    public String deleteCar(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        Car car = carService.findCarById(uuid);
        carService.deleteCar(car);
        return "ok";
    }

    @PostMapping("save-car/{id}")
    public String saveCar(@PathVariable("id") String id, final Car car, final BindingResult bindingResult, final ModelMap modelMap) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

}
