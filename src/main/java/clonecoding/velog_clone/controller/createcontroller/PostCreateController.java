package clonecoding.velog_clone.controller.createcontroller;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.dto.post.Post;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostCreateController {

    @GetMapping("/write")
    public String create(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/home";
        }
        else {
            model.addAttribute("post", new Post());
            return "post/create_post";
        }
    }

    @PostMapping("/write")
    public String createPost(HttpSession session, Model model) {

        return "home";
    }
}
