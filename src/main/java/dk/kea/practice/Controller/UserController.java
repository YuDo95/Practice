package dk.kea.practice.Controller;

import dk.kea.practice.Model.User;
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

    @GetMapping
    public String manageUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new User());
        return "users";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam int user_id, @RequestParam String user_navn,
                             @RequestParam String user_email, @RequestParam String user_password,
                             @RequestParam int user_telefonnummer, @RequestParam String user_rolle) {

        User user = new User(user_id, user_navn, user_email, user_password, user_telefonnummer, user_rolle);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("selectedUserId") int userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }
}
