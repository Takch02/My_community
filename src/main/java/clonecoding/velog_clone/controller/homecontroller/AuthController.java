package clonecoding.velog_clone.controller.homecontroller;

import clonecoding.velog_clone.dto.LoginForm;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    /**
     * 로그인 정보를 가져와서 DB 에서 조회함.
     */
    private final UserService userService;

    @PostMapping("/home")
    public String home(@Valid LoginForm loginForm, BindingResult bindingResult, Model model, HttpSession session) {

        // binding error
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginForm", loginForm);
            return "/home";
        }

        // id or password error
        User userByName = userService.getUserByName(loginForm.getUsername());

        if (userByName == null || !userByName.getPassword().equals(loginForm.getPassword())) {
            bindingResult.reject("loginFailed", "아이디 또는 비밀번호가 잘못되었습니다.");
            model.addAttribute("loginForm", loginForm); // 누락된 부분 추가
            return "/home";
        }

        // Login success
        session.setAttribute("user", userByName);
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/home";
    }
}
