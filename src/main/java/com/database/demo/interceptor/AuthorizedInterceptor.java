package com.database.demo.interceptor;

import com.database.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizedInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URI = {"/hello","/login","/signup"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String servletPath = request.getServletPath();
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }
        if(!flag){
            User user = (User) request.getSession().getAttribute("userSession");
            if(user == null){
                request.getRequestDispatcher("hello").forward(request,response);
                return flag;
            }
            else flag = true;
        }
        return flag;
    }
}
