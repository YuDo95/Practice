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
    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @GetMapping
    public String manageUsers(Model model)
    {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }


    @PostMapping("/create")
    public String createUser(@ModelAttribute User user)
    {
        userService.createUser(user);

        return "redirect:/users";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user)
    {
        userService.updateUser(user);

        return "redirect:/users";
    }


    @PostMapping("/delete")
    public String deleteUser(@RequestParam("selectedUserId") int userId)
    {
        userService.deleteUser(userId);

        return "redirect:/users";
    }

}
