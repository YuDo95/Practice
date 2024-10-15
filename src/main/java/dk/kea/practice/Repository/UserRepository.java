package dk.kea.practice.Repository;

import dk.kea.practice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<User> getAllUsers()
    {
        String sql = "SELECT * FROM user";

        return jdbcTemplate.query(sql, this::mapRowToUser);
    }


    public void createUser(User user)
    {
        String sql = "INSERT INTO user (user_navn, user_email, user_password, user_telefonnummer, user_rolle) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUser_navn(), user.getUser_email(), user.getUser_password(),
                user.getUser_telefonnummer(), user.getUser_rolle());
    }


    public void updateUser(User user)
    {
        String sql = "UPDATE user SET user_navn = ?, user_email = ?, user_password = ?, user_telefonnummer = ?, user_rolle = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUser_navn(), user.getUser_email(), user.getUser_password(),
                user.getUser_telefonnummer(), user.getUser_rolle(), user.getUser_id());
    }


    public void deleteUser(int userId)
    {
        String sql = "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }


    public boolean validateUser(String email, String password)
    {
        String sql = "SELECT COUNT(*) FROM user WHERE user_email = ? AND user_password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);
        return count != null && count > 0;
    }


    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_navn(rs.getString("user_navn"));
        user.setUser_email(rs.getString("user_email"));
        user.setUser_password(rs.getString("user_password"));
        user.setUser_telefonnummer(rs.getInt("user_telefonnummer"));
        user.setUser_rolle(rs.getString("user_rolle"));
        return user;
    }

     /* Bruges ikke (endnu)
    public User getUserById(int userId)
    {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, this::mapRowToUser);
    }*/

}
