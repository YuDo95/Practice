package dk.kea.practice.Controller;

import dk.kea.practice.Model.Bil;
import dk.kea.practice.Model.User;
import dk.kea.practice.Service.BilService;
import dk.kea.practice.Service.UserService;
import dk.kea.practice.Model.Lejeaftale;
import dk.kea.practice.Service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lejeaftaler")
public class LejeaftaleController {

    private final LejeaftaleService lejeaftaleService;
    private final UserService userService;
    private final BilService bilService;

    @Autowired
    public LejeaftaleController(LejeaftaleService lejeaftaleService, UserService userService, BilService bilService) {
        this.lejeaftaleService = lejeaftaleService;
        this.userService = userService;
        this.bilService = bilService;
    }

    // Endpoint to get all lejeaftaler
    @GetMapping
    public String getAllLejeaftaler(Model model) {

        List<Lejeaftale> lejeaftaler = lejeaftaleService.getAllLejeaftale();
        List<Bil> biler = bilService.getAllBiler();
        List<User> users = userService.getAllUsers();

        model.addAttribute("biler", biler);
        model.addAttribute("users", users);
        model.addAttribute("lejeaftaler", lejeaftaler);// Add the list to the model

        return "lejeaftaler"; // Return the view name to render
    }

    // Endpoint to create a new lejeaftale
    @PostMapping("/create")
    public String createLejeaftale(@ModelAttribute Lejeaftale lejeaftale) {
        lejeaftaleService.createLejeaftale(lejeaftale);
        return "redirect:/lejeaftaler"; // Redirect to a page (e.g., a list of lejeaftaler)
    }

    @PostMapping("/delete")
    public String deleteLejeaftale(@RequestParam("id") int lejeaftale_id) {
        lejeaftaleService.deleteLejeaftale(lejeaftale_id);
        return "redirect:/lejeaftaler";
    }

    @PostMapping("/update/{id}")
    public String updateLejeaftale(
            @PathVariable("id") int lejeaftaleId,
            @RequestParam("startdato") String startdato,
            @RequestParam("slutdato") String slutdato,
            @RequestParam("pris") double pris,
            @RequestParam("aftaltKm") int aftaltKm,
            @RequestParam("slutKm") Integer slutKm, // Nullable field
            @RequestParam("overkoerteKm") boolean overkoerteKm) {

        // Validate `aftaltKm` in the backend
        if (aftaltKm < 0) {
            return "redirect:/lejeaftaler?error=Aftalt KM must be a positive integer";
        }

        // Call service to update the lejeaftale
        lejeaftaleService.updateLejeaftale(lejeaftaleId, startdato, slutdato, pris, aftaltKm, slutKm, overkoerteKm);

        return "redirect:/lejeaftaler"; // Redirect to list of lejeaftaler after update
    }
}