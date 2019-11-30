package lab2.controllers;

import lab2.entities.Showroom;
import lab2.services.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ShowroomController {
    @Autowired
    ShowroomService showroomService;

    @GetMapping("/showrooms")
    public String getShowroomsBrowsePage(Model model) {
        List<Showroom> cars = showroomService.findAll();
        model.addAttribute("showrooms", showroomService.findAll());
        return "showrooms";
    }

    @GetMapping("showroom-edit")
    public String getShowroomEditPage(@RequestParam(name = "id", required = false, defaultValue = "") String id, Model model) {
        if (id.isEmpty()) {
            Showroom showroom = new Showroom();
            showroom.setId(UUID.randomUUID());
            model.addAttribute("showroom", showroom);
            return "showroomEdit";
        }
        UUID uuid = UUID.fromString(id);
        model.addAttribute("showroom", showroomService.findShowroomById(uuid));
        return "showroomEdit";
    }

    @GetMapping("showroom-delete/{id}")
    @ResponseBody
    public String deleteShowroom(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        Showroom showroom = showroomService.findShowroomById(uuid);
        showroomService.deleteCar(showroom);
        return "ok";
    }

    @PostMapping("save-showroom/{id}")
    public String saveShowroom(@PathVariable("id") String id, final Showroom showroom, final BindingResult bindingResult, final ModelMap modelMap) {
        showroomService.saveShowroom(showroom);
        return "redirect:/showrooms";
    }
}
