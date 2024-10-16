package dk.kea.practice.Controller;

import dk.kea.practice.Model.Bil;
import dk.kea.practice.Model.User;
import dk.kea.practice.Service.BilService;
import dk.kea.practice.Service.UserService;
import dk.kea.practice.Model.Lejeaftale;
import dk.kea.practice.Service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/lejeaftaler")
public class LejeaftaleController {

    private final LejeaftaleService lejeaftaleService;
    private final BilService bilService;
    private final UserService userService;

    @Autowired
    public LejeaftaleController(LejeaftaleService lejeaftaleService, BilService bilService,UserService userService)
    {
        this.lejeaftaleService = lejeaftaleService;
        this.bilService = bilService;
        this.userService = userService;
    }


    @GetMapping
    public String getAllLejeaftaler(Model model)
    {
        List<Lejeaftale> lejeaftaler = lejeaftaleService.getAllLejeaftale();
        List<Bil> biler = bilService.getAllBiler();
        List<User> users = userService.getAllUsers();

        model.addAttribute("biler", biler);
        model.addAttribute("users", users);
        model.addAttribute("lejeaftaler", lejeaftaler);

        return "lejeaftaler";
    }


    @PostMapping("/create")
    public String createLejeaftale(@ModelAttribute Lejeaftale lejeaftale,
                                   @RequestParam("vognnummer") int vognnummer,
                                   @RequestParam("users") int userId)
    {
        lejeaftale.setBilVognnummer(vognnummer);
        lejeaftale.setUserId(userId);
        lejeaftale.setSlutKm(null);
        lejeaftale.setOverkoerteKm(false);

        // Save the lejeaftale using the service
        lejeaftaleService.createLejeaftale(lejeaftale);

        return "redirect:/lejeaftaler";
    }


    @PostMapping("/update/{id}")
    public String updateLejeaftale(@PathVariable("id") int lejeaftaleId,
                                   @ModelAttribute Lejeaftale lejeaftale) {

        lejeaftale.setLejeaftaleId(lejeaftaleId);

        lejeaftaleService.updateLejeaftale(lejeaftale);

        return "redirect:/lejeaftaler";
    }


    @PostMapping("/delete")
    public String deleteLejeaftale(@RequestParam("id") int lejeaftale_id)
    {
        lejeaftaleService.deleteLejeaftale(lejeaftale_id);

        return "redirect:/lejeaftaler";
    }

}