package clonecoding.velog_clone.controller.postcontroller.updatecontroller;

import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UpdatePostController {

    private final PostService postService;
    
    // update form 으로 들어가는 로직 (form action="post" 로 지정해서 그럼)
    @PostMapping("/update")
    public String update(@RequestParam("auth")Boolean auth, @RequestParam("title")String title, Model model) {

        log.info("auth :[{}]", auth);
        if (auth) {
            Post post = postService.selectPostByTitle(title);
            model.addAttribute("post", post);
            return "post/update_post";
        }
        else {
            return "error/400";
        }
    }
    // 실제 update 로직
    @PostMapping("/update_post")
    public String update_post(@Valid Post post, BindingResult result, @RequestParam("id") int id) {

        if (result.hasErrors()) {
            return "redirect:/update_post";
        }
        Post selectPost = postService.selectPostById(id);

        selectPost.setTitle(post.getTitle());
        selectPost.setSubtitle(post.getSubtitle());
        selectPost.setContent(post.getContent());

        int result1 = postService.updatePost(selectPost);
        if (result1 == 0) {
            log.info("update post fail");
        }
        return "redirect:/home";
    }
}
