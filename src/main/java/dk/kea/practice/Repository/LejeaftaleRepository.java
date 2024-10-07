package dk.kea.practice.Repository;

import dk.kea.practice.Model.Lejeaftale; // Make sure to import the correct Lejeaftale model
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LejeaftaleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LejeaftaleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to create a new lejeaftale
    public void createLejeaftale(Lejeaftale lejeaftale) {

        String sql = "INSERT INTO lejeaftale (lejeaftale_bil_vognnummer, lejeaftale_user_id, lejeaftale_startdato, lejeaftale_slutdato, lejeaftale_pris, lejeaftale_aftalt_km, lejeaftale_created_at, lejeaftale_updated_at) VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";

        jdbcTemplate.update(sql,
                lejeaftale.getBilVognnummer(),
                lejeaftale.getUserId(),
                lejeaftale.getStartdato(),
                lejeaftale.getSlutdato(),
                lejeaftale.getPris(),
                lejeaftale.getAftaltKm());

    }


    // Method to retrieve a lejeaftale by ID
    public Lejeaftale getLejeaftaleById(int id) {
        String sql = "SELECT * FROM lejeaftale WHERE lejeaftale_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToLejeaftale);
    }

    // Method to retrieve all lejeaftaler
    public List<Lejeaftale> getAllLejeaftaler() {
        String sql = "SELECT * FROM lejeaftale";
        return jdbcTemplate.query(sql, this::mapRowToLejeaftale);
    }

    public void updateLejeaftale(int lejeaftaleId, String startdato, String slutdato, double pris, int aftaltKm, Integer slutKm, boolean overkoerteKm) {
        String sql = "UPDATE lejeaftale SET " +
                "lejeaftale_startdato = ?, " +
                "lejeaftale_slutdato = ?, lejeaftale_pris = ?, lejeaftale_aftalt_km = ?, " +
                "lejeaftale_slut_km = ?, lejeaftale_overkoerte_km = ?, lejeaftale_updated_at = CURRENT_TIMESTAMP " +
                "WHERE lejeaftale_id = ?";

        jdbcTemplate.update(sql, startdato, slutdato, pris, aftaltKm, slutKm, overkoerteKm, lejeaftaleId);
    }

    // Method to delete a lejeaftale
    public void deleteLejeaftale(int id) {
        String sql = "DELETE FROM lejeaftale WHERE lejeaftale_id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Helper method to map rows of the result set to Lejeaftale objects
    private Lejeaftale mapRowToLejeaftale(ResultSet rs, int rowNum) throws SQLException {
        Lejeaftale lejeaftale = new Lejeaftale();
        lejeaftale.setLejeaftaleId(rs.getInt("lejeaftale_id"));
        lejeaftale.setBilVognnummer(rs.getInt("lejeaftale_bil_vognnummer"));
        lejeaftale.setStartdato(rs.getString("lejeaftale_startdato"));
        lejeaftale.setSlutdato(rs.getString("lejeaftale_slutdato"));
        lejeaftale.setPris(rs.getDouble("lejeaftale_pris"));
        lejeaftale.setAftaltKm(rs.getInt("lejeaftale_aftalt_km"));
        lejeaftale.setSlutKm(rs.getObject("lejeaftale_slut_km", Integer.class)); // Handling possible null value
        lejeaftale.setOverkoerteKm(rs.getBoolean("lejeaftale_overkoerte_km"));
        lejeaftale.setCreatedAt(rs.getString("lejeaftale_created_at"));
        lejeaftale.setUpdatedAt(rs.getString("lejeaftale_updated_at"));
        return lejeaftale;
    }
}