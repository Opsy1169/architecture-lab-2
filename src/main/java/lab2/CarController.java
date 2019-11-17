package lab2;

import lab2.entities.Car;
import lab2.repositories.CarRepository;
import lab2.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.util.UIUtil;

import java.util.UUID;


@Controller
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    CarRepository repository;

    @GetMapping("/cars")
    public String getCarBrowsePage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "cars";
    }

    @GetMapping("car-edit")
    public String getCarEditPage(@RequestParam(name="id", required=false, defaultValue = "") String id, Model model){
        if(id.isEmpty()){
            model.addAttribute("car", new Car());
            return "carEdit";
        }
        UUID uuid = UUID.fromString(id);
        model.addAttribute("car", carService.findCarById(uuid));
        return "carEdit";
    }

    @GetMapping("car-delete")
    @ResponseBody
    public String  deleteCar(@RequestParam(name="id") String id){
        UUID uuid = UUID.fromString(id);
        Car car = carService.findCarById(uuid);
        carService.deleteCar(car);
        return "ok";
    }

}
