package dk.kea.practice.Service;

import dk.kea.practice.Model.Lejeaftale;
import dk.kea.practice.Repository.LejeaftaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LejeaftaleService {
    public final LejeaftaleRepository lejeaftaleRepository;

    @Autowired
    public LejeaftaleService(LejeaftaleRepository lejeaftaleRepository) {
        this.lejeaftaleRepository = lejeaftaleRepository;
    }

    // Method to create a new lejeaftale
    public void createLejeaftale(Lejeaftale lejeaftale) {
        lejeaftaleRepository.createLejeaftale(lejeaftale);
    }

    // Method to get a lejeaftale by ID
    public Lejeaftale getLejeaftaleById(int lejeaftaleId) {
        return lejeaftaleRepository.getLejeaftaleById(lejeaftaleId);
    }

    // Method to get all lejeaftale
    public List<Lejeaftale> getAllLejeaftale() {
        return lejeaftaleRepository.getAllLejeaftaler();
    }



    public void updateLejeaftale(int lejeaftaleId, String startdato, String slutdato, double pris, int aftaltKm, Integer slutKm, boolean overkoerteKm) {
        lejeaftaleRepository.updateLejeaftale(lejeaftaleId, startdato, slutdato, pris, aftaltKm, slutKm, overkoerteKm);
    }


    // Method to delete a lejeaftale
    public void deleteLejeaftale(int lejeaftaleId) {
        lejeaftaleRepository.deleteLejeaftale(lejeaftaleId);
    }
}
