package clonecoding.velog_clone.controller.usercontroller;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("create")
public class UserCreateController {


    private final UserService userService;

    @GetMapping
    public String create(Model model) {

        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping
    public String create(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("isAuth", false);
            return "user/create";
        }

        userService.insertUser(user);
        model.addAttribute("isAuth", true);
        return "redirect:/home";
    }
}
