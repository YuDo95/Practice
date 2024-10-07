package dk.kea.practice.Service;

import dk.kea.practice.Model.Bil;
import dk.kea.practice.Repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilService {

    private final BilRepository bilRepository;

    @Autowired
    public BilService(BilRepository bilRepository) {
        this.bilRepository = bilRepository;
    }

    public Bil getBilById(int vognnummer) {
        Bil bil = bilRepository.findById(vognnummer);
        if (bil == null) {
            throw new IllegalArgumentException("Bil not found with vognnummer: " + vognnummer);
        }
        return bil;
    }

    public List<Bil> getAllBiler() {
        return bilRepository.findAll();
    }

    public void saveBil(Bil bil) {
        bilRepository.save(bil);
    }

    public void updateBil(Bil bil) {
        if (bilRepository.findById(bil.getVognnummer()) == null) {
            throw new IllegalArgumentException("Cannot update. Bil not found with vognnummer: " + bil.getVognnummer());
        }
        bilRepository.update(bil);
    }

    public void deleteBil(int vognnummer) {
        if (bilRepository.findById(vognnummer) == null) {
            throw new IllegalArgumentException("Cannot delete. Bil not found with vognnummer: " + vognnummer);
        }
        bilRepository.delete(vognnummer);
    }
}