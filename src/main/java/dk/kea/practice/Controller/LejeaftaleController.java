package dk.kea.practice.Controller;

import dk.kea.practice.Model.Lejeaftale;
import dk.kea.practice.Service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lejeaftale")
public class LejeaftaleController {

    private final LejeaftaleService lejeaftaleService;

    @Autowired
    public LejeaftaleController(LejeaftaleService lejeaftaleService) {
        this.lejeaftaleService = lejeaftaleService;
    }

    // Endpoint to create a new lejeaftale
    @PostMapping
    public void createLejeaftale(@RequestBody Lejeaftale lejeaftale) {
        lejeaftaleService.createLejeaftale(lejeaftale);
    }

    // Endpoint to get a lejeaftale by ID
    @GetMapping("/{id}")
    public Lejeaftale getLejeaftaleById(@PathVariable("id") int lejeaftaleId) {
        return lejeaftaleService.getLejeaftaleById(lejeaftaleId);
    }

    // Endpoint to get all lejeaftaler
    @GetMapping
    public List<Lejeaftale> getAllLejeaftale() {
        return lejeaftaleService.getAllLejeaftale();
    }

    // Endpoint to update a lejeaftale
    @PutMapping("/{id}")
    public void updateLejeaftale(@PathVariable("id") int lejeaftaleId, @RequestBody Lejeaftale lejeaftale) {
        lejeaftale.setId(lejeaftaleId);  // Ensure the correct ID is updated
        lejeaftaleService.updateLejeaftale(lejeaftale);
    }

    // Endpoint to delete a lejeaftale
    @DeleteMapping("/{id}")
    public void deleteLejeaftale(@PathVariable("id") int lejeaftaleId) {
        lejeaftaleService.deleteLejeaftale(lejeaftaleId);
    }
}