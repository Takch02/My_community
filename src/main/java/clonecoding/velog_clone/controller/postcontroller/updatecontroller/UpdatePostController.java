package clonecoding.velog_clone.controller.postcontroller.updatecontroller;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UpdatePostController {

    private final PostService postService;

    @GetMapping("/update/{username}")
    public String update(@PathVariable String username, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (username.equals(user.getUsername())) {

            return "/post/update_post";
        }
        else {

        }
        return "post/update_post";
    }
}
