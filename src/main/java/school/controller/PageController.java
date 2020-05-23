package school.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import school.pojo.*;
import school.service.*;
import school.util.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class PageController {
    @Resource
    private JobService jobService;
    @Resource
    private NewsService newsService;
    @Resource
    private NewActionService newActionService;
    @Resource
    private LostService lostService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private AdminService adminService;
    @RequestMapping("/toAdmin.do")
    public String toAdmin(NewAction newAction, Model model, @RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.countAdmin(newAction));
        if(pageIndex != null){
            int a = Integer.valueOf(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = newActionService.getNewActionListAdmin(newAction,pageSupport0);
        model.addAttribute("pageSupportAdmin",pageSupport);
        return "/admin/backmain";
    }
    @RequestMapping("/toSysmain.do")
    public String toSysmain(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<Job> jobList = jobService.getJob();
        List<News> newsList = newsService.newListMain();
        List<NewAction> newActionList = newActionService.newActionMain();
        List<Lost> lostList = lostService.lostMain();
        List<Goods> goodsList = goodsService.findGoodsMain();
        session.setAttribute("jobList",jobList);
        session.setAttribute("newsList",newsList);
        session.setAttribute("newActionList",newActionList);
        session.setAttribute("lostList",lostList);
        session.setAttribute("goodsList",goodsList);
        return "/user/sysmain";
    }
    @RequestMapping("/tojobpublish.do")
    public String toJobPublish(){
        return "/user/jobpublish";
    }
    @RequestMapping("/topublish.do")
    public String toPublish(){
        return "/user/publish";
    }
    @RequestMapping("/toactionpublish.do")
    public String toAction(){
        return "/user/actionpublish";
    }
    @RequestMapping("/tolostpublish.do")
    public String toLostPublish(){
        return "/user/lostpublish";
    }
    @RequestMapping("/togoodspublish.do")
    public String toGoodsPublish(){
        return "/user/goodspublish";
    }
    @RequestMapping("/toadminchange.do")
    public String toAdminChange(@RequestParam("id")String id,Model model){
        int ids = Integer.valueOf(id);
        Admin admin = adminService.findAdmin(ids);
        model.addAttribute("adminlook",admin);
        return "/admin/backadmin";
    }
}
