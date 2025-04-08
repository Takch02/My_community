package clonecoding.velog_clone.controller.commentcontroller;

import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DeleteCommentController {

    private final CommentService commentService;

    @PostMapping("/delete/comment")
    public String deleteComment(@RequestParam("commentId") int commentId, @RequestParam("title") String title,
                                @RequestParam("userid") int userid, HttpSession session, RedirectAttributes redirectAttributes) {

        log.info("title : [{}]", title);
        User user = (User) session.getAttribute("user");
        redirectAttributes.addAttribute("title", title);

        // userid 는 comment 를 작성한 user 의 id
        if (user == null || user.getId() != userid) {
            return "redirect:/post/{title}";
        } else {
            commentService.deleteComment(commentId);
            return "redirect:/post/{title}";
        }
    }
}
