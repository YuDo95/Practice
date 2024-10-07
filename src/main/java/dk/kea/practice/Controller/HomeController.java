package dk.kea.practice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping() // Maps GET requests to /home
    public String showHomePage() {
        return "home"; // Returns the home view (home.html)
    }

    @GetMapping("/user_management")
    public String redirectToUserManagement() {
        return "redirect:/users"; // Directly return users.html
    }
}