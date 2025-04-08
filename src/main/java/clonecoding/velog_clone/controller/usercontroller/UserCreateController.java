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

        // 아이디 중복
        try {
            userService.insertUser(user);
        } catch (Exception e){
            model.addAttribute("isAuth", false);
            model.addAttribute("user", user);
            bindingResult.rejectValue("username", "error.username", "아이디가 중복됩니다.");
            return "user/create";
        }
        
        // 성공 로직
        model.addAttribute("isAuth", true);
        return "redirect:/home";
    }
}
