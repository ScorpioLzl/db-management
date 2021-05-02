package com.database.demo.interceptor;

import com.database.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizedInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URI = {"/hello","/login","/signup"};
    private static final String[] AUTHOR_URI = {"/index_a","/books","/events"};
    private static final String[] CUSTOMER_URI = {"/index_c","/books","/events","/reservations","/insertReservation"};
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
            String role = user.getRole();
            if(role.equals("employee")){
                flag = true;
            }else if(role.equals("customer")){
                for (String s : CUSTOMER_URI) {
                    if (servletPath.contains(s)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    request.getRequestDispatcher("index_c").forward(request,response);
                }
            }else if(role.equals("author")){
                for (String s : AUTHOR_URI) {
                    if (servletPath.contains(s)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    request.getRequestDispatcher("index_a").forward(request,response);
                }
            }
        }
        return flag;
    }
}
