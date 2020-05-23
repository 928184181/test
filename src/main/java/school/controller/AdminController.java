package school.controller;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import school.pojo.*;
import school.service.*;
import school.util.PageSupport;
import javax.annotation.Resource;
@Controller
public class AdminController {
    @Resource
    private NewActionService newActionService;
    @Resource
    private NewsService newsService;
    @Resource
    private LostService lostService;
    @Resource
    private UserService userService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private JobService jobService;
    @Resource
    private AdminService adminService;
    @RequestMapping("/adminchange.do")
    public String change(Admin admin){
        adminService.change(admin);
        return "redirect:/toAdmin.do";
    }
    @RequestMapping("/actionadminaj.do")
    @ResponseBody
    public String actionAdmin(NewAction newAction, @RequestParam(value = "pageIndex",required = false)String pageIndex, @RequestParam(value = "school",required = false)String school, @RequestParam(value = "status",required = false)String status){
        if(school!=null){
            int id = Integer.parseInt(school);
            if(id !=0 ){
                newAction.setSchoolId(id);
            }
        }
        if(status!=null){
            int id = Integer.parseInt(status);
            if(id !=0 ){
                newAction.setStatus(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.countAdmin(newAction));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.parseInt(pageIndex));
        }
        PageSupport pageSupport = newActionService.getNewActionListAdmin(newAction,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/adminactionlook.do")
    public String adminActionLook(@RequestParam("id") String id,@RequestParam("pageIndex")String pageIndex, Model model){
        int actionId = Integer.parseInt(id);
        NewAction newAction = newActionService.findAction(actionId);
        model.addAttribute("adminaction",newAction);
        model.addAttribute("pageIndex",pageIndex);
        return "/admin/backactionlook";
    }
    @RequestMapping("/actionadmindel.do")
    @ResponseBody
    public String actionDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,NewAction newAction){
        int ids = Integer.valueOf(id);
        newActionService.delAction(ids);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.countAdmin(newAction));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = newActionService.getNewActionListAdmin(newAction,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/adminactionpass.do")
    public String adminActionPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,NewAction newAction,Model model){
        int ids = Integer.valueOf(id);
        newActionService.pass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.countAdmin(newAction));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = newActionService.getNewActionListAdmin(newAction,pageSupport0);
        model.addAttribute("pageSupportAdmin",pageSupport);
        return "/admin/backmain";
    }
    @RequestMapping("/adminactionnopass.do")
    public String adminActionNoPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,NewAction newAction,Model model){
        int ids = Integer.valueOf(id);
        newActionService.noPass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.countAdmin(newAction));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = newActionService.getNewActionListAdmin(newAction,pageSupport0);
        model.addAttribute("pageSupportAdmin",pageSupport);
        return "/admin/backmain";
    }
    @RequestMapping("/tobacknews.do")
    public String toBackNews(News news, Model model, @RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newsService.countAdmin(news));
        if(pageIndex != null){
            int a = Integer.valueOf(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = newsService.getNewsListAdmin(news,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backnews";
    }
    @RequestMapping("/backnewslook.do")
    public String backNewsLook(@RequestParam("id") String id,@RequestParam("pageIndex")String pageIndex, Model model){
        int newsId = Integer.valueOf(id);
        News news = newsService.findNewsById(newsId);
        model.addAttribute("backnews",news);
        model.addAttribute("pageIndex",pageIndex);
        return "/admin/backnewslook";
    }
    @RequestMapping("/backnewsaj.do")
    @ResponseBody
    public String backNewsAj(News news, @RequestParam(value = "pageIndex",required = false)String pageIndex, @RequestParam(value = "school",required = false)String school, @RequestParam(value = "status",required = false)String status){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                news.setSchoolId(id);
            }
        }
        if(status!=null){
            int id = Integer.valueOf(status);
            if(id !=0 ){
                news.setStatus(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newsService.countAdmin(news));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = newsService.getNewsListAdmin(news,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backnewsdel.do")
    @ResponseBody
    public String backNewsDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,News news){
        int ids = Integer.valueOf(id);
        newsService.delNews(ids);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newsService.countAdmin(news));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = newsService.getNewsListAdmin(news,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backnewspass.do")
    public String backNewsPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,News news,Model model){
        int ids = Integer.valueOf(id);
        newsService.pass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newsService.countAdmin(news));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = newsService.getNewsListAdmin(news,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backnews";
    }
    @RequestMapping("/backnewsnopass.do")
    public String backNewsNoPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,News news,Model model){
        int ids = Integer.valueOf(id);
        newsService.noPass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newsService.countAdmin(news));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = newsService.getNewsListAdmin(news,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backnews";
    }
    @RequestMapping("/tobacklost.do")
    public String toBackLost(Lost lost, Model model, @RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.countAdmin(lost));
        if(pageIndex != null){
            int a = Integer.valueOf(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = lostService.getLostListAdmin(lost,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backlost";
    }
    @RequestMapping("/backlostlook.do")
    public String backlostLook(@RequestParam("id") String id,@RequestParam("pageIndex")String pageIndex, Model model){
        int lostId = Integer.valueOf(id);
        Lost lost = lostService.findLostById(lostId);
        model.addAttribute("backlost",lost);
        model.addAttribute("pageIndex",pageIndex);
        return "/admin/backlostlook";
    }
    @RequestMapping("/backlostaj.do")
    @ResponseBody
    public String backLostAj(Lost lost, @RequestParam(value = "pageIndex",required = false)String pageIndex, @RequestParam(value = "school",required = false)String school, @RequestParam(value = "status",required = false)String status){
        if(school!=null){
            int id = Integer.parseInt(school);
            if(id !=0 ){
                lost.setSchoolId(id);
            }
        }
        if(status!=null){
            int id = Integer.valueOf(status);
            if(id !=0 ){
                lost.setStatus(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.countAdmin(lost));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = lostService.getLostListAdmin(lost,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backlostdel.do")
    @ResponseBody
    public String backLostDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,Lost lost){
        int ids = Integer.parseInt(id);
        lostService.delLost(ids);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.countAdmin(lost));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = lostService.getLostListAdmin(lost,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backlostpass.do")
    public String backLostPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,Lost lost,Model model){
        int ids = Integer.valueOf(id);
        lostService.pass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.countAdmin(lost));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = lostService.getLostListAdmin(lost,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backlost";
    }
    @RequestMapping("/backlostnopass.do")
    public String backLostNoPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,Lost lost,Model model){
        int ids = Integer.valueOf(id);
        lostService.noPass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.countAdmin(lost));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = lostService.getLostListAdmin(lost,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backlost";
    }
    @RequestMapping("/tobackjob.do")
    public String toBackJob(Job job, Model model, @RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.countAdmin(job));
        if(pageIndex != null){
            int a = Integer.valueOf(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = jobService.getJobListAdmin(job,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backjob";
    }
    @RequestMapping("/backjoblook.do")
    public String backJobLook(@RequestParam("id") String id,@RequestParam("pageIndex")String pageIndex, Model model){
        int jId = Integer.valueOf(id);
        Job job = jobService.findJobById(jId);
        model.addAttribute("backjob",job);
        model.addAttribute("pageIndex",pageIndex);
        return "/admin/backjoblook";
    }
    @RequestMapping("/backjobaj.do")
    @ResponseBody
    public String backJobAj(Job job, @RequestParam(value = "pageIndex",required = false)String pageIndex, @RequestParam(value = "school",required = false)String school, @RequestParam(value = "status",required = false)String status){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                job.setSchoolId(id);
            }
        }
        if(status!=null){
            int id = Integer.valueOf(status);
            if(id !=0 ){
                job.setStatus(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.countAdmin(job));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = jobService.getJobListAdmin(job,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backjobdel.do")
    @ResponseBody
    public String backJobDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,Job job){
        int ids = Integer.valueOf(id);
        jobService.delJob(ids);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.countAdmin(job));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = jobService.getJobListAdmin(job,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backjobpass.do")
    public String backJobPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,Job job,Model model){
        int ids = Integer.valueOf(id);
        jobService.pass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.countAdmin(job));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = jobService.getJobListAdmin(job,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backjob";
    }
    @RequestMapping("/backjobnopass.do")
    public String backJobNoPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,Job job,Model model){
        int ids = Integer.parseInt(id);
        jobService.noPass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.countAdmin(job));
        int a = Integer.parseInt(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = jobService.getJobListAdmin(job,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backjob";
    }
    @RequestMapping("/tobackgoods.do")
    public String toBackGoods(Goods goods, Model model, @RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(goodsService.countAdmin(goods));
        if(pageIndex != null){
            int a = Integer.parseInt(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = goodsService.getGoodsListAdmin(goods,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backgoods";
    }
    @RequestMapping("/backgoodslook.do")
    public String backGoodsLook(@RequestParam("id") String id,@RequestParam("pageIndex")String pageIndex, Model model){
        int jId = Integer.valueOf(id);
        Goods goods = goodsService.findGoodsById(jId);
        model.addAttribute("backgoods",goods);
        model.addAttribute("pageIndex",pageIndex);
        return "/admin/backgoodslook";
    }
    @RequestMapping("/backgoodsaj.do")
    @ResponseBody
    public String backGoodsAj(Goods goods, @RequestParam(value = "pageIndex",required = false)String pageIndex, @RequestParam(value = "school",required = false)String school, @RequestParam(value = "status",required = false)String status){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                goods.setSchoolId(id);
            }
        }
        if(status!=null){
            int id = Integer.valueOf(status);
            if(id !=0 ){
                goods.setStatus(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(goodsService.countAdmin(goods));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = goodsService.getGoodsListAdmin(goods,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backgoodsdel.do")
    @ResponseBody
    public String backGoodsDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,Goods goods){
        int ids = Integer.valueOf(id);
        goodsService.delGoods(ids);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(goodsService.countAdmin(goods));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = goodsService.getGoodsListAdmin(goods,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backgoodspass.do")
    public String backGoodsPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,Goods goods,Model model){
        int ids = Integer.valueOf(id);
        goodsService.pass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(goodsService.countAdmin(goods));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = goodsService.getGoodsListAdmin(goods,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backgoods";
    }
    @RequestMapping("/backgoodsnopass.do")
    public String backGoodsNoPass(@RequestParam("id")String id,@RequestParam("pageIndex")String pageIndex,Goods goods,Model model){
        int ids = Integer.valueOf(id);
        goodsService.noPass(ids);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(goodsService.countAdmin(goods));
        int a = Integer.valueOf(pageIndex);
        pageSupport0.setCurrentPage(a);
        PageSupport pageSupport = goodsService.getGoodsListAdmin(goods,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backgoods";
    }
    @RequestMapping("/tobackusers.do")
    public String toBackUser(Users users, Model model, @RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(userService.countAdmin(users));
        if(pageIndex != null){
            int a = Integer.valueOf(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = userService.getUsersAdmin(users,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/admin/backusers";
    }
    @RequestMapping("/backuserslook.do")
    public String backUsersLook(@RequestParam("id") String id,@RequestParam("pageIndex")String pageIndex, Model model){
        int jId = Integer.valueOf(id);
        Users users = userService.findUsers(jId);
        model.addAttribute("backusers",users);
        model.addAttribute("pageIndex",pageIndex);
        return "/admin/backuserslook";
    }
    @RequestMapping("/backusersaj.do")
    @ResponseBody
    public String backGoodsAj(Users users, @RequestParam(value = "pageIndex",required = false)String pageIndex, @RequestParam(value = "school",required = false)String school){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                users.setSchoolId(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(userService.countAdmin(users));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = userService.getUsersAdmin(users,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/backusersdel.do")
    @ResponseBody
    public String backUsersDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,Users users){
        int ids = Integer.valueOf(id);
        userService.delUser(ids);
        goodsService.delByUser(ids);
        jobService.delByUser(ids);
        lostService.delByUser(ids);
        newActionService.delByUser(ids);
        newsService.delByUser(ids);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(userService.countAdmin(users));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = userService.getUsersAdmin(users,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
}