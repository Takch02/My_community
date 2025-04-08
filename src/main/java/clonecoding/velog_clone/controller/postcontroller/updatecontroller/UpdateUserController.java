package clonecoding.velog_clone.controller.postcontroller.updatecontroller;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UpdateUserController {

    private final UserService userService;

    @GetMapping("/update/{username}")
    public String update(@PathVariable("username") String username, HttpSession session) {

        User user = (User) session.getAttribute("user");

        boolean isAuth = user.getUsername().equals(username);

        if (!isAuth) {
            return "error/500";
        } else {
            return "/user/update_user";
        }
    }
    
    // 회원 인증 로직은 username 이 아닌 id 값으로 비교한다. username 이 바뀔 수 있기 떄문
    @PostMapping("update_user")
    public String updateUser(@Valid User user, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return "/user/update_user";
        }
        log.info("username : [{}]", user.getUsername());

        User session_user = (User) session.getAttribute("user");

        if (session_user == null) {
            return "error/500";
        }

        user.setId(session_user.getId());
        userService.updateUser(user);

        session.setAttribute("user", user);
        return "redirect:/home";
    }
}
