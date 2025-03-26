package clonecoding.velog_clone.controller.homecontroller;

import clonecoding.velog_clone.dto.LoginForm;
import clonecoding.velog_clone.dto.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        User user = (User) session.getAttribute("user");

        if (user != null) {
            model.addAttribute("user", user);
            return "home";
        }
        else {
            model.addAttribute("loginForm", new LoginForm());
            return "home";

        }
    }

}
