package clonecoding.velog_clone.controller.timeviewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 하루, 주, 달 마다 보여주는 피드가 다르다.
 */
@Controller
@RequestMapping("/trending")
public class TrendingController {

    @GetMapping("/today")
    public String today() {
        return "trending/today";
    }

    @GetMapping("/week")
    public String week() {
        return "trending/week";
    }

    @GetMapping("/month")
    public String month() {
        return "trending/month";
    }
}
