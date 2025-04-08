package clonecoding.velog_clone.controller.commentcontroller;

import clonecoding.velog_clone.dto.Comment;
import clonecoding.velog_clone.dto.User;
import clonecoding.velog_clone.service.CommentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CreateCommentController {

    private final CommentService commentService;

    @PostMapping("/post/comment/{title}")
    public String postComment(@Valid Comment comment, BindingResult result, @RequestParam("postid") int postid,
                              @PathVariable("title") String title, HttpSession session, RedirectAttributes redirectAttributes) {
        
        // 비로그인 오류
        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("commentError", "로그인을 해야합니다");
            log.info("로그인 오류");
            return "redirect:/post/{title}";
        }
        // 바인딩 오류
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentError", "코멘트를 입력해주세요.");
            log.info("바인딩 오류");
            return "redirect:/post/{title}";
        }
        // 성공
        comment.setPostid(postid);
        comment.setUserid(user.getId());
        commentService.insertComment(comment);
        return "redirect:/post/{title}";
    }
}
