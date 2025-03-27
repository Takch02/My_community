package clonecoding.velog_clone.controller.searchcontroller;

import clonecoding.velog_clone.dto.Post;
import clonecoding.velog_clone.service.PostService;
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
    public String titleSearch(@PathVariable("title") String title, Model model) {

        Post post = postService.selectPostByTitle(title);

        if (post == null) {
            return "redirect:/home";
        }

        model.addAttribute("post", post);
        return "user/content";
    }
}
