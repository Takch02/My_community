package clonecoding.velog_clone.controller.searchcontroller;

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

@Controller
@RequiredArgsConstructor
@Slf4j
public class HomeTitleController {

    private final PostService postService;

    @GetMapping("/post/{title}")
    public String titleSearch(@PathVariable("title") String title, HttpSession session, Model model) {

        Post post = postService.selectPostByTitle(title);

        if (post == null) {
            return "redirect:/home";
        }

        User user = (User) session.getAttribute("user");

        // 글 작성자가 자신의 글을 방문한 경우 '글 수정'이 가능하게 한다.
        if (user == null || user.getId() != post.getUserid()) {
            model.addAttribute("update_auth", false);
        } else {
            model.addAttribute("update_auth", true);
        }
        model.addAttribute("post", post);
        return "user/content";
    }
}
