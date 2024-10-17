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
        public LejeaftaleService(LejeaftaleRepository lejeaftaleRepository)
        {
            this.lejeaftaleRepository = lejeaftaleRepository;
        }


        public List<Lejeaftale> getAllLejeaftale() {
            return lejeaftaleRepository.getAllLejeaftaler();
        }


        public void createLejeaftale(Lejeaftale lejeaftale) {lejeaftaleRepository.createLejeaftale(lejeaftale);}


        public void updateLejeaftale(Lejeaftale lejeaftale) {lejeaftaleRepository.updateLejeaftale(lejeaftale);}


        public void deleteLejeaftale(int lejeaftaleId) {lejeaftaleRepository.deleteLejeaftale(lejeaftaleId);}


        /* Bliver ikke brugt (endnu)
        public Lejeaftale getLejeaftaleById(int lejeaftaleId) {
            return lejeaftaleRepository.getLejeaftaleById(lejeaftaleId);
        }*/

    }
