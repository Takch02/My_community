package clonecoding.velog_clone.controller.postcontroller.createcontroller;

import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.PostService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CreatePostController {

    private final PostService postService;

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
    public String createPost(@Valid Post post, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            return "post/create_post";
        }
        User user = (User) session.getAttribute("user");
        post.setUserid(user.getId());
        post.setUsername(user.getUsername());

        try {
            postService.insertPost(post);
        } catch (Exception e) {
            result.rejectValue("title", "title.error", "제목이 중복됩니다.");
            return "post/create_post";
        }

        return "redirect:/home";
    }
}
