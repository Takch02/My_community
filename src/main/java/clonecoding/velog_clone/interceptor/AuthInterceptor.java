package clonecoding.velog_clone.interceptor;

import clonecoding.velog_clone.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * session -> user 값이 존재(로그인 중) -> isAuth = true
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute("user");

        boolean isAuth = (user != null);
        request.setAttribute("isAuth", isAuth);

        log.info("isAuth: [{}]", isAuth);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if (modelAndView != null) {
            modelAndView.addObject("isAuth", request.getAttribute("isAuth"));
        }

        User user = (User) request.getSession().getAttribute("user");
        log.info("user: [{}]", user);

        if (user != null && modelAndView != null) {
            modelAndView.addObject("user", user);
        }
    }
}
