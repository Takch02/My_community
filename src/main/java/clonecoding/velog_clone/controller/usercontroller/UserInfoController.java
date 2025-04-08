package clonecoding.velog_clone.controller.usercontroller;

import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserInfoController {

    private final PostService postService;
    
    /**
     * 해당 유저의 정보를 보여줍니다.
     */
    @GetMapping("/userinfo/{username}")
    public String userinfo(@PathVariable("username") String username, Model model, HttpSession session) {
        log.info("usernmae = [{}]", username);
        User user =(User) session.getAttribute("user");
        // 본인 확인 로직. 본인이 맞면 true
        model.addAttribute("isOwner", user != null && user.getUsername().equals(username));

        // 본인 확인과 관계없이 해당 유저의 post 를 보여줌
        List<Post> postByName = postService.getPostByName(username);
        model.addAttribute("posts", postByName);

        model.addAttribute("username", username);
        return "user/userinfo";
    }
}
