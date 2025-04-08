package clonecoding.velog_clone.controller.postcontroller.deletecontroller;

import clonecoding.velog_clone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DeletePostController {

    private final PostService postService;

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id, @RequestParam("auth") Boolean auth) {

        if (auth) {
            postService.deletePost(id);
        } else {
            return "error/400";
        }
        return "redirect:/home";
    }
}
