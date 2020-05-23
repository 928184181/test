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
import school.pojo.NewAction;
import school.service.NewActionService;
import school.util.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
@Controller
public class NewActionController {
    @Resource
    private NewActionService newActionService;
    @RequestMapping("/actionpublish.do")
    public String actionPublish(@ModelAttribute("NewAction") NewAction newAction, @RequestParam("file") MultipartFile[] multipartFile, HttpServletRequest request, Model model) throws IOException {
        String targetPath = request.getServletContext().getRealPath("statics" + File.separator + "action");
        for(int i=0 ;i<multipartFile.length;i++) {
            if(!multipartFile[i].isEmpty()){
                String sourceFileName = multipartFile[i].getOriginalFilename();//源文件名
                String type = FilenameUtils.getExtension(sourceFileName);//后缀
                String uuid = UUID.randomUUID().toString().replace("-", "").substring(10);
                String targetName = uuid + "." + type;
                File targetFile = new File(targetPath, targetName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                    multipartFile[i].transferTo(targetFile);
                }
                if (i == 0) {
                    newAction.setPictureName1(targetName);
                    newAction.setPictureAdd1(targetPath);
                } else if (i == 1) {
                    newAction.setPictureName2(targetName);
                    newAction.setPictureAdd2(targetPath);
                } else if (i == 2) {
                    newAction.setPictureName3(targetName);
                    newAction.setPictureAdd3(targetPath);
                } else if(i == 3) {
                    newAction.setPictureName4(targetName);
                    newAction.setPictureAdd4(targetPath);
                }
            }
        }
        Date date = new Date();
        newAction.setTime(date);
        newAction.setClicks(0);
        newAction.setStatus(3);
        newActionService.addNewAction(newAction);
        model.addAttribute("actionPublishSuccess","发布成功！");
        return "/user/actionpublish";
    }
    @RequestMapping("/tonewaction.do")
    public String toNewAction(NewAction newAction,Model model){
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.count(newAction));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = newActionService.getNewActionList(newAction,pageSupport0);
        model.addAttribute("pageSupportNewAction",pageSupport);
        return "/user/newaction";
    }
    @RequestMapping("/newactionlistaj.do")
    @ResponseBody
    public String toNewActionAj(NewAction newAction,@RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "school",required = false)String school){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                newAction.setSchoolId(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.count(newAction));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = newActionService.getNewActionList(newAction,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    //我的发布
    @RequestMapping("/mynewactionpublish.do")
    public String myNewsPublish(NewAction newAction, Model model, @RequestParam("userId")String userId){
        int id = Integer.valueOf(userId);
        newAction.setUserId(id);
        PageSupport<NewAction> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.myCount(newAction));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = newActionService.getMyNewActionList(newAction,pageSupport0);
        model.addAttribute("pageSupportMyNewsAction",pageSupport);
        return "/user/myaction";
    }
    @RequestMapping("/mynewactionpublishaj.do")
    @ResponseBody
    public String myNewActionListAj(NewAction newAction,@RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.myCount(newAction));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = newActionService.getMyNewActionList(newAction,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/toactionlook.do")
    public String actionLook(@RequestParam("id") String id,Model model){
        int newActionId = Integer.valueOf(id);
        NewAction newAction = newActionService.findNewActionById(newActionId);
        model.addAttribute("newActionlook",newAction);
        return "/user/actionlook";
    }
    @RequestMapping("/mynewactionlook.do")
    public String myNewActionLook(@RequestParam("id") String id,Model model){
        int actionId = Integer.valueOf(id);
        NewAction newAction = newActionService.myNewActionById(actionId);
        model.addAttribute("myActionlook",newAction);
        return "/user/myactionlook";
    }
    @RequestMapping("/mynewsactiondel.do")
    @ResponseBody
    public String myNewActionDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex, NewAction newAction){
        int newId = Integer.valueOf(id);
        newActionService.delAction(newId);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(newActionService.myCount(newAction));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = newActionService.getMyNewActionList(newAction,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
}