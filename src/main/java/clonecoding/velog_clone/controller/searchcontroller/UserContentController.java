package clonecoding.velog_clone.controller.searchcontroller;

import clonecoding.velog_clone.dto.Comment;
import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.CommentService;
import clonecoding.velog_clone.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserContentController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/post/{title}")
    public String titleSearch(@PathVariable("title") String title, HttpSession session, Model model) {

        Post post = postService.selectPostByTitle(title);  // post 하나 가져옴
        List<Comment> commentList = commentService.getPostByName(post.getId());  // 해당 post 의 댓글 모두 가져옴

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
        model.addAttribute("commentList", commentList);
        model.addAttribute("comment", new Comment());
        return "user/content";
    }
}
