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

    // Method to update a lejeaftale
    public int updateLejeaftale(Lejeaftale lejeaftale) {
        return lejeaftaleRepository.updateLejeaftale(lejeaftale);
    }

    // Method to delete a lejeaftale
    public int deleteLejeaftale(int lejeaftaleId) {
        return lejeaftaleRepository.deleteLejeaftale(lejeaftaleId);
    }
}
