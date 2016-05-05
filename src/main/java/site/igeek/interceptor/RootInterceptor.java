package site.igeek.interceptor;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${management.context-path}")
    private String monitorContextPath;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("======================= 服务器监控上下文路径为 ======================= ");
        System.out.println(monitorContextPath);
        System.out.println("======================= =================== ======================= ");

        String requestURI = httpServletRequest.getRequestURI();

        if (requestURI.contains(monitorContextPath)) {
            //TODO 暂时收起监控权限
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
