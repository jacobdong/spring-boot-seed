package site.igeek.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jacobdong on 16/5/5.
 */
@Component
public class RootInterceptor implements HandlerInterceptor {

//    @Value("${management.context-path}")
//    private String monitorContextPath;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String requestURI = httpServletRequest.getRequestURI();
        System.out.println("======================= 全局拦截器 ======================= ");
//        System.out.println(monitorContextPath);
        System.out.println("当前拦截到的URL为" + requestURI);
        System.out.println("======================= ======== ======================= ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
