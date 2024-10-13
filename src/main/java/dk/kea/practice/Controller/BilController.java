package dk.kea.practice.Controller;

import dk.kea.practice.Model.Bil;
import dk.kea.practice.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bil")
public class BilController {

    public BilService bilService;

    @Autowired
    public BilController(BilService bilService) {
        this.bilService = bilService;
    }

    // Endpoint to create a new Bil
    @PostMapping("/create")
    public String createBil(@ModelAttribute Bil bil) {
        bilService.saveBil(bil);
        return "redirect:/bil"; // Redirect to the fleet page after creation
    }

    // Endpoint to get a Bil by ID
    @GetMapping("/{vognnummer}")
    public Bil getBilById(@PathVariable("vognnummer") int vognnummer) {
        return bilService.getBilById(vognnummer);
    }

    // Endpoint to get all Bils
    @GetMapping
    public String getAllBiler(Model model) {

        List<Bil> allBiler = bilService.getAllBiler(); // Fetch the list of Bils from the service

        model.addAttribute("biler", allBiler); // Add the list to the model with the name "biler"

        return "bil"; // Return the name of the Thymeleaf template to display the list
    }


    // Endpoint to update a Bil
    @PostMapping("/update/{vognnummer}")
    public String updateBil(@PathVariable("vognnummer") int vognnummer, @ModelAttribute Bil bil) {
        bil.setVognnummer(vognnummer);  // Ensure the correct ID is updated
        bilService.updateBil(bil);
        return "redirect:/bil"; // Redirect to the fleet page after updating
    }


    // Endpoint to edit a Bil (Get the edit form)
    @GetMapping("/edit/{vognnummer}")
    public String editBil(@PathVariable("vognnummer") int vognnummer, Model model) {
        Bil bil = bilService.getBilById(vognnummer); // Fetch the car details
        model.addAttribute("bil", bil); // Add the car to the model
        return "bil"; // Return the view for editing
    }


    // Endpoint to delete a Bil
    @PostMapping("/delete")
    public String deleteBil(@RequestParam("vognnummer") int vognnummer) {
        bilService.deleteBil(vognnummer);
        return "redirect:/bil"; // Redirect to the fleet page after deletion
    }
}