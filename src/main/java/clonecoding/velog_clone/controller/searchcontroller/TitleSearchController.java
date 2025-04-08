package clonecoding.velog_clone.controller.searchcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class TitleSearchController {

    @PostMapping("/search")
    public String searchPost(Model model) {

        return "search/title";
    }
}
