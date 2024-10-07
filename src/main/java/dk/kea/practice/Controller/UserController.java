package dk.kea.practice.Controller;

import dk.kea.practice.Model.User; // Make sure to import the correct User model
import dk.kea.practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to display the user management page
    @GetMapping
    public String manageUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User()); // For creating a new user
        return "users"; // Single HTML page for all user management
    }

    // Endpoint to create a new user
    @PostMapping("/create")
    public String createUser(
            @RequestParam String user_navn,
            @RequestParam String user_email,
            @RequestParam String user_password,
            @RequestParam int user_telefonnummer,
            @RequestParam String user_rolle) {

        User user = new User(user_navn, user_email, user_password, user_telefonnummer, user_rolle);
        userService.createUser(user);
        return "redirect:/users"; // Redirect to the user management page after creation
    }

    // Endpoint to update a user
    @PostMapping("/edit")
    public String updateUser(
            @RequestParam int user_id,
            @RequestParam String user_navn,
            @RequestParam String user_email,
            @RequestParam String user_password,
            @RequestParam int user_telefonnummer,
            @RequestParam String user_rolle) {

        User user = new User(user_id, user_navn, user_email, user_password, user_telefonnummer, user_rolle);
        userService.updateUser(user);
        return "redirect:/users"; // Redirect to the user management page after updating
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("selectedUserId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }


}