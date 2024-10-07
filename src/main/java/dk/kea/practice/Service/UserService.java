package dk.kea.practice.Service;

import dk.kea.practice.Model.User; // Make sure to import the correct User model
import dk.kea.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to create a new user
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    // Method to get a user by ID
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    // Method to get all users
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    // Method to update a user
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    // Method to delete a user
    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    public boolean login(String email, String password) {
        return userRepository.validateUser(email, password);
    }
}