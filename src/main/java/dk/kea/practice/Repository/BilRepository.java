package dk.kea.practice.Repository;

import dk.kea.practice.Model.Bil;

import java.util.List;

public interface BilRepository {
    Bil findById(int vognnummer);
    List<Bil> findAll();
    void save(Bil bil);
    void update(Bil bil);
    void delete(int vognnummer);
}
