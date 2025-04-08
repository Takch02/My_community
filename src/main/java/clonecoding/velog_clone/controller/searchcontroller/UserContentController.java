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
import java.util.stream.Collectors;

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
        boolean updateAuth = user != null && user.getId() == post.getUserid();
        model.addAttribute("update_auth", updateAuth);

        // 댓글 삭제 권한 추가
        if (user != null) {
            // 로그인한 사용자가 작성한 댓글에 대해 삭제 가능 여부를 설정
            List<Comment> enrichedCommentList = commentList.stream()
                    .map(comment -> {
                        comment.setDeletable(comment.getUserid() == user.getId());  // Comment DTO에 deletable 필드에 true/false 넣기
                        return comment;
                    })
                    .collect(Collectors.toList());
            model.addAttribute("commentList", enrichedCommentList);
        } else {
            // 로그인하지 않은 경우 삭제 불가
            commentList.forEach(comment -> comment.setDeletable(false));  // 기본값 false 설정
            model.addAttribute("commentList", commentList);
        }


        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return "user/content";
    }
}
