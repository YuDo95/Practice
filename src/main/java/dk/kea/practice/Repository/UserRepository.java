package dk.kea.practice.Repository;

import dk.kea.practice.Model.User; // Make sure to import the correct User model
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
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to create a new user
    public void createUser(User user) {
        String sql = "INSERT INTO user (user_navn, user_email, user_password, user_telefonnummer, user_rolle) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUser_navn(), user.getUser_email(), user.getUser_password(),
                user.getUser_telefonnummer(), user.getUser_rolle());
    }


    public boolean validateUser(String email, String password) {
        String sql = "SELECT COUNT(*) FROM user WHERE user_email = ? AND user_password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email, password}, Integer.class);
        return count != null && count > 0;
    }

    /** Method to create a new user
    public void createUser(User user) {
        // Get the current count of users
        String countSql = "SELECT COUNT(*) FROM user";
        int count = jdbcTemplate.queryForObject(countSql, Integer.class);

        // Set the user_id to count + 1
        user.setUser_id(count + 1);

        // Insert the new user with the calculated user_id
        String sql = "INSERT INTO user (user_id, user_navn, user_email, user_password, user_telefonnummer, user_rolle) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUser_id(), user.getUser_navn(), user.getUser_email(), user.getUser_password(),
                user.getUser_telefonnummer(), user.getUser_rolle());
    }
*/


    // Method to retrieve a user by ID
    public User getUserById(int userId) {
        String sql = "SELECT * FROM user WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, this::mapRowToUser);
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, this::mapRowToUser);
    }

    // Method to update a user
    public void updateUser(User user) {
        String sql = "UPDATE user SET user_navn = ?, user_email = ?, user_password = ?, user_telefonnummer = ?, user_rolle = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUser_navn(), user.getUser_email(), user.getUser_password(),
                user.getUser_telefonnummer(), user.getUser_rolle(), user.getUser_id());
    }

    // Method to delete a user
    public void deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }

    // Helper method to map rows of the result set to User objects
    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_navn(rs.getString("user_navn"));
        user.setUser_email(rs.getString("user_email"));
        user.setUser_password(rs.getString("user_password"));
        user.setUser_telefonnummer(rs.getInt("user_telefonnummer"));
        user.setUser_rolle(rs.getString("user_rolle"));
        return user;
    }
}
