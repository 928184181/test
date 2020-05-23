package school.util;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import school.pojo.Admin;
import school.pojo.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        Admin admin = (Admin)session.getAttribute("admin");
        if(null != user){
            return true;
        }else if(null != admin){
            return true;
        }else{
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }

    }
}

