package dk.kea.practice.Repository;

import dk.kea.practice.Model.Lejeaftale; // Make sure to import the correct Lejeaftale model
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class LejeaftaleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LejeaftaleRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createLejeaftale(Lejeaftale lejeaftale)
    {
        String sql = "INSERT INTO lejeaftale (lejeaftale_bil_vognnummer, lejeaftale_user_id, lejeaftale_startdato, lejeaftale_slutdato, lejeaftale_pris, lejeaftale_aftalt_km, lejeaftale_created_at, lejeaftale_updated_at) VALUES (?, ?, ?, ?, ?, ?, NOW(), NOW())";

        jdbcTemplate.update(sql,
                lejeaftale.getBilVognnummer(),
                lejeaftale.getUserId(),
                lejeaftale.getStartdato(),
                lejeaftale.getSlutdato(),
                lejeaftale.getPris(),
                lejeaftale.getAftaltKm());
    }


    public Lejeaftale getLejeaftaleById(int id)
    {
        String sql = "SELECT * FROM lejeaftale WHERE lejeaftale_id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, this::mapRowToLejeaftale);
    }


    public List<Lejeaftale> getAllLejeaftaler()
    {
        String sql = "SELECT * FROM lejeaftale";

        return jdbcTemplate.query(sql, this::mapRowToLejeaftale);
    }


    public void updateLejeaftale(int lejeaftaleId, String startdato, String slutdato, double pris, int aftaltKm, Integer slutKm, boolean overkoerteKm)
    {
        String sql = "UPDATE lejeaftale SET " +
                "lejeaftale_startdato = ?, " +
                "lejeaftale_slutdato = ?, lejeaftale_pris = ?, lejeaftale_aftalt_km = ?, " +
                "lejeaftale_slut_km = ?, lejeaftale_overkoerte_km = ?, lejeaftale_updated_at = CURRENT_TIMESTAMP " +
                "WHERE lejeaftale_id = ?";

        jdbcTemplate.update(sql, startdato, slutdato, pris, aftaltKm, slutKm, overkoerteKm, lejeaftaleId);
    }


    public void deleteLejeaftale(int id)
    {
        String sql = "DELETE FROM lejeaftale WHERE lejeaftale_id = ?";
        jdbcTemplate.update(sql, id);
    }


    private Lejeaftale mapRowToLejeaftale(ResultSet rs, int rowNum) throws SQLException
    {
        Lejeaftale lejeaftale = new Lejeaftale();
        lejeaftale.setLejeaftaleId(rs.getInt("lejeaftale_id"));
        lejeaftale.setBilVognnummer(rs.getInt("lejeaftale_bil_vognnummer"));
        lejeaftale.setStartdato(rs.getObject("lejeaftale_startdato", LocalDate.class));
        lejeaftale.setSlutdato(rs.getObject("lejeaftale_slutdato", LocalDate.class));
        lejeaftale.setPris(rs.getDouble("lejeaftale_pris"));
        lejeaftale.setAftaltKm(rs.getInt("lejeaftale_aftalt_km"));
        lejeaftale.setSlutKm(rs.getObject("lejeaftale_slut_km", Integer.class));
        lejeaftale.setOverkoerteKm(rs.getBoolean("lejeaftale_overkoerte_km"));
        lejeaftale.setCreatedAt(rs.getObject("lejeaftale_created_at", LocalDate.class));
        lejeaftale.setUpdatedAt(rs.getObject("lejeaftale_updated_at", LocalDate.class));

        return lejeaftale;
    }

}