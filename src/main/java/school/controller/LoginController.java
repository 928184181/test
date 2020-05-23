package school.controller;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import school.pojo.Admin;
import school.pojo.Users;
import school.service.AdminService;
import school.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "adminService")
    private AdminService adminService;
    //登录
    @RequestMapping("/log.do")
    @ResponseBody
    public String login(@RequestParam("userCode")String userCode,@RequestParam("password")String password, @RequestParam(value = "admin",required = false) String admin,HttpServletRequest request){
        HttpSession session = request.getSession();
        if(admin.equals("admin")){
            Admin admin1 = new Admin();
            admin1.setUserCode(userCode);
            admin1.setPassword(password);
            Admin admin2 = adminService.login(admin1);
            if(admin2==null){
                return "error";
            }else {
                session.setAttribute("admin",admin2);
                return "admin";
            }
        }else {
            Users users = new Users();
            users.setUserCode(userCode);
            users.setPassword(password);
            Users users1 = userService.login(users);
            if(users1 == null){
                return "error";
            }else {
                session.setAttribute("user",users1);
                return "user";
            }
        }
    }
    //验证码
    @RequestMapping("/yanzm.do")
    @ResponseBody
    public String login(String yzm, HttpServletRequest request){
        String mgs = "";
        //图片里的验证码， 即正确的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //用户输入的验证码
        if (yzm == null || !yzm.equalsIgnoreCase(verifyCodeExpected)) {
            mgs = "error";
        }else {
            mgs = "true";
        }
        return mgs;
    }
    //注册
    @RequestMapping("/register.do")
    public String register(Users users){
        int a = userService.register(users);
        if(a>0){
            return "redirect:/login.jsp";
        }else {
            return "redirect:/register.jsp";
        }
    }
    @RequestMapping("/usercode.do")
    @ResponseBody
    public String usercode(String userCode){
        Users users = userService.registerCode(userCode);
        System.out.println(users);
        if(users == null){
            return "";
        }else {
            return "error";
        }
    }
}

