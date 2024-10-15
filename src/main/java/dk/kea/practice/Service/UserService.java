package dk.kea.practice.Service;

import dk.kea.practice.Model.User;
import dk.kea.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {return userRepository.getAllUsers();}


    public void createUser(User user) {userRepository.createUser(user);}


    public void updateUser(User user)
    {
        userRepository.updateUser(user);
    }


    public void deleteUser(int userId)
    {
        userRepository.deleteUser(userId);
    }


    public boolean login(String email, String password)
    {
        return userRepository.validateUser(email, password);
    }

    /* Bruges ikke (endnu)
    public User getUserById(int userId)
    {
        return userRepository.getUserById(userId);
    } */

}
