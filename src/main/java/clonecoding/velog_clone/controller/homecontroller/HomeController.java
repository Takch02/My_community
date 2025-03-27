package clonecoding.velog_clone.controller.homecontroller;

import clonecoding.velog_clone.dto.LoginForm;
import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeController {

    private final PostService postService;

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        selectAllPost(model);
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

    private void selectAllPost(Model model) {

        List<Post> allPosts = postService.getAllPosts();
        model.addAttribute("posts", allPosts);
    }

}
