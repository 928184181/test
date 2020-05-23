package school.controller;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import school.pojo.Lost;
import school.pojo.NewAction;
import school.service.LostService;
import school.util.PageSupport;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller
public class LostController {
    @Resource
    private LostService lostService;
    @RequestMapping("/tolostandfound.do")
    public String toLostAndFound(Lost lost,Model model){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(12);
        pageSupport0.setTotalCount(lostService.count(lost));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = lostService.getLostList(lost,pageSupport0);
        model.addAttribute("pageSupportLost",pageSupport);
        return "/user/lostandfound";
    }
    @RequestMapping("/tolostaj.do")
    @ResponseBody
    public String toLostAj(Lost lost,@RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "school",required = false)String school){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                lost.setSchoolId(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(12);
        pageSupport0.setTotalCount(lostService.count(lost));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = lostService.getLostList(lost,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/mylost.do")
    public String toMyLost(Lost lost,Model model, @RequestParam("userId")String userId){
        int id = Integer.valueOf(userId);
        lost.setUserId(id);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.myCount(lost));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = lostService.getMyLostList(lost,pageSupport0);
        model.addAttribute("pageSupportMyLost",pageSupport);
        return "/user/mylost";
    }
    @RequestMapping("/mylostaj.do")
    @ResponseBody
    public String myLostAj(Lost lost,@RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.myCount(lost));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = lostService.getMyLostList(lost,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/lostpublish.do")
    public String toLostPublish(@ModelAttribute("Lost")Lost lost, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, Model model) throws IOException {
        String targetPath = request.getServletContext().getRealPath("statics" + File.separator + "lost");
        if(!multipartFile.isEmpty()){
            String sourceFileName = multipartFile.getOriginalFilename();//源文件名
            String type = FilenameUtils.getExtension(sourceFileName);//后缀
            String uuid = UUID.randomUUID().toString().replace("-", "").substring(10);
            String targetName = uuid + "." + type;
            File targetFile = new File(targetPath, targetName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
                multipartFile.transferTo(targetFile);
            }
            lost.setPictureName(targetName);
            lost.setPictureAdd(targetPath);
        }
        lostService.addLost(lost);
        model.addAttribute("lostPublish","发布成功");
        return "/user/lostpublish";
    }
    @RequestMapping("/lostdetails.do")
    public String lostDetail(@RequestParam("id")String id,Model model){
        int lostId = Integer.valueOf(id);
        Lost lost = lostService.findLostById(lostId);
        model.addAttribute("lost",lost);
        return "/user/lostdetails";
    }
    @RequestMapping("/tomylostlook.do")
    public String toMyLostLook(@RequestParam("id")String id,Model model){
        int lostId = Integer.valueOf(id);
        Lost lost = lostService.findLostById(lostId);
        model.addAttribute("myLostLook",lost);
        return "/user/lostlook";
    }
    @RequestMapping("/mylostdel.do")
    @ResponseBody
    public String myLostDel(@RequestParam("id") String id,@RequestParam("pageIndex") String pageIndex,Lost lost){
        int lostId = Integer.valueOf(id);
        lostService.delLost(lostId);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(lostService.myCount(lost));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = lostService.getMyLostList(lost,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/lostclaim.do")
    public String claim(@RequestParam("id")String id){
        int lostId = Integer.valueOf(id);
        lostService.claim(lostId);
        return "redirect:/tolostandfound.do";
    }
}