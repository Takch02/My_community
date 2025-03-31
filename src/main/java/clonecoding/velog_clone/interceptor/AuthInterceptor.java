package clonecoding.velog_clone.interceptor;

import clonecoding.velog_clone.dto.LoginForm;
import clonecoding.velog_clone.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        boolean isAuth = (user != null);
        request.setAttribute("isAuth", isAuth);
        log.info("request url : [{}]", request.getRequestURL());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }
        log.info("response url : [{}]", request.getRequestURL());

        User user = (User) request.getSession().getAttribute("user");
        Boolean isAuth = (Boolean) request.getAttribute("isAuth");
        log.info("postHandle - isAuth: [{}]", isAuth);

        modelAndView.addObject("isAuth", isAuth);

        log.info("postHandle - user: [{}]", user);

        if (user != null) {
            modelAndView.addObject("user", user);
        } else if (isAuth != null && !isAuth) {
            LoginForm loginForm = new LoginForm();
            modelAndView.addObject("loginForm", loginForm);
        }
    }
}