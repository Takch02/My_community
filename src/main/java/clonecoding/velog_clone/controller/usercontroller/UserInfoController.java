package clonecoding.velog_clone.controller.usercontroller;

import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserInfoController {

    private final PostService postService;
    
    /**
     * 해당 유저의 정보를 보여줍니다.
     */
    @GetMapping("/userinfo/{username}")
    public String userinfo(@PathVariable("username") String username, Model model, HttpSession session) {

        User user =(User) session.getAttribute("user");

        if (user == null || !user.getUsername().equals(username)) {

        }
        List<Post> postByName = postService.getPostByName(username);
        model.addAttribute("posts", postByName);
        return "user/userinfo";
    }
}
